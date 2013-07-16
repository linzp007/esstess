package com.ailk.tess.dao;

import com.ailk.tess.entity.TaskEntity;
import com.trg.search.ISearch;
import com.trg.search.SearchResult;

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
	 * 查找指定用例下的所以任务
	 * @param 
	 */
	public SearchResult<TaskEntity> findTaskEntityList(ISearch search);
	
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
	
	/**
     * 查找所有任务
     * @param search
     * @return
     */
	public SearchResult<TaskEntity> findAllTask(ISearch search);
}
