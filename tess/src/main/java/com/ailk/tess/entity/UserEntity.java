package com.ailk.tess.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * User: Administrator
 * Date: 13-2-15
 * Time: 下午2:26
 */
@javax.persistence.Table(name = "user", schema = "", catalog = "tess")
@Entity
public class UserEntity {
    private int userId;

    @javax.persistence.Column(name = "USER_ID", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private String userName;

    @javax.persistence.Column(name = "USER_NAME", nullable = true, insertable = true, updatable = true, length = 45, precision = 0)
    @Basic
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String password;

    @javax.persistence.Column(name = "PASSWORD", nullable = true, insertable = true, updatable = true, length = 45, precision = 0)
    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private Timestamp crateDt;

    @javax.persistence.Column(name = "CRATE_DT", nullable = true, insertable = true, updatable = true, length = 19, precision = 0)
    @Basic
    public Timestamp getCrateDt() {
        return crateDt;
    }

    public void setCrateDt(Timestamp crateDt) {
        this.crateDt = crateDt;
    }

    private String statusCd;

    @javax.persistence.Column(name = "STATUS_CD", nullable = true, insertable = true, updatable = true, length = 3, precision = 0)
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

        UserEntity that = (UserEntity) o;

        if (userId != that.userId) return false;
        if (crateDt != null ? !crateDt.equals(that.crateDt) : that.crateDt != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (statusCd != null ? !statusCd.equals(that.statusCd) : that.statusCd != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (crateDt != null ? crateDt.hashCode() : 0);
        result = 31 * result + (statusCd != null ? statusCd.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }

    private Collection<TessSessionEntity> tessSessionsByUserId;

    @OneToMany(mappedBy = "userByLoginUser")
    public Collection<TessSessionEntity> getTessSessionsByUserId() {
        return tessSessionsByUserId;
    }

    public void setTessSessionsByUserId(Collection<TessSessionEntity> tessSessionsByUserId) {
        this.tessSessionsByUserId = tessSessionsByUserId;
    }
}
