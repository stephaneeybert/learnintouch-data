package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_template_property_set")
public class TemplatePropertySet extends AbstractEntity {

    public TemplatePropertySet() {
    }

}
