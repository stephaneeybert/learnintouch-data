package com.thalasoft.learnintouch.data.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.thalasoft.learnintouch.data.jpa.domain.UserAccount;

public interface UserAccountRepositoryCustom {

    public Page<UserAccount> search(String searchTerm, Pageable page);

    public Page<UserAccount> searchMailSubscribers(String searchTerm, Pageable page);

    public Page<UserAccount> searchNotMailSubscribers(String searchTerm, Pageable page);

    public Page<UserAccount> searchSmsSubscribers(String searchTerm, Pageable page);

    public Page<UserAccount> searchNotSmsSubscribers(String searchTerm, Pageable page);

    public Long countNotValidPermanently();

    public Long countImported();

}
