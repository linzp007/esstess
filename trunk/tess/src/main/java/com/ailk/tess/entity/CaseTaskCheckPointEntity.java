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
@javax.persistence.Table(name = "case_task_check_point", schema = "", catalog = "tess")
@Entity
public class CaseTaskCheckPointEntity {
    private int caseTaskCheckPointId;

    @javax.persistence.Column(name = "CASE_TASK_CHECK_POINT_ID", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getCaseTaskCheckPointId() {
        return caseTaskCheckPointId;
    }

    public void setCaseTaskCheckPointId(int caseTaskCheckPointId) {
        this.caseTaskCheckPointId = caseTaskCheckPointId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CaseTaskCheckPointEntity that = (CaseTaskCheckPointEntity) o;

        if (caseTaskCheckPointId != that.caseTaskCheckPointId) return false;
        if (createDt != null ? !createDt.equals(that.createDt) : that.createDt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = caseTaskCheckPointId;
        result = 31 * result + (createDt != null ? createDt.hashCode() : 0);
        return result;
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

    private CheckPointEntity checkPointByCheckPointId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "CHECK_POINT_ID", referencedColumnName = "CHECK_POINT_ID", nullable = false)
    public CheckPointEntity getCheckPointByCheckPointId() {
        return checkPointByCheckPointId;
    }

    public void setCheckPointByCheckPointId(CheckPointEntity checkPointByCheckPointId) {
        this.checkPointByCheckPointId = checkPointByCheckPointId;
    }
}
