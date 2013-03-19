package com.ailk.tess.dto;

import java.sql.Timestamp;

/**
 * User: Administrator
 * Date: 13-2-19
 * Time: 下午11:45
 */
public class CaseTemplateDto {
    private int templateId;
    private String templateName;
    private String manageCd;
    private String statusCd;
    private Timestamp createDt;
    private Timestamp version;

    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getManageCd() {
        return manageCd;
    }

    public void setManageCd(String manageCd) {
        this.manageCd = manageCd;
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public Timestamp getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Timestamp createDt) {
        this.createDt = createDt;
    }

    public Timestamp getVersion() {
        return version;
    }

    public void setVersion(Timestamp version) {
        this.version = version;
    }
}
