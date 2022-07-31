package com.thalasoft.learnintouch.data.service.event.admin;

import com.thalasoft.learnintouch.data.service.event.DeleteEvent;

public class DeleteAdminEvent extends DeleteEvent {

    private final Long id;

    public DeleteAdminEvent(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

}
