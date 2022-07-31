package com.thalasoft.learnintouch.data.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.thalasoft.learnintouch.data.jpa.domain.ElearningClass;
import com.thalasoft.learnintouch.data.jpa.domain.ElearningCourse;
import com.thalasoft.learnintouch.data.jpa.domain.ElearningSession;
import com.thalasoft.learnintouch.data.jpa.domain.ElearningSubscription;
import com.thalasoft.learnintouch.data.jpa.domain.ElearningTeacher;
import com.thalasoft.learnintouch.data.jpa.domain.UserAccount;

public interface ElearningSubscriptionRepository extends GenericRepository<ElearningSubscription, Long>, ElearningSubscriptionRepositoryCustom {

    @Query("SELECT es FROM ElearningSubscription es, UserAccount ua WHERE es.userAccount.id = ua.id ORDER BY ua.lastname, ua.firstname, es.subscriptionDate DESC")
    public Page<ElearningSubscription> findAllPlease(Pageable page);

    @Query("SELECT es FROM ElearningSubscription es, UserAccount ua WHERE es.userAccount.id = ua.id AND (es.elearningTeacher = :elearningTeacher OR (es.elearningTeacher IS NULL AND :elearningTeacher < '1')) ORDER BY ua.lastname, ua.firstname, es.subscriptionDate DESC")
    public Page<ElearningSubscription> findByTeacher(@Param("elearningTeacher") ElearningTeacher elearningTeacher, Pageable page);

    @Query("SELECT es FROM ElearningSubscription es, UserAccount ua WHERE es.userAccount.id = ua.id AND (es.elearningSession = :elearningSession OR (es.elearningSession IS NULL AND :elearningSession < '1')) ORDER BY ua.lastname, ua.firstname, es.subscriptionDate DESC")
    public Page<ElearningSubscription> findBySession(@Param("elearningSession") ElearningSession elearningSession, Pageable page);

    @Query("SELECT es FROM ElearningSubscription es, UserAccount ua WHERE es.userAccount.id = ua.id AND es.elearningSession IS NULL ORDER BY ua.lastname, ua.firstname, es.subscriptionDate DESC")
    public Page<ElearningSubscription> findByNoSession(Pageable page);

    @Query("SELECT es FROM ElearningSubscription es WHERE es.userAccount.id = :userAccount AND es.elearningCourse = :elearningCourse ORDER BY es.subscriptionDate DESC")
    public Page<ElearningSubscription> findByUserAcountAndCourse(@Param("userAccount") UserAccount userAccount, @Param("elearningCourse") ElearningCourse elearningCourse, Pageable page);

    @Query("SELECT es FROM ElearningSubscription es WHERE es.userAccount.id = :userAccount AND es.elearningCourse = :elearningCourse AND es.elearningSession = :elearningSession ORDER BY es.subscriptionDate DESC")
    public Page<ElearningSubscription> findByUserAcountAndCourseAndSession(@Param("userAccount") UserAccount userAccount, @Param("elearningCourse") ElearningCourse elearningCourse, @Param("elearningSession") ElearningSession elearningSession, Pageable page);

    @Query("SELECT es FROM ElearningSubscription es, UserAccount ua WHERE es.userAccount.id = ua.id AND es.elearningCourse = :elearningCourse ORDER BY ua.lastname, ua.firstname, es.subscriptionDate DESC")
    public Page<ElearningSubscription> findByCourse(@Param("elearningCourse") ElearningCourse elearningCourse, Pageable page);

    @Query("SELECT es FROM ElearningSubscription es, UserAccount ua WHERE es.userAccount.id = ua.id AND (es.elearningClass = :elearningClass OR (es.elearningClass IS NULL AND :elearningClass < '1')) ORDER BY ua.lastname, ua.firstname, es.subscriptionDate DESC")
    public Page<ElearningSubscription> findByClass(@Param("elearningClass") ElearningClass elearningClass, Pageable page);

    @Query("SELECT es FROM ElearningSubscription es, UserAccount ua WHERE es.userAccount.id = ua.id AND es.elearningCourse = :elearningCourse AND es.elearningSession = :elearningSession ORDER BY ua.lastname, ua.firstname, es.subscriptionDate DESC")
    public Page<ElearningSubscription> findByCourseAndSession(@Param("elearningCourse") ElearningCourse elearningCourse, @Param("elearningSession") ElearningSession elearningSession, Pageable page);

    @Query("SELECT es FROM ElearningSubscription es, UserAccount ua WHERE es.userAccount.id = ua.id AND es.elearningCourse = :elearningCourse AND es.elearningSession = :elearningSession AND (es.elearningClass = :elearningClass OR (es.elearningClass IS NULL AND :elearningClass < '1')) ORDER BY ua.lastname, ua.firstname, es.subscriptionDate DESC")
    public Page<ElearningSubscription> findByCourseAndSessionAndClass(@Param("elearningCourse") ElearningCourse elearningCourse, @Param("elearningSession") ElearningSession elearningSession, @Param("elearningClass") ElearningClass elearningClass, Pageable page);

    @Query("SELECT es FROM ElearningSubscription es WHERE es.userAccount.id = :userAccount ORDER BY es.subscriptionDate DESC")
    public Page<ElearningSubscription> findByUserAcount(@Param("userAccount") UserAccount userAccount, Pageable page);

    @Query("SELECT es FROM ElearningSubscription es WHERE es.userAccount.id = :userAccount AND es.elearningTeacher = :elearningTeacher ORDER BY es.subscriptionDate DESC")
    public Page<ElearningSubscription> findByUserAcountAndTeacher(@Param("userAccount") UserAccount userAccount, @Param("elearningTeacher") ElearningTeacher elearningTeacher, Pageable page);

    @Query("SELECT es FROM ElearningSubscription es WHERE es.userAccount.id = :userAccount AND es = :elearningSubscription")
    public ElearningSubscription findByUserAcountAndSubscription(@Param("userAccount") UserAccount userAccount, @Param("elearningSubscription") ElearningSubscription elearningSubscription);

    @Query("SELECT es FROM ElearningSubscription es, UserAccount ua WHERE es.userAccount.id = ua.id AND es.elearningCourse = :elearningCourse AND es.elearningSession = :elearningSession AND (es.elearningTeacher = :elearningTeacher OR (es.elearningTeacher IS NULL AND :elearningTeacher <'1')) ORDER BY ua.lastname, ua.firstname, es.subscriptionDate DESC")
    public Page<ElearningSubscription> findByCourseAndSessionAndTeacher(@Param("elearningCourse") ElearningCourse elearningCourse, @Param("elearningSession") ElearningSession elearningSession, @Param("elearningTeacher") ElearningTeacher elearningTeacher, Pageable page);

    @Query("SELECT es FROM ElearningSubscription es, UserAccount ua WHERE es.userAccount.id = ua.id AND es.elearningCourse = :elearningCourse AND (es.elearningTeacher = :elearningTeacher OR (es.elearningTeacher IS NULL AND :elearningTeacher <'1')) ORDER BY ua.lastname, ua.firstname, es.subscriptionDate DESC")
    public Page<ElearningSubscription> findByCourseAndTeacher(@Param("elearningCourse") ElearningCourse elearningCourse, @Param("elearningTeacher") ElearningTeacher elearningTeacher, Pageable page);

    @Query("SELECT es FROM ElearningSubscription es, UserAccount ua WHERE es.userAccount.id = ua.id AND es.elearningCourse = :elearningCourse AND es.elearningSession = :elearningSession AND (es.elearningClass = :elearningClass OR (es.elearningClass IS NULL AND :elearningClass < '1')) AND (es.elearningTeacher = :elearningTeacher OR (es.elearningTeacher IS NULL AND :elearningTeacher <'1')) ORDER BY ua.lastname, ua.firstname, es.subscriptionDate DESC")
    public Page<ElearningSubscription> findByCourseAndSessionAndClassAndTeacher(@Param("elearningCourse") ElearningCourse elearningCourse, @Param("elearningSession") ElearningSession elearningSession, @Param("elearningClass") ElearningClass elearningClass, @Param("elearningTeacher") ElearningTeacher elearningTeacher, Pageable page);

    @Query("SELECT es FROM ElearningSubscription es, UserAccount ua WHERE es.userAccount.id = ua.id AND es.elearningCourse = :elearningCourse AND (es.elearningClass = :elearningClass OR (es.elearningClass IS NULL AND :elearningClass < '1')) AND (es.elearningTeacher = :elearningTeacher OR (es.elearningTeacher IS NULL AND :elearningTeacher <'1')) ORDER BY ua.lastname, ua.firstname, es.subscriptionDate DESC")
    public Page<ElearningSubscription> findByCourseAndClassAndTeacher(@Param("elearningCourse") ElearningCourse elearningCourse, @Param("elearningClass") ElearningClass elearningClass, @Param("elearningTeacher") ElearningTeacher elearningTeacher, Pageable page);

    @Query("SELECT es FROM ElearningSubscription es, UserAccount ua WHERE es.userAccount.id = ua.id AND es.elearningSession = :elearningSession AND (es.elearningTeacher = :elearningTeacher OR (es.elearningTeacher IS NULL AND :elearningTeacher <'1')) ORDER BY ua.lastname, ua.firstname, es.subscriptionDate DESC")
    public Page<ElearningSubscription> findBySessionAndTeacher(@Param("elearningSession") ElearningSession elearningSession, @Param("elearningTeacher") ElearningTeacher elearningTeacher, Pageable page);

    @Query("SELECT es FROM ElearningSubscription es, UserAccount ua WHERE es.userAccount.id = ua.id AND es.elearningSession = :elearningSession AND (es.elearningClass = :elearningClass OR (es.elearningClass IS NULL AND :elearningClass < '1')) AND (es.elearningTeacher = :elearningTeacher OR (es.elearningTeacher IS NULL AND :elearningTeacher <'1')) ORDER BY ua.lastname, ua.firstname, es.subscriptionDate DESC")
    public Page<ElearningSubscription> findBySessionAndClassAndTeacher(@Param("elearningSession") ElearningSession elearningSession, @Param("elearningClass") ElearningClass elearningClass, @Param("elearningTeacher") ElearningTeacher elearningTeacher, Pageable page);

    @Query("SELECT es FROM ElearningSubscription es, UserAccount ua WHERE es.userAccount.id = ua.id AND (es.elearningClass = :elearningClass OR (es.elearningClass IS NULL AND :elearningClass < '1')) AND (es.elearningTeacher = :elearningTeacher OR (es.elearningTeacher IS NULL AND :elearningTeacher <'1')) ORDER BY ua.lastname, ua.firstname, es.subscriptionDate DESC")
    public Page<ElearningSubscription> findByClassAndTeacher(@Param("elearningClass") ElearningClass elearningClass, @Param("elearningTeacher") ElearningTeacher elearningTeacher, Pageable page);

    @Query("SELECT es FROM ElearningSubscription es, UserAccount ua WHERE es.userAccount.id = ua.id AND es.elearningSession = :elearningSession AND (es.elearningClass = :elearningClass OR (es.elearningClass IS NULL AND :elearningClass < '1')) ORDER BY ua.lastname, ua.firstname, es.subscriptionDate DESC")
    public Page<ElearningSubscription> findBySessionAndClass(@Param("elearningSession") ElearningSession elearningSession, @Param("elearningClass") ElearningClass elearningClass, Pageable page);

    @Query("SELECT esu FROM ElearningSubscription esu LEFT JOIN esu.elearningSession es WHERE esu.userAccount.id = :userAccount ORDER BY es.openingDate DESC, esu.subscriptionDate DESC")
    public Page<ElearningSubscription> findUserAccountSubscription(@Param("userAccount") UserAccount userAccount, Pageable page);

    @Query("SELECT esu FROM ElearningSubscription esu LEFT JOIN esu.elearningSession es WHERE esu.elearningCourse IS NOT NULL AND esu.userAccount.id = :userAccount AND ((es.closed != '1' AND DATE(es.openingDate) <= :systemDate AND (es.closingDate IS NULL OR (es.closingDate IS NOT NULL AND DATE(es.closingDate) >= :systemDate)) AND DATE(esu.subscriptionDate) <= :systemdate AND (esu.subscriptionClose IS NULL OR DATE(esu.subscriptionClose) >= :systemDate)) OR esu.elearningSession IS NULL) ORDER BY es.openingDate DESC, esu.subscriptionDate DESC")
    public Page<ElearningSubscription> findUserAccountOpenedSubscriptionWithCourse(@Param("userAccount") UserAccount userAccount, @Param("systemDate") String systemDate, Pageable page);

    @Query("SELECT esu FROM ElearningSubscription esu LEFT JOIN esu.elearningSession es WHERE esu.userAccount.id = :userAccount AND ((es.closed != '1' AND DATE(es.openingDate) <= :systemDate AND (es.closingDate IS NULL OR (es.closingDate IS NOT NULL AND DATE(es.closingDate) >= :systemDate)) AND DATE(esu.subscriptionDate) <= :systemdate AND (esu.subscriptionClose IS NULL OR DATE(esu.subscriptionClose) >= :systemDate)) OR esu.elearningSession IS NULL) ORDER BY es.openingDate DESC, esu.subscriptionDate DESC")
    public Page<ElearningSubscription> findUserAccountOpenedSubscription(@Param("userAccount") UserAccount userAccount, @Param("systemDate") String systemDate, Pageable page);

}
