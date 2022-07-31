package com.thalasoft.learnintouch.data.jpa.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.DateExpression;
import com.mysema.query.types.template.DateTemplate;
import com.thalasoft.learnintouch.data.jpa.domain.ElearningSubscription;
import com.thalasoft.learnintouch.data.jpa.domain.QElearningSession;
import com.thalasoft.learnintouch.data.jpa.domain.QElearningSubscription;
import com.thalasoft.learnintouch.data.jpa.domain.QUserAccount;
import com.thalasoft.learnintouch.data.jpa.domain.UserAccount;

public class ElearningSubscriptionRepositoryImpl implements ElearningSubscriptionRepositoryCustom {

    @Autowired
    private ElearningSubscriptionRepository elearningSubscriptionRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<ElearningSubscription> search(String searchTerm, Pageable page) {
    	JPAQuery query = new JPAQuery(elearningSubscriptionRepository.getEntityManager());
    	QElearningSubscription qElearningSubscription = QElearningSubscription.elearningSubscription;
    	QUserAccount qUserAccount = QUserAccount.userAccount;
    	query.from(qElearningSubscription)
   			.innerJoin(qElearningSubscription.userAccount, qUserAccount);
    	BooleanBuilder builder = new BooleanBuilder();
    	builder.or(qUserAccount.id.like(searchTerm)).or(qUserAccount.firstname.contains(searchTerm)).or(qUserAccount.lastname.contains(searchTerm)).or(qUserAccount.email.value.contains(searchTerm));
		if (searchTerm.contains(" ")) {
			String[] bits = searchTerm.split(" ");
			String firstname = bits[0];
			String lastname = bits[1];
			builder.or(qUserAccount.firstname.contains(firstname).and(qUserAccount.lastname.contains(lastname)));
		}
		query.where(builder);
		query.orderBy(qUserAccount.lastname.asc(), qUserAccount.firstname.asc(), qElearningSubscription.subscriptionDate.desc());
		List<ElearningSubscription> resultList = query.list(qElearningSubscription);
        long total = resultList.size();        
        query.offset(page.getOffset());
        query.limit(page.getPageSize());
        resultList = query.list(qElearningSubscription);
        Page<ElearningSubscription> elearningSubscriptions = new PageImpl<ElearningSubscription>(resultList, page, total);
        return elearningSubscriptions;
   }

//    @Override
//    @Transactional(readOnly = true)
//    public Page<ElearningSubscription> search(String searchTerm, Pageable page) {
//         String sqlStatement = "SELECT es FROM ElearningSubscription es, UserAccount ua WHERE es.userAccount.id = ua.id AND (LOWER(ua.firstname) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(ua.lastname) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR LOWER(ua.email) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR ua.id = :searchTerm";
//         if (searchTerm.contains(" ")) {
//             String[] bits = searchTerm.split(" ");
//             String firstname = bits[0];
//             String lastname = bits[1];
//             sqlStatement += " OR (LOWER(ua.firstname) LIKE LOWER(CONCAT('%', " + firstname + ", '%')) AND LOWER(ua.lastname) LIKE LOWER(CONCAT('%', " + lastname + ", '%')))";
//         }
//         sqlStatement += ") ORDER BY ua.lastname, ua.firstname, es.subscriptionDate DESC";
//         
//         TypedQuery<ElearningSubscription> query = elearningSubscriptionRepository.getEntityManager().createQuery(sqlStatement, ElearningSubscription.class);
//
//         query.setParameter("searchTerm", searchTerm);
//         
//         List<ElearningSubscription> resultList = query.getResultList();
//         long total = resultList.size();
//         query.setFirstResult(page.getOffset());
//         query.setMaxResults(page.getPageSize());
//         resultList = query.getResultList();
//         Page<ElearningSubscription> elearningSubscriptions = new PageImpl<ElearningSubscription>(resultList, page, total);
//
//         return elearningSubscriptions;
//    }

    @Override
    @Transactional(readOnly = true)
    public Page<ElearningSubscription> searchWithDistinctUserAccounts(String searchTerm, Pageable page) {
    	JPAQuery query = new JPAQuery(elearningSubscriptionRepository.getEntityManager());
    	QElearningSubscription qElearningSubscription = QElearningSubscription.elearningSubscription;
    	QUserAccount qUserAccount = QUserAccount.userAccount;
    	query.from(qElearningSubscription)
   			.join(qElearningSubscription.userAccount, qUserAccount);
    	BooleanBuilder builder = new BooleanBuilder();
    	builder.or(qUserAccount.id.like(searchTerm)).or(qUserAccount.firstname.contains(searchTerm)).or(qUserAccount.lastname.contains(searchTerm)).or(qUserAccount.email.value.contains(searchTerm));
		if (searchTerm.contains(" ")) {
			String[] bits = searchTerm.split(" ");
			String firstname = bits[0];
			String lastname = bits[1];
			builder.or(qUserAccount.firstname.contains(firstname).and(qUserAccount.lastname.contains(lastname)));
		}
		query.where(builder);
		query.groupBy(qUserAccount.id);
		query.orderBy(qUserAccount.lastname.asc(), qUserAccount.firstname.asc(), qElearningSubscription.subscriptionDate.desc());
		List<ElearningSubscription> resultList = query.list(qElearningSubscription);
        long total = resultList.size();        
        query.offset(page.getOffset());
        query.limit(page.getPageSize());
        resultList = query.list(qElearningSubscription);
        Page<ElearningSubscription> elearningSubscriptions = new PageImpl<ElearningSubscription>(resultList, page, total);
        return elearningSubscriptions;
    }

    public Long countUserAccountOpenedSubscription(UserAccount userAccount, String systemDate) {
    	JPAQuery query = new JPAQuery(elearningSubscriptionRepository.getEntityManager());
    	QElearningSubscription qElearningSubscription = QElearningSubscription.elearningSubscription;
    	QElearningSession qElearningSession = QElearningSession.elearningSession;
    	query.from(qElearningSubscription)
   			.leftJoin(qElearningSubscription.elearningSession, qElearningSession);
    	BooleanBuilder builder = new BooleanBuilder();
    	builder.and(qElearningSubscription.userAccount.eq(userAccount));
    	DateExpression<Date> qSystemDate = DateTemplate.create(Date.class, systemDate);
    	DateExpression<Date> qOpeningDate = DateTemplate.create(Date.class, "convert(date, {0})", qElearningSession.openingDate);
    	DateExpression<Date> qClosingDate = DateTemplate.create(Date.class, "convert(date, {0})", qElearningSession.closingDate);
    	DateExpression<Date> qSubscriptionDate = DateTemplate.create(Date.class, "convert(date, {0})", qElearningSubscription.subscriptionDate);
    	DateExpression<Date> qSubscriptionClose = DateTemplate.create(Date.class, "convert(date, {0})", qElearningSubscription.subscriptionClose);
    	Predicate withCurrentSession = qElearningSession.closed.ne(true).and(qOpeningDate.loe(qSystemDate))
    			.and(qElearningSession.closingDate.isNull().or(qElearningSession.closingDate.isNotNull().and(qClosingDate.goe(qSystemDate))))
    			.and(qSubscriptionDate.loe(qSystemDate).and(qSubscriptionClose.isNull().or(qSubscriptionClose.goe(qSystemDate))));
    	builder.and(withCurrentSession).or(qElearningSession.isNull());
		query.where(builder);
		Long count = 0L;
		count = query.singleResult(qElearningSubscription.count().as("count"));
        return count;
    }

}
