package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_lexicon_entry")
public class LexiconEntry extends AbstractEntity {

    @Column(nullable = false, length = 50)
    private String name;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String explanation;
    @Column(length = 255)
    private String image;

    public LexiconEntry() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
