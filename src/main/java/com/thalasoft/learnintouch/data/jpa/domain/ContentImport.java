package com.thalasoft.learnintouch.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_generator", sequenceName = "sq_id_content_import")
public class ContentImport extends AbstractEntity {

    @Column(nullable = false)
    private String domainName;
    @Column(nullable = false)
    private boolean isImporting;
    @Column(nullable = false)
    private boolean isExporting;
    @Column(length = 10)
    private String permissionKey;
    @Column(length = 10)
    private String permissionStatus;

    public ContentImport() {
    }

    public String getDomainName() {
        return this.domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public boolean getIsImporting() {
        return this.isImporting;
    }

    public void setIsImporting(boolean isImporting) {
        this.isImporting = isImporting;
    }

    public boolean getIsExporting() {
        return this.isExporting;
    }

    public void setIsExporting(boolean isExporting) {
        this.isExporting = isExporting;
    }

    public String getPermissionKey() {
        return this.permissionKey;
    }

    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }

    public String getPermissionStatus() {
        return this.permissionStatus;
    }

    public void setPermissionStatus(String permissionStatus) {
        this.permissionStatus = permissionStatus;
    }

}
