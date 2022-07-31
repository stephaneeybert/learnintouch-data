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
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_elearning_exercise")
public class ElearningExercise extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private String name;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String description;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String instructions;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String introduction;
    @Column(nullable = false)
    private boolean hideIntroduction;
    private String image;
    private String audio;
    private int maxDuration;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(nullable = false, length = 10)
    private LocalDateTime releaseDate;
    @Column(name = "webpage_id")
    private String webpageId;
    @Column(nullable = false)
    private boolean secured;
    @Column(nullable = false)
    private boolean publicAccess;
    @Column(nullable = false)
    private boolean skipExerciseIntroduction;
    @Column(nullable = false)
    private boolean socialConnect;
    @Column(nullable = false)
    private boolean hideSolutions;
    @Column(nullable = false)
    private boolean hideProgressionBar;
    @Column(nullable = false)
    private boolean hidePageTabs;
    @Column(nullable = false)
    private boolean disableNextPageTabs;
    private int numberPageTabs;
    @Column(nullable = false)
    private boolean hideKeyboard;
    @Column(nullable = false)
    private boolean contactPage;
    @Column(nullable = false)
    private boolean locked;
    @Column(nullable = false)
    private boolean garbage;
    @ManyToOne
    @JoinColumn(name = "level_id")
    private ElearningLevel elearningLevel;
    @ManyToOne
    @JoinColumn(name = "scoring_id")
    private ElearningScoring elearningScoring;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private ElearningSubject elearningSubject;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ElearningCategory elearningCategory;

    public ElearningExercise() {
    }

    public ElearningLevel getElearningLevel() {
        return this.elearningLevel;
    }

    public void setElearningLevel(ElearningLevel elearningLevel) {
        this.elearningLevel = elearningLevel;
    }

    public ElearningScoring getElearningScoring() {
        return this.elearningScoring;
    }

    public void setElearningScoring(ElearningScoring elearningScoring) {
        this.elearningScoring = elearningScoring;
    }

    public ElearningSubject getElearningSubject() {
        return this.elearningSubject;
    }

    public void setElearningSubject(ElearningSubject elearningSubject) {
        this.elearningSubject = elearningSubject;
    }

    public ElearningCategory getElearningCategory() {
        return this.elearningCategory;
    }

    public void setElearningCategory(ElearningCategory elearningCategory) {
        this.elearningCategory = elearningCategory;
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

    public String getIntroduction() {
        return this.introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public boolean getHideIntroduction() {
        return this.hideIntroduction;
    }

    public void setHideIntroduction(boolean hideIntroduction) {
        this.hideIntroduction = hideIntroduction;
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

    public boolean getPublicAccess() {
        return this.publicAccess;
    }

    public void setPublicAccess(boolean publicAccess) {
        this.publicAccess = publicAccess;
    }

    public int getMaxDuration() {
        return this.maxDuration;
    }

    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
    }

    public LocalDateTime getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean getSecured() {
        return this.secured;
    }

    public void setSecured(boolean secured) {
        this.secured = secured;
    }

    public boolean getSkipExerciseIntroduction() {
        return this.skipExerciseIntroduction;
    }

    public void setSkipExerciseIntroduction(boolean skipExerciseIntroduction) {
        this.skipExerciseIntroduction = skipExerciseIntroduction;
    }

    public boolean getSocialConnect() {
        return this.socialConnect;
    }

    public void setSocialConnect(boolean socialConnect) {
        this.socialConnect = socialConnect;
    }

    public boolean getHideSolutions() {
        return this.hideSolutions;
    }

    public void setHideSolutions(boolean hideSolutions) {
        this.hideSolutions = hideSolutions;
    }

    public boolean getHideProgressionBar() {
        return this.hideProgressionBar;
    }

    public void setHideProgressionBar(boolean hideProgressionBar) {
        this.hideProgressionBar = hideProgressionBar;
    }

    public boolean getHidePageTabs() {
        return this.hidePageTabs;
    }

    public void setHidePageTabs(boolean hidePageTabs) {
        this.hidePageTabs = hidePageTabs;
    }

    public boolean getDisableNextPageTabs() {
        return this.disableNextPageTabs;
    }

    public void setDisableNextPageTabs(boolean disableNextPageTabs) {
        this.disableNextPageTabs = disableNextPageTabs;
    }

    public int getNumberPageTabs() {
        return this.numberPageTabs;
    }

    public void setNumberPageTabs(int numberPageTabs) {
        this.numberPageTabs = numberPageTabs;
    }

    public boolean getHideKeyboard() {
        return this.hideKeyboard;
    }

    public boolean isContactPage() {
        return contactPage;
    }

    public void setContactPage(boolean contactPage) {
        this.contactPage = contactPage;
    }

    public void setHideKeyboard(boolean hideKeyboard) {
        this.hideKeyboard = hideKeyboard;
    }

    public String getWebpageId() {
        return this.webpageId;
    }

    public void setWebpageId(String webpageId) {
        this.webpageId = webpageId;
    }

    public boolean getGarbage() {
        return this.garbage;
    }

    public void setGarbage(boolean garbage) {
        this.garbage = garbage;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

}
