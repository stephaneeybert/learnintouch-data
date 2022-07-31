package com.thalasoft.learnintouch.data.service.event.admin;

import com.thalasoft.learnintouch.data.service.event.CreateEvent;

public class CreateAdminEvent extends CreateEvent {

    private EventAdmin eventAdmin;

    public CreateAdminEvent(final EventAdmin eventAdmin) {
        this.eventAdmin = eventAdmin;
    }

    public EventAdmin getEventAdmin() {
        return this.eventAdmin;
    }

}