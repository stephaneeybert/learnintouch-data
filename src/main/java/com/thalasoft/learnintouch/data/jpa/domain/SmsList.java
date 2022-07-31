package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_sms_list")
public class SmsList extends AbstractEntity {

    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    private boolean autoSubscribe;

    public SmsList() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAutoSubscribe() {
		return autoSubscribe;
	}

	public void setAutoSubscribe(boolean autoSubscribe) {
		this.autoSubscribe = autoSubscribe;
	}

}
