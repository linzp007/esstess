package com.ailk.tess.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * User: Administrator
 * Date: 13-2-15
 * Time: 下午2:26
 */
@javax.persistence.Table(name = "template_xml", schema = "", catalog = "tess")
@Entity
public class TemplateXmlEntity {
    private int templateId;

    @javax.persistence.Column(name = "TEMPLATE_ID", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    private String templateContent;

    @javax.persistence.Column(name = "TEMPLATE_CONTENT", nullable = false, insertable = true, updatable = true, length = 65535, precision = 0)
    @Basic
    public String getTemplateContent() {
        return templateContent;
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TemplateXmlEntity that = (TemplateXmlEntity) o;

        if (templateId != that.templateId) return false;
        if (templateContent != null ? !templateContent.equals(that.templateContent) : that.templateContent != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = templateId;
        result = 31 * result + (templateContent != null ? templateContent.hashCode() : 0);
        return result;
    }

    private CaseTemplateEntity caseTemplateByTemplateId;

    @OneToOne
    @javax.persistence.JoinColumn(name = "TEMPLATE_ID", referencedColumnName = "TEMPLATE_ID", nullable = false)
    public CaseTemplateEntity getCaseTemplateByTemplateId() {
        return caseTemplateByTemplateId;
    }

    public void setCaseTemplateByTemplateId(CaseTemplateEntity caseTemplateByTemplateId) {
        this.caseTemplateByTemplateId = caseTemplateByTemplateId;
    }
}
