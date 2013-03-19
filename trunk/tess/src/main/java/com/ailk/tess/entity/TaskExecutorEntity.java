package com.ailk.tess.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * User: Administrator
 * Date: 13-2-15
 * Time: 下午2:26
 */
@javax.persistence.Table(name = "task_executor", schema = "", catalog = "tess")
@Entity
public class TaskExecutorEntity {
    private int taskExecutorId;

    @javax.persistence.Column(name = "TASK_EXECUTOR_ID", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getTaskExecutorId() {
        return taskExecutorId;
    }

    public void setTaskExecutorId(int taskExecutorId) {
        this.taskExecutorId = taskExecutorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskExecutorEntity that = (TaskExecutorEntity) o;

        if (taskExecutorId != that.taskExecutorId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return taskExecutorId;
    }

    private ExecuteMethodEntity executeMethodByExtcuteMethodId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "EXTCUTE_METHOD_ID", referencedColumnName = "EXECUTE_METHOD_ID", nullable = false)
    public ExecuteMethodEntity getExecuteMethodByExtcuteMethodId() {
        return executeMethodByExtcuteMethodId;
    }

    public void setExecuteMethodByExtcuteMethodId(ExecuteMethodEntity executeMethodByExtcuteMethodId) {
        this.executeMethodByExtcuteMethodId = executeMethodByExtcuteMethodId;
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
}
