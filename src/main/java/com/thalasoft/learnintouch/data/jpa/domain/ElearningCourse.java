package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_elearning_course")
public class ElearningCourse extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private String name;
    private String description;
    private String image;
    @Column(nullable = false)
    private boolean instantCorrection;
    @Column(nullable = false)
    private boolean instantCongratulation;
    @Column(nullable = false)
    private boolean instantSolution;
    @Column(nullable = false)
    private boolean importable;
    @Column(nullable = false)
    private boolean secured;
    private int freeSamples;
    @Column(nullable = false)
    private boolean autoSubscription;
    @Column(nullable = false)
    private boolean autoUnsubscription;
    @Column(nullable = false)
    private boolean interruptTimedOutExercise;
    @Column(nullable = false)
    private boolean resetExerciseAnswers;
    @Column(nullable = false)
    private boolean exerciseOnlyOnce;
    @Column(nullable = false)
    private boolean exerciseAnyOrder;
    @Column(nullable = false, length = 50)
    private String saveResultOption;
    @Column(nullable = false)
    private boolean shuffleQuestions;
    @Column(nullable = false)
    private boolean shuffleAnswers;
    @ManyToOne
    @JoinColumn(name = "matter_id", nullable = false)
    private ElearningMatter elearningMatter;
    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;

    public ElearningCourse() {
    }

    public ElearningMatter getElearningMatter() {
        return this.elearningMatter;
    }

    public void setElearningMatter(ElearningMatter elearningMatter) {
        this.elearningMatter = elearningMatter;
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

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isInstantCorrection() {
        return instantCorrection;
    }

    public void setInstantCorrection(boolean instantCorrection) {
        this.instantCorrection = instantCorrection;
    }

    public boolean isInstantCongratulation() {
        return instantCongratulation;
    }

    public void setInstantCongratulation(boolean instantCongratulation) {
        this.instantCongratulation = instantCongratulation;
    }

    public boolean isInstantSolution() {
        return instantSolution;
    }

    public void setInstantSolution(boolean instantSolution) {
        this.instantSolution = instantSolution;
    }

    public boolean getImportable() {
        return this.importable;
    }

    public void setImportable(boolean importable) {
        this.importable = importable;
    }

    public boolean getSecured() {
        return this.secured;
    }

    public void setSecured(boolean secured) {
        this.secured = secured;
    }

    public int getFreeSamples() {
        return freeSamples;
    }

    public void setFreeSamples(int freeSamples) {
        this.freeSamples = freeSamples;
    }

    public boolean isAutoSubscription() {
        return autoSubscription;
    }

    public void setAutoSubscription(boolean autoSubscription) {
        this.autoSubscription = autoSubscription;
    }

    public boolean isAutoUnsubscription() {
        return autoUnsubscription;
    }

    public void setAutoUnsubscription(boolean autoUnsubscription) {
        this.autoUnsubscription = autoUnsubscription;
    }

    public boolean getInterruptTimedOutExercise() {
        return this.interruptTimedOutExercise;
    }

    public void setInterruptTimedOutExercise(boolean interruptTimedOutExercise) {
        this.interruptTimedOutExercise = interruptTimedOutExercise;
    }

    public boolean getResetExerciseAnswers() {
        return this.resetExerciseAnswers;
    }

    public void setResetExerciseAnswers(boolean resetExerciseAnswers) {
        this.resetExerciseAnswers = resetExerciseAnswers;
    }

    public boolean getExerciseOnlyOnce() {
        return this.exerciseOnlyOnce;
    }

    public void setExerciseOnlyOnce(boolean exerciseOnlyOnce) {
        this.exerciseOnlyOnce = exerciseOnlyOnce;
    }

    public boolean isExerciseAnyOrder() {
        return exerciseAnyOrder;
    }

    public void setExerciseAnyOrder(boolean exerciseAnyOrder) {
        this.exerciseAnyOrder = exerciseAnyOrder;
    }

    public String getSaveResultOption() {
        return this.saveResultOption;
    }

    public void setSaveResultOption(String saveResultOption) {
        this.saveResultOption = saveResultOption;
    }

    public boolean getShuffleQuestions() {
        return this.shuffleQuestions;
    }

    public void setShuffleQuestions(boolean shuffleQuestions) {
        this.shuffleQuestions = shuffleQuestions;
    }

    public boolean getShuffleAnswers() {
        return this.shuffleAnswers;
    }

    public void setShuffleAnswers(boolean shuffleAnswers) {
        this.shuffleAnswers = shuffleAnswers;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

}
