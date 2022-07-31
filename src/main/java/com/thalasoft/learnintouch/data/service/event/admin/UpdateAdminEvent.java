package com.thalasoft.learnintouch.data.service.event.admin;

import com.thalasoft.learnintouch.data.service.event.UpdateEvent;

public class UpdateAdminEvent extends UpdateEvent {

    private EventAdmin eventAdmin;

    public UpdateAdminEvent(EventAdmin eventAdmin) {
        this.eventAdmin = eventAdmin;
    }

    public EventAdmin getEventAdmin() {
        return this.eventAdmin;
    }
    
}
