package com.thalasoft.learnintouch.data.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.thalasoft.learnintouch.data.jpa.domain.ElearningSubscription;
import com.thalasoft.learnintouch.data.jpa.domain.UserAccount;

public interface ElearningSubscriptionRepositoryCustom {

    public Page<ElearningSubscription> search(String searchTerm, Pageable page);

    public Page<ElearningSubscription> searchWithDistinctUserAccounts(String searchTerm, Pageable page);

    public Long countUserAccountOpenedSubscription(UserAccount userAccount, String systemDate);

}
