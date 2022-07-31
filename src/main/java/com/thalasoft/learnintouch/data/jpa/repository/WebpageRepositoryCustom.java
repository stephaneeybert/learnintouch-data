package com.thalasoft.learnintouch.data.jpa.repository;

import com.thalasoft.learnintouch.data.jpa.domain.Webpage;


public interface WebpageRepositoryCustom {

    public Webpage findByNextListOrder(Webpage parent, int listOrder);

    public Webpage findByPreviousListOrder(Webpage parent, int listOrder);

}
