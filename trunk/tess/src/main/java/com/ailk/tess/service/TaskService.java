package com.ailk.tess.service;

import com.ailk.tess.entity.TaskEntity;
import com.trg.search.SearchResult;

public interface TaskService {
	 public SearchResult<TaskEntity> findAllTaskPaged(int currPage);

}
