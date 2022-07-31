package com.thalasoft.learnintouch.data.jpa.repository;

import com.thalasoft.learnintouch.data.jpa.domain.NewsHeading;
import com.thalasoft.learnintouch.data.jpa.domain.NewsPaper;
import com.thalasoft.learnintouch.data.jpa.domain.NewsStory;

public interface NewsStoryRepositoryCustom {

    public NewsStory findByNextListOrder(NewsPaper newsPaper, NewsHeading newsHeading, int listOrder);

    public NewsStory findByPreviousListOrder(NewsPaper newsPaper, NewsHeading newsHeading, int listOrder);

}
