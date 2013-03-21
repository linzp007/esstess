package com.ailk.tess.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * User: Administrator
 * Date: 13-2-15
 * Time: 下午2:26
 */
@javax.persistence.Table(name = "check_point", schema = "", catalog = "tess")
@Entity
public class CheckPointEntity {
    private int checkPointId;

    @javax.persistence.Column(name = "CHECK_POINT_ID", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getCheckPointId() {
        return checkPointId;
    }

    public void setCheckPointId(int checkPointId) {
        this.checkPointId = checkPointId;
    }

    private String checkPointName;

    @javax.persistence.Column(name = "CHECK_POINT_NAME", nullable = false, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getCheckPointName() {
        return checkPointName;
    }

    public void setCheckPointName(String checkPointName) {
        this.checkPointName = checkPointName;
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

    @javax.persistence.Column(name = "VERSION", nullable = false, insertable = true, updatable = true, length = 19, precision = 0)
    @Basic
    public Timestamp getVersion() {
        return version;
    }

    public void setVersion(Timestamp version) {
        this.version = version;
    }

    private String description;

    @javax.persistence.Column(name = "DESCRIPTION", nullable = true, insertable = true, updatable = true, length = 100, precision = 0)
    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CheckPointEntity that = (CheckPointEntity) o;

        if (checkPointId != that.checkPointId) return false;
        if (checkPointName != null ? !checkPointName.equals(that.checkPointName) : that.checkPointName != null)
            return false;
        if (createDt != null ? !createDt.equals(that.createDt) : that.createDt != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (manageCd != null ? !manageCd.equals(that.manageCd) : that.manageCd != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = checkPointId;
        result = 31 * result + (checkPointName != null ? checkPointName.hashCode() : 0);
        result = 31 * result + (manageCd != null ? manageCd.hashCode() : 0);
        result = 31 * result + (createDt != null ? createDt.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    private Collection<CaseTaskCheckPointEntity> caseTaskCheckPointsByCheckPointId;

    @OneToMany(mappedBy = "checkPointByCheckPointId")
    public Collection<CaseTaskCheckPointEntity> getCaseTaskCheckPointsByCheckPointId() {
        return caseTaskCheckPointsByCheckPointId;
    }

    public void setCaseTaskCheckPointsByCheckPointId(Collection<CaseTaskCheckPointEntity> caseTaskCheckPointsByCheckPointId) {
        this.caseTaskCheckPointsByCheckPointId = caseTaskCheckPointsByCheckPointId;
    }

    private CheckMethodEntity checkMethodByCheckMethodId;

    @ManyToOne
    @JoinColumn(name = "CHECK_METHOD_ID", referencedColumnName = "CHECK_METHOD_ID")
    public CheckMethodEntity getCheckMethodByCheckMethodId() {
        return checkMethodByCheckMethodId;
    }

    public void setCheckMethodByCheckMethodId(CheckMethodEntity checkMethodByCheckMethodId) {
        this.checkMethodByCheckMethodId = checkMethodByCheckMethodId;
    }
}
