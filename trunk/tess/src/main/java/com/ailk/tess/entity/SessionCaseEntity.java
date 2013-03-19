package com.ailk.tess.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

/**
 * User: Administrator
 * Date: 13-2-15
 * Time: 下午2:26
 */
@javax.persistence.Table(name = "session_case", schema = "", catalog = "tess")
@Entity
public class SessionCaseEntity {
    private int sessionCaseId;

    @javax.persistence.Column(name = "SESSION_CASE_ID", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getSessionCaseId() {
        return sessionCaseId;
    }

    public void setSessionCaseId(int sessionCaseId) {
        this.sessionCaseId = sessionCaseId;
    }

    private String transactionId;

    @javax.persistence.Column(name = "TRANSACTION_ID", nullable = false, insertable = true, updatable = true, length = 45, precision = 0)
    @Basic
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
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

    private Timestamp startDt;

    @javax.persistence.Column(name = "START_DT", nullable = false, insertable = true, updatable = true, length = 19, precision = 0)
    @Basic
    public Timestamp getStartDt() {
        return startDt;
    }

    public void setStartDt(Timestamp startDt) {
        this.startDt = startDt;
    }

    private Timestamp endDt;

    @javax.persistence.Column(name = "END_DT", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    @Basic
    public Timestamp getEndDt() {
        return endDt;
    }

    public void setEndDt(Timestamp endDt) {
        this.endDt = endDt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessionCaseEntity that = (SessionCaseEntity) o;

        if (sessionCaseId != that.sessionCaseId) return false;
        if (endDt != null ? !endDt.equals(that.endDt) : that.endDt != null) return false;
        if (startDt != null ? !startDt.equals(that.startDt) : that.startDt != null) return false;
        if (statusCd != null ? !statusCd.equals(that.statusCd) : that.statusCd != null) return false;
        if (transactionId != null ? !transactionId.equals(that.transactionId) : that.transactionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sessionCaseId;
        result = 31 * result + (transactionId != null ? transactionId.hashCode() : 0);
        result = 31 * result + (statusCd != null ? statusCd.hashCode() : 0);
        result = 31 * result + (startDt != null ? startDt.hashCode() : 0);
        result = 31 * result + (endDt != null ? endDt.hashCode() : 0);
        return result;
    }

    private TessSessionEntity tessSessionByTessSessionId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "TESS_SESSION_ID", referencedColumnName = "TESS_SESSION_ID", nullable = false)
    public TessSessionEntity getTessSessionByTessSessionId() {
        return tessSessionByTessSessionId;
    }

    public void setTessSessionByTessSessionId(TessSessionEntity tessSessionByTessSessionId) {
        this.tessSessionByTessSessionId = tessSessionByTessSessionId;
    }

    private CaseTaskEntity caseTaskByCaseTaskId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "CASE_TASK_ID", referencedColumnName = "CASE_TASK_ID", nullable = false)
    public CaseTaskEntity getCaseTaskByCaseTaskId() {
        return caseTaskByCaseTaskId;
    }

    public void setCaseTaskByCaseTaskId(CaseTaskEntity caseTaskByCaseTaskId) {
        this.caseTaskByCaseTaskId = caseTaskByCaseTaskId;
    }
}
