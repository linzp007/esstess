package com.ailk.tess.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * User: Administrator
 * Date: 13-2-15
 * Time: 下午2:26
 */
@javax.persistence.Table(name = "execute_method", schema = "", catalog = "tess")
@Entity
public class ExecuteMethodEntity {
    private int executeMethodId;

    @javax.persistence.Column(name = "EXECUTE_METHOD_ID", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getExecuteMethodId() {
        return executeMethodId;
    }

    public void setExecuteMethodId(int executeMethodId) {
        this.executeMethodId = executeMethodId;
    }

    private String uri;

    @javax.persistence.Column(name = "URI", nullable = false, insertable = true, updatable = true, length = 100, precision = 0)
    @Basic
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    private String paramTemplate;

    @javax.persistence.Column(name = "PARAM_TEMPLATE", nullable = false, insertable = true, updatable = true, length = 65535, precision = 0)
    @Basic
    public String getParamTemplate() {
        return paramTemplate;
    }

    public void setParamTemplate(String paramTemplate) {
        this.paramTemplate = paramTemplate;
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

    private int templateId;

    @javax.persistence.Column(name = "TEMPLATE_ID", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExecuteMethodEntity that = (ExecuteMethodEntity) o;

        if (executeMethodId != that.executeMethodId) return false;
        if (templateId != that.templateId) return false;
        if (createDt != null ? !createDt.equals(that.createDt) : that.createDt != null) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (paramTemplate != null ? !paramTemplate.equals(that.paramTemplate) : that.paramTemplate != null)
            return false;
        if (uri != null ? !uri.equals(that.uri) : that.uri != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = executeMethodId;
        result = 31 * result + (uri != null ? uri.hashCode() : 0);
        result = 31 * result + (paramTemplate != null ? paramTemplate.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (createDt != null ? createDt.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + templateId;
        return result;
    }

    private MethodTypeEntity methodTypeByMethodTypeId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "METHOD_TYPE_ID", referencedColumnName = "METHOD_TYPE_ID", nullable = false)
    public MethodTypeEntity getMethodTypeByMethodTypeId() {
        return methodTypeByMethodTypeId;
    }

    public void setMethodTypeByMethodTypeId(MethodTypeEntity methodTypeByMethodTypeId) {
        this.methodTypeByMethodTypeId = methodTypeByMethodTypeId;
    }

    private Collection<TaskExecutorEntity> taskExecutorsByExecuteMethodId;

    @OneToMany(mappedBy = "executeMethodByExtcuteMethodId")
    public Collection<TaskExecutorEntity> getTaskExecutorsByExecuteMethodId() {
        return taskExecutorsByExecuteMethodId;
    }

    public void setTaskExecutorsByExecuteMethodId(Collection<TaskExecutorEntity> taskExecutorsByExecuteMethodId) {
        this.taskExecutorsByExecuteMethodId = taskExecutorsByExecuteMethodId;
    }
}
