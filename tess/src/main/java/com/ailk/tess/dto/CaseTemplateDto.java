package com.ailk.tess.dto;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * User: Administrator
 * Date: 13-2-19
 * Time: 下午11:45
 */
public class CaseTemplateDto {
    private int templateId;
    @Size(min=1, max=50, message="{templateName.size.message}")
    private String templateName;
    @Size(min=1, max=10, message="{manageCd.size.message}")
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
