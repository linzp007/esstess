package com.ailk.tess.dao;

import com.ailk.tess.entity.TaskEntity;

public interface TaskDao {

	/**
	 * 增加任务
	 * @param taskEntity
	 */
	public void addTaskEntity(TaskEntity taskEntity);
	
	/**
	 * 查找任务
	 * @param taskEntity
	 */
	public TaskEntity findTaskEntity(TaskEntity taskEntity);
	
	/**
	 * 修改任务
	 * @param taskEntity
	 */
	public void updateTaskEntity(TaskEntity taskEntity);
	
	/**
	 * 删除任务
	 * @param taskEntity
	 */
	public void deleteTaskEntity(TaskEntity taskEntity);
}
