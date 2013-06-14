package com.ailk.tess.service;

import com.ailk.tess.entity.CaseTaskEntity;
import com.ailk.tess.entity.TaskEntity;
import com.trg.search.SearchResult;

public interface TaskService {
	// public SearchResult<TaskEntity> findAllTaskPaged(int currPage);
	 
	 /**
	  * 查找当前用例下所有任务
	  * @return
	  */
	 public SearchResult<TaskEntity> findTaskResult(int templateId);
	 
	 /**
	  * 删除指定用例下的任务
	  */
	 public void deleteCaseTaskEntity(CaseTaskEntity caseTaskEntity);
	 
	 /**
	  * 根据templateId,taskId查找对应的caseTaskEntity
	  */
	 public SearchResult<CaseTaskEntity> findCaseTaskEntity(int templateId,int taskId);

}
