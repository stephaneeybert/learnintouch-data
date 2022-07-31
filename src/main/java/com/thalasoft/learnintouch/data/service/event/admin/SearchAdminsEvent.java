package com.thalasoft.learnintouch.data.service.event.admin;

import org.springframework.data.domain.Pageable;

import com.thalasoft.learnintouch.data.service.event.RequestReadEvent;

public class SearchAdminsEvent extends RequestReadEvent {
  
    private final String searchTerm;
    private Pageable pageRequest;
    
    public SearchAdminsEvent(final String searchTerm, final Pageable pageRequest) {
        this.searchTerm = searchTerm;
        this.pageRequest = pageRequest;
    }

    public String getSearchTerm() {
        return this.searchTerm;
    }

	public Pageable getPageRequest() {
		return pageRequest;
	}

}
