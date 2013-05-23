package com.ailk.tess.service;

import com.ailk.tess.entity.TaskEntity;
import com.trg.search.SearchResult;

public interface TaskService {
	 public SearchResult<TaskEntity> findAllTaskPaged(int currPage);
	 
	 /**
	  * 查找当前用例下所有任务
	  * @return
	  */
	 public SearchResult<TaskEntity> findTaskResult(String manageCd);
	 
	 /**
	  * 删除指定任务
	  */
	 public void deleteTask(TaskEntity taskEntity);

}
