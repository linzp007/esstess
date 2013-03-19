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
@javax.persistence.Table(name = "method_type", schema = "", catalog = "tess")
@Entity
public class MethodTypeEntity {
    private int methodTypeId;

    @javax.persistence.Column(name = "METHOD_TYPE_ID", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getMethodTypeId() {
        return methodTypeId;
    }

    public void setMethodTypeId(int methodTypeId) {
        this.methodTypeId = methodTypeId;
    }

    private String methodTypeName;

    @javax.persistence.Column(name = "METHOD_TYPE_NAME", nullable = true, insertable = true, updatable = true, length = 45, precision = 0)
    @Basic
    public String getMethodTypeName() {
        return methodTypeName;
    }

    public void setMethodTypeName(String methodTypeName) {
        this.methodTypeName = methodTypeName;
    }

    private String desc;

    @javax.persistence.Column(name = "DESC", nullable = true, insertable = true, updatable = true, length = 100, precision = 0)
    @Basic
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MethodTypeEntity that = (MethodTypeEntity) o;

        if (methodTypeId != that.methodTypeId) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (methodTypeName != null ? !methodTypeName.equals(that.methodTypeName) : that.methodTypeName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = methodTypeId;
        result = 31 * result + (methodTypeName != null ? methodTypeName.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        return result;
    }

    private Collection<ExecuteMethodEntity> executeMethodsByMethodTypeId;

    @OneToMany(mappedBy = "methodTypeByMethodTypeId")
    public Collection<ExecuteMethodEntity> getExecuteMethodsByMethodTypeId() {
        return executeMethodsByMethodTypeId;
    }

    public void setExecuteMethodsByMethodTypeId(Collection<ExecuteMethodEntity> executeMethodsByMethodTypeId) {
        this.executeMethodsByMethodTypeId = executeMethodsByMethodTypeId;
    }
}
