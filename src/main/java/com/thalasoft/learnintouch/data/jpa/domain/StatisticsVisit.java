package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_statistics_visit")
public class StatisticsVisit extends AbstractEntity {

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    @Column(nullable = false)
    private LocalDateTime visitDatetime;
    @Column(nullable = false)
    private String visitorHostAddress;
    @Column(nullable = false)
    private String visitorBrowser;
    @Column(nullable = false)
    private String visitorReferer;

    public StatisticsVisit() {
    }

    public LocalDateTime getVisitDatetime() {
        return this.visitDatetime;
    }

    public void setVisitDatetime(LocalDateTime visitDatetime) {
        this.visitDatetime = visitDatetime;
    }

    public String getVisitorHostAddress() {
        return this.visitorHostAddress;
    }

    public void setVisitorHostAddress(String visitorHostAddress) {
        this.visitorHostAddress = visitorHostAddress;
    }

    public String getVisitorBrowser() {
        return this.visitorBrowser;
    }

    public void setVisitorBrowser(String visitorBrowser) {
        this.visitorBrowser = visitorBrowser;
    }

    public String getVisitorReferer() {
        return this.visitorReferer;
    }

    public void setVisitorReferer(String visitorReferer) {
        this.visitorReferer = visitorReferer;
    }

}
