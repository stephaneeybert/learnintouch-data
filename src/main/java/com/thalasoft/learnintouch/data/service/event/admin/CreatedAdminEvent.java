package com.thalasoft.learnintouch.data.service.event.admin;

import com.thalasoft.learnintouch.data.service.event.CreatedEvent;

public class CreatedAdminEvent extends CreatedEvent {

    private final Long adminId;
    private final EventAdmin eventAdmin;

    public CreatedAdminEvent(final Long adminId, final EventAdmin eventAdmin) {
        this.adminId = adminId;
        this.eventAdmin = eventAdmin;
    }

    public EventAdmin getEventAdmin() {
        return this.eventAdmin;
    }

    public Long getAdminId() {
        return this.adminId;
    }

}