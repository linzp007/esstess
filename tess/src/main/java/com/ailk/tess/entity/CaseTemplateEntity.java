package com.ailk.tess.entity;

import com.ailk.tess.util.TessConst;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * User: Administrator
 * Date: 13-2-15
 * Time: 下午2:26
 */
@javax.persistence.Table(name = "case_template", schema = "", catalog = "tess")
@Entity
public class CaseTemplateEntity {
    private int templateId;

    @javax.persistence.Column(name = "TEMPLATE_ID", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    private String templateName;

    @javax.persistence.Column(name = "TEMPLATE_NAME", nullable = false, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    private String manageCd;

    @javax.persistence.Column(name = "MANAGE_CD", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public String getManageCd() {
        return manageCd;
    }

    public void setManageCd(String manageCd) {
        this.manageCd = manageCd;
    }

    private String statusCd;

    @javax.persistence.Column(name = "STATUS_CD", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public void setStatusCd(TessConst.CaseTemplateStatus statusCd) {
        this.statusCd = statusCd.toString();
    }

    private Timestamp createDt;

    @javax.persistence.Column(name = "CREATE_DT", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    @Basic
    public Timestamp getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Timestamp createDt) {
        this.createDt = createDt;
    }

    private Timestamp version;

    @javax.persistence.Column(name = "VERSION", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    @Basic
    public Timestamp getVersion() {
        return version;
    }

    public void setVersion(Timestamp version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CaseTemplateEntity that = (CaseTemplateEntity) o;

        if (templateId != that.templateId) return false;
        if (createDt != null ? !createDt.equals(that.createDt) : that.createDt != null) return false;
        if (manageCd != null ? !manageCd.equals(that.manageCd) : that.manageCd != null) return false;
        if (statusCd != null ? !statusCd.equals(that.statusCd) : that.statusCd != null) return false;
        if (templateName != null ? !templateName.equals(that.templateName) : that.templateName != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = templateId;
        result = 31 * result + (templateName != null ? templateName.hashCode() : 0);
        result = 31 * result + (manageCd != null ? manageCd.hashCode() : 0);
        result = 31 * result + (statusCd != null ? statusCd.hashCode() : 0);
        result = 31 * result + (createDt != null ? createDt.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }

    private Collection<CaseTaskEntity> caseTasksByTemplateId;

    @OneToMany(mappedBy = "caseTemplateByTemplateId")
    public Collection<CaseTaskEntity> getCaseTasksByTemplateId() {
        return caseTasksByTemplateId;
    }

    public void setCaseTasksByTemplateId(Collection<CaseTaskEntity> caseTasksByTemplateId) {
        this.caseTasksByTemplateId = caseTasksByTemplateId;
    }

    private TemplateXmlEntity templateXmlByTemplateId;

    @OneToOne(mappedBy = "caseTemplateByTemplateId")
    public TemplateXmlEntity getTemplateXmlByTemplateId() {
        return templateXmlByTemplateId;
    }

    public void setTemplateXmlByTemplateId(TemplateXmlEntity templateXmlByTemplateId) {
        this.templateXmlByTemplateId = templateXmlByTemplateId;
    }
}
