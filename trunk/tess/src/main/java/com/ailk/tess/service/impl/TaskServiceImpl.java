package com.ailk.tess.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ailk.tess.dao.CaseTaskDao;
import com.ailk.tess.dao.TaskDao;
import com.ailk.tess.entity.CaseTaskEntity;
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
	@Resource
	private CaseTaskDao caseTaskDao;

	@Transactional
	public SearchResult<TaskEntity> findAllTask() {
		Search search = new Search();
        //search.setMaxResults(TessConst.PAGE_SIZE_TASK);
		return taskDao.findAllTask(search);
	}
	
	public SearchResult<TaskEntity> findTaskResult(int templateId){
		Search search = new Search();
		search.addFilterEqual("caseTasksByTaskId.caseTemplateByTemplateId.templateId", templateId);
		search.addSort("caseTasksByTaskId.caseTaskSeq", false);
		return taskDao.findTaskEntityList(search);
	}
	
	public void deleteCaseTaskEntity(CaseTaskEntity caseTaskEntity){
		caseTaskDao.deleteCaseTaskEntity(caseTaskEntity);
	}
	
	public void addCaseTaskEntity(CaseTaskEntity caseTaskEntity) {
		caseTaskDao.addCaseTaskEntity(caseTaskEntity);
	}
	
	public SearchResult<CaseTaskEntity> findCaseTaskEntity(int templateId,int taskId) {
		Search search = new Search();
		search.addFilterEqual("caseTemplateByTemplateId.templateId", templateId);
		search.addFilterEqual("taskByTaskId.taskId",taskId);
		return caseTaskDao.findCaseTaskEntityList(search);
	}

}
