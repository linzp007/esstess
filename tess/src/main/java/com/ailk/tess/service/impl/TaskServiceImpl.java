package com.ailk.tess.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ailk.tess.dao.TaskDao;
import com.ailk.tess.entity.TaskEntity;
import com.ailk.tess.service.TaskService;
import com.ailk.tess.util.TessConst;
import com.trg.search.Search;
import com.trg.search.SearchResult;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
	@Resource
	private TaskDao taskDao;

	@Transactional
	public SearchResult<TaskEntity> findAllTaskPaged(int currPage) {
		Search search = new Search();
        search.setMaxResults(TessConst.PAGE_SIZE_TASK);
        search.setPage(currPage - 1);
		return taskDao.findAllTaskPaged(search);
	}

}
