package com.thalasoft.learnintouch.data.service.event.admin;

import com.thalasoft.learnintouch.data.service.event.ReadEvent;

public class GotOneAdminEvent extends ReadEvent {

    private EventAdmin eventAdmin;

    public GotOneAdminEvent(EventAdmin eventAdmin) {
        this.eventAdmin = eventAdmin;
    }

    public EventAdmin getEventAdmin() {
        return this.eventAdmin;
    }

}
