package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_elearning_scoring_range")
public class ElearningScoringRange extends AbstractEntity {

    @Column(nullable = false)
    private int upperRange;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String score;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String advice;
    @Lob
    @Column(columnDefinition = "TEXT", length = 65535)
    private String proposal;
    private String linkText;
    private String linkUrl;
    @ManyToOne
    @JoinColumn(name = "elearning_scoring_id", nullable = false)
    private ElearningScoring elearningScoring;

    public ElearningScoringRange() {
    }

    public ElearningScoring getElearningScoring() {
        return this.elearningScoring;
    }

    public void setElearningScoring(ElearningScoring elearningScoring) {
        this.elearningScoring = elearningScoring;
    }

    public int getUpperRange() {
        return this.upperRange;
    }

    public void setUpperRange(int upperRange) {
        this.upperRange = upperRange;
    }

    public String getScore() {
        return this.score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getAdvice() {
        return this.advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getProposal() {
        return this.proposal;
    }

    public void setProposal(String proposal) {
        this.proposal = proposal;
    }

    public String getLinkText() {
        return this.linkText;
    }

    public void setLinkText(String linkText) {
        this.linkText = linkText;
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

}
