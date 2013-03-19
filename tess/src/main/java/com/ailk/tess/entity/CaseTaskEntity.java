package com.ailk.tess.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * User: Administrator
 * Date: 13-2-15
 * Time: 下午2:26
 */
@javax.persistence.Table(name = "case_task", schema = "", catalog = "tess")
@Entity
public class CaseTaskEntity {
    private int caseTaskId;

    @javax.persistence.Column(name = "CASE_TASK_ID", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getCaseTaskId() {
        return caseTaskId;
    }

    public void setCaseTaskId(int caseTaskId) {
        this.caseTaskId = caseTaskId;
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

    private Timestamp createDt;

    @javax.persistence.Column(name = "CREATE_DT", nullable = false, insertable = true, updatable = true, length = 19, precision = 0)
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

        CaseTaskEntity that = (CaseTaskEntity) o;

        if (caseTaskId != that.caseTaskId) return false;
        if (createDt != null ? !createDt.equals(that.createDt) : that.createDt != null) return false;
        if (statusCd != null ? !statusCd.equals(that.statusCd) : that.statusCd != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = caseTaskId;
        result = 31 * result + (statusCd != null ? statusCd.hashCode() : 0);
        result = 31 * result + (createDt != null ? createDt.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }

    private CaseTemplateEntity caseTemplateByTemplateId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "TEMPLATE_ID", referencedColumnName = "TEMPLATE_ID", nullable = false)
    public CaseTemplateEntity getCaseTemplateByTemplateId() {
        return caseTemplateByTemplateId;
    }

    public void setCaseTemplateByTemplateId(CaseTemplateEntity caseTemplateByTemplateId) {
        this.caseTemplateByTemplateId = caseTemplateByTemplateId;
    }

    private TaskEntity taskByTaskId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "TASK_ID", referencedColumnName = "TASK_ID", nullable = false)
    public TaskEntity getTaskByTaskId() {
        return taskByTaskId;
    }

    public void setTaskByTaskId(TaskEntity taskByTaskId) {
        this.taskByTaskId = taskByTaskId;
    }

    private Collection<CaseTaskCheckPointEntity> caseTaskCheckPointsByCaseTaskId;

    @OneToMany(mappedBy = "caseTaskByCaseTaskId")
    public Collection<CaseTaskCheckPointEntity> getCaseTaskCheckPointsByCaseTaskId() {
        return caseTaskCheckPointsByCaseTaskId;
    }

    public void setCaseTaskCheckPointsByCaseTaskId(Collection<CaseTaskCheckPointEntity> caseTaskCheckPointsByCaseTaskId) {
        this.caseTaskCheckPointsByCaseTaskId = caseTaskCheckPointsByCaseTaskId;
    }

    private Collection<SessionCaseEntity> sessionCasesByCaseTaskId;

    @OneToMany(mappedBy = "caseTaskByCaseTaskId")
    public Collection<SessionCaseEntity> getSessionCasesByCaseTaskId() {
        return sessionCasesByCaseTaskId;
    }

    public void setSessionCasesByCaseTaskId(Collection<SessionCaseEntity> sessionCasesByCaseTaskId) {
        this.sessionCasesByCaseTaskId = sessionCasesByCaseTaskId;
    }
}
