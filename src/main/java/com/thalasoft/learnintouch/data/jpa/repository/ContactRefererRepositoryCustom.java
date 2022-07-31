package com.thalasoft.learnintouch.data.jpa.repository;

import com.thalasoft.learnintouch.data.jpa.domain.ContactReferer;

public interface ContactRefererRepositoryCustom {

    public ContactReferer findFirst();
    
    public ContactReferer findByNextListOrder(int listOrder);

    public ContactReferer findByPreviousListOrder(int listOrder);
    
}
