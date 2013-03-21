package com.ailk.tess.dao.impl;

import org.springframework.stereotype.Repository;

import com.ailk.tess.dao.BaseDao;
import com.ailk.tess.dao.TaskDao;
import com.ailk.tess.entity.TaskEntity;

@Repository
public class TaskDaoImpl extends BaseDao<TaskEntity, Integer> implements TaskDao{

	/*
	 * (non-Javadoc)
	 * @see com.ailk.tess.dao.TaskDao#addTaskEntity(com.ailk.tess.entity.TaskEntity)
	 */
	public void addTaskEntity(TaskEntity taskEntity) {
		save(taskEntity);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ailk.tess.dao.TaskDao#findTaskEntity(com.ailk.tess.entity.TaskEntity)
	 */
	public TaskEntity findTaskEntity(TaskEntity taskEntity) {
		return find(taskEntity.getTaskId());
	}

	/*
	 * (non-Javadoc)
	 * @see com.ailk.tess.dao.TaskDao#updateTaskEntity(com.ailk.tess.entity.TaskEntity)
	 */
	public void updateTaskEntity(TaskEntity taskEntity) {
		getSession().update(taskEntity);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ailk.tess.dao.TaskDao#deleteTaskEntity(com.ailk.tess.entity.TaskEntity)
	 */
	public void deleteTaskEntity(TaskEntity taskEntity) {
		removeById(taskEntity.getTaskId());
	}

}
