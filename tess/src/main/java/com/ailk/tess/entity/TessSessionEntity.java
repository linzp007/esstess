package com.ailk.tess.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * User: Administrator
 * Date: 13-2-15
 * Time: 下午2:26
 */
@javax.persistence.Table(name = "tess_session", schema = "", catalog = "tess")
@Entity
public class TessSessionEntity {
    private int tessSessionId;

    @javax.persistence.Column(name = "TESS_SESSION_ID", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getTessSessionId() {
        return tessSessionId;
    }

    public void setTessSessionId(int tessSessionId) {
        this.tessSessionId = tessSessionId;
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

    private String statusCd;

    @javax.persistence.Column(name = "STATUS_CD", nullable = false, insertable = true, updatable = true, length = 3, precision = 0)
    @Basic
    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
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

        TessSessionEntity that = (TessSessionEntity) o;

        if (tessSessionId != that.tessSessionId) return false;
        if (endDt != null ? !endDt.equals(that.endDt) : that.endDt != null) return false;
        if (startDt != null ? !startDt.equals(that.startDt) : that.startDt != null) return false;
        if (statusCd != null ? !statusCd.equals(that.statusCd) : that.statusCd != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tessSessionId;
        result = 31 * result + (startDt != null ? startDt.hashCode() : 0);
        result = 31 * result + (endDt != null ? endDt.hashCode() : 0);
        result = 31 * result + (statusCd != null ? statusCd.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }

    private Collection<SessionCaseEntity> sessionCasesByTessSessionId;

    @OneToMany(mappedBy = "tessSessionByTessSessionId")
    public Collection<SessionCaseEntity> getSessionCasesByTessSessionId() {
        return sessionCasesByTessSessionId;
    }

    public void setSessionCasesByTessSessionId(Collection<SessionCaseEntity> sessionCasesByTessSessionId) {
        this.sessionCasesByTessSessionId = sessionCasesByTessSessionId;
    }

    private UserEntity userByLoginUser;

    @ManyToOne
    @JoinColumn(name = "LOGIN_USER", referencedColumnName = "USER_ID", nullable = false)
    public UserEntity getUserByLoginUser() {
        return userByLoginUser;
    }

    public void setUserByLoginUser(UserEntity userByLoginUser) {
        this.userByLoginUser = userByLoginUser;
    }
}
