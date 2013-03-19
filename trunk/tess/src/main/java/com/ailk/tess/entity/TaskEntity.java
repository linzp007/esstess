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
@javax.persistence.Table(name = "task", schema = "", catalog = "tess")
@Entity
public class TaskEntity {
    private int taskId;

    @javax.persistence.Column(name = "TASK_ID", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    private String taskName;

    @javax.persistence.Column(name = "TASK_NAME", nullable = false, insertable = true, updatable = true, length = 50, precision = 0)
    @Basic
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
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

        TaskEntity that = (TaskEntity) o;

        if (taskId != that.taskId) return false;
        if (createDt != null ? !createDt.equals(that.createDt) : that.createDt != null) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (manageCd != null ? !manageCd.equals(that.manageCd) : that.manageCd != null) return false;
        if (taskName != null ? !taskName.equals(that.taskName) : that.taskName != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taskId;
        result = 31 * result + (taskName != null ? taskName.hashCode() : 0);
        result = 31 * result + (manageCd != null ? manageCd.hashCode() : 0);
        result = 31 * result + (createDt != null ? createDt.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        return result;
    }

    private Collection<CaseTaskEntity> caseTasksByTaskId;

    @OneToMany(mappedBy = "taskByTaskId")
    public Collection<CaseTaskEntity> getCaseTasksByTaskId() {
        return caseTasksByTaskId;
    }

    public void setCaseTasksByTaskId(Collection<CaseTaskEntity> caseTasksByTaskId) {
        this.caseTasksByTaskId = caseTasksByTaskId;
    }

    private Collection<TaskExecutorEntity> taskExecutorsByTaskId;

    @OneToMany(mappedBy = "taskByTaskId")
    public Collection<TaskExecutorEntity> getTaskExecutorsByTaskId() {
        return taskExecutorsByTaskId;
    }

    public void setTaskExecutorsByTaskId(Collection<TaskExecutorEntity> taskExecutorsByTaskId) {
        this.taskExecutorsByTaskId = taskExecutorsByTaskId;
    }
}
