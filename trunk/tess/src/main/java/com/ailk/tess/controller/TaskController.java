package com.ailk.tess.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ailk.tess.dto.TaskDto;
import com.ailk.tess.entity.TaskEntity;
import com.ailk.tess.service.TaskService;
import com.trg.search.SearchResult;

@Controller
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
    private TaskService taskService;
	
	/**
     * 获取用例任务列表
     * @param currPage
     * @return
     */
    @RequestMapping("/taskList/{currPage}")
    @ResponseBody
    public SearchResult<TaskDto> getAllCaseTask(@PathVariable("currPage") int currPage){
    	SearchResult<TaskEntity> searchResult = taskService.findAllTaskPaged(currPage);
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

}
