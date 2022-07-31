package com.thalasoft.learnintouch.data.service.event.admin;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.thalasoft.learnintouch.data.service.event.RequestReadEvent;

public class SearchedAdminsEvent extends RequestReadEvent {
  
    private final String searchTerm;
    private Pageable pageRequest;
    private List<EventAdmin> eventAdmins;
    private long totalPages;
    private long totalElements;
    
    public SearchedAdminsEvent(final String searchTerm, final Pageable pageRequest, List<EventAdmin> eventAdmins, long totalPages, long totalElements) {
        this.searchTerm = searchTerm;
        this.pageRequest = pageRequest;
        this.eventAdmins = eventAdmins;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    public String getSearchTerm() {
        return this.searchTerm;
    }

	public Pageable getPageRequest() {
		return pageRequest;
	}

	public List<EventAdmin> getEventAdmins() {
		return eventAdmins;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public long getTotalElements() {
		return totalElements;
	}

}
