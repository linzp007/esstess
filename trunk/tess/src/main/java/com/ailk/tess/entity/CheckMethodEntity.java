package com.ailk.tess.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * User: Administrator
 * Date: 13-2-15
 * Time: 下午2:26
 */
@javax.persistence.Table(name = "check_method", schema = "", catalog = "tess")
@Entity
public class CheckMethodEntity {
    private int checkMethodId;

    @javax.persistence.Column(name = "CHECK_METHOD_ID", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getCheckMethodId() {
        return checkMethodId;
    }

    public void setCheckMethodId(int checkMethodId) {
        this.checkMethodId = checkMethodId;
    }

    private String valueSql;

    @javax.persistence.Column(name = "VALUE_SQL", nullable = false, insertable = true, updatable = true, length = 1000, precision = 0)
    @Basic
    public String getValueSql() {
        return valueSql;
    }

    public void setValueSql(String valueSql) {
        this.valueSql = valueSql;
    }

    private String compareExpression;

    @javax.persistence.Column(name = "COMPARE_EXPRESSION", nullable = false, insertable = true, updatable = true, length = 1000, precision = 0)
    @Basic
    public String getCompareExpression() {
        return compareExpression;
    }

    public void setCompareExpression(String compareExpression) {
        this.compareExpression = compareExpression;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CheckMethodEntity that = (CheckMethodEntity) o;

        if (checkMethodId != that.checkMethodId) return false;
        if (compareExpression != null ? !compareExpression.equals(that.compareExpression) : that.compareExpression != null)
            return false;
        if (valueSql != null ? !valueSql.equals(that.valueSql) : that.valueSql != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = checkMethodId;
        result = 31 * result + (valueSql != null ? valueSql.hashCode() : 0);
        result = 31 * result + (compareExpression != null ? compareExpression.hashCode() : 0);
        return result;
    }

    private Collection<CheckPointEntity> checkPointsByCheckMethodId;

    @OneToMany(mappedBy = "checkMethodByCheckMethodId")
    public Collection<CheckPointEntity> getCheckPointsByCheckMethodId() {
        return checkPointsByCheckMethodId;
    }

    public void setCheckPointsByCheckMethodId(Collection<CheckPointEntity> checkPointsByCheckMethodId) {
        this.checkPointsByCheckMethodId = checkPointsByCheckMethodId;
    }
}
