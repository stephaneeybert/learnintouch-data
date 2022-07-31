package com.thalasoft.learnintouch.data.service.event.admin;

import com.thalasoft.learnintouch.data.service.event.DeletedEvent;

public class DeletedAdminEvent extends DeletedEvent {

    private Long id;
    private EventAdmin eventAdmin;
    private boolean deletionCompleted;

    public DeletedAdminEvent(Long id, EventAdmin eventAdmin) {
        this.id = id;
        this.eventAdmin = eventAdmin;
        this.deletionCompleted = true;
    }

    public Long getId() {
        return this.id;
    }

    public EventAdmin getEventAdmin() {
        return this.eventAdmin;
    }

    public boolean isDeletionCompleted() {
        return this.deletionCompleted;
    }

    public static DeletedAdminEvent deletionForbidden(Long id, EventAdmin eventAdmin) {
        DeletedAdminEvent adminDeletedEvent = new DeletedAdminEvent(id, eventAdmin);
        adminDeletedEvent.deletionCompleted = false;
        return adminDeletedEvent;
    }

}
