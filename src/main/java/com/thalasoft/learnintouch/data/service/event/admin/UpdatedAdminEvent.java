package com.thalasoft.learnintouch.data.service.event.admin;

import com.thalasoft.learnintouch.data.service.event.UpdatedEvent;

public class UpdatedAdminEvent extends UpdatedEvent {

    private Long id;
    private EventAdmin eventAdmin;

    public UpdatedAdminEvent(final Long id, final EventAdmin eventAdmin) {
        this.id = id;
        this.eventAdmin = eventAdmin;
    }

    public long getId() {
        return this.id;
    }

    public EventAdmin getEventAdmin() {
        return this.eventAdmin;
    }

}
