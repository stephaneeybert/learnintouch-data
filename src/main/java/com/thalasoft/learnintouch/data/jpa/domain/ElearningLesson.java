package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_elearning_lesson")
public class ElearningLesson extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private String name;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String description;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String instructions;
    private String image;
    private String audio;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String introduction;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(nullable = false, length = 10)
    private LocalDateTime releaseDate;
    @Column(nullable = false)
    private boolean secured;
    @Column(nullable = false)
    private boolean publicAccess;
    @Column(nullable = false)
    private boolean garbage;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ElearningCategory elearningCategory;
    @ManyToOne
    @JoinColumn(name = "level_id")
    private ElearningLevel elearningLevel;
    @ManyToOne
    @JoinColumn(name = "lesson_model_id")
    private ElearningLessonModel elearningLessonModel;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private ElearningSubject elearningSubject;

    public ElearningLesson() {
    }

    public ElearningLevel getElearningLevel() {
        return this.elearningLevel;
    }

    public void setElearningLevel(ElearningLevel elearningLevel) {
        this.elearningLevel = elearningLevel;
    }

    public ElearningLessonModel getElearningLessonModel() {
        return this.elearningLessonModel;
    }

    public void setElearningLessonModel(ElearningLessonModel elearningLessonModel) {
        this.elearningLessonModel = elearningLessonModel;
    }

    public ElearningCategory getElearningCategory() {
		return elearningCategory;
	}

	public void setElearningCategory(ElearningCategory elearningCategory) {
		this.elearningCategory = elearningCategory;
	}

	public ElearningSubject getElearningSubject() {
        return this.elearningSubject;
    }

    public void setElearningSubject(ElearningSubject elearningSubject) {
        this.elearningSubject = elearningSubject;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructions() {
        return this.instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAudio() {
        return this.audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public boolean getSecured() {
        return this.secured;
    }

    public void setSecured(boolean secured) {
        this.secured = secured;
    }

    public boolean getPublicAccess() {
        return this.publicAccess;
    }

    public void setPublicAccess(boolean publicAccess) {
        this.publicAccess = publicAccess;
    }

    public LocalDateTime getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean getGarbage() {
        return this.garbage;
    }

    public void setGarbage(boolean garbage) {
        this.garbage = garbage;
    }

}
