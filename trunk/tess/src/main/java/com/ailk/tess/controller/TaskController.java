package com.ailk.tess.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ailk.tess.dto.CaseTaskDto;
import com.ailk.tess.dto.CaseTemplateDto;
import com.ailk.tess.dto.ResultDto;
import com.ailk.tess.dto.TaskDto;
import com.ailk.tess.entity.CaseTaskEntity;
import com.ailk.tess.entity.CaseTemplateEntity;
import com.ailk.tess.entity.TaskEntity;
import com.ailk.tess.service.TaskService;
import com.trg.search.SearchResult;

@Controller
@RequestMapping("/task")
public class TaskController {
	private static Logger log = Logger.getLogger(CaseTemplateController.class);
	
	@Autowired
    private TaskService taskService;
	
	/**
     * 获取用例任务列表
     * @param caseTemplateDto
     * @return
     */
	@RequestMapping("/taskList")
    @ResponseBody
    public SearchResult<TaskDto> getAllTask(CaseTemplateDto caseTemplateDto){
    	SearchResult<TaskEntity> searchResult = taskService.findTaskResult(caseTemplateDto.getTemplateId());
    	List<TaskDto> taskDtos = new ArrayList<TaskDto>();
    	for (int i = 0; i < searchResult.getResult().size(); i++){
    		TaskDto dto = new TaskDto();
    		BeanUtils.copyProperties(searchResult.getResult().get(i),dto);
    		taskDtos.add(dto);
    	}
    	SearchResult<TaskDto> searchResultDto = new SearchResult<TaskDto>();
    	searchResultDto.setTotalCount(searchResult.getTotalCount());
    	searchResultDto.setResult(taskDtos);
    	return searchResultDto;
    }
	
	/**
     * 获取任务列表
     * @return
     */
	@RequestMapping("/readTask")
    @ResponseBody
    public SearchResult<TaskDto> getAllTask() {
		SearchResult<TaskEntity> searchResult = taskService.findAllTask();
		List<TaskDto> taskDtos = new ArrayList<TaskDto>();
		for (int i = 0; i < searchResult.getResult().size(); i++){
    		TaskDto dto = new TaskDto();
    		BeanUtils.copyProperties(searchResult.getResult().get(i),dto);
    		taskDtos.add(dto);
    	}
    	SearchResult<TaskDto> searchResultDto = new SearchResult<TaskDto>();
    	searchResultDto.setTotalCount(searchResult.getTotalCount());
    	searchResultDto.setResult(taskDtos);
    	return searchResultDto;
	}
	
	/**
     * 增加用例任务
     * @param caseTaskDto
     * @return
     */
	@RequestMapping("/addCaseTask")
	@ResponseBody
	public ResultDto addCaseTask(CaseTaskDto caseTaskDto){
		ResultDto result = ResultDto.defaultResult();
		CaseTaskEntity caseTaskEntity = new CaseTaskEntity();
		CaseTemplateEntity caseTemplateEntity = new CaseTemplateEntity();
		caseTemplateEntity.setTemplateId(caseTaskDto.getTemplateId());
		caseTaskEntity.setCaseTemplateByTemplateId(caseTemplateEntity);
		TaskEntity taskByTaskId = new TaskEntity();
		taskByTaskId.setTaskId(caseTaskDto.getTaskId());
		caseTaskEntity.setTaskByTaskId(taskByTaskId);
		caseTaskEntity.setStatusCd("1");
		try {
			taskService.addCaseTaskEntity(caseTaskEntity);
		} catch (Exception e) {
			log.error("增加任务出错:{}", e);
    		result.setCode(ResultDto.FAIL);
    		result.setMsg(e.getMessage());
		}
		return result;
	}
	
	
    /**
     * 删除任务
     * @param taskDto
     * @return
     */
    @RequestMapping("/delete/{templateId}")
    @ResponseBody
    public ResultDto deleteTask(TaskDto taskDto, @PathVariable("templateId") int templateId){
    	ResultDto result = ResultDto.defaultResult();
    	
    	try{
    		SearchResult<CaseTaskEntity> searchResult= taskService.findCaseTaskEntity(templateId, taskDto.getTaskId());
    		taskService.deleteCaseTaskEntity(searchResult.getResult().get(0));
    		
    		
    	}catch(Exception e){
    		log.error("删除任务出错:{}", e);
    		result.setCode(ResultDto.FAIL);
    		result.setMsg(e.getMessage());
    	}
    	return result;
    }

}
