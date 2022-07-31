package com.thalasoft.learnintouch.data.service.event.admin;

import com.thalasoft.learnintouch.data.service.event.RequestReadEvent;

public class GetOneAdminEvent extends RequestReadEvent {

    private final Long id;

    public GetOneAdminEvent(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

}
