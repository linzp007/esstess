package com.ailk.tess.dao;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ailk.tess.BaseTest;
import com.ailk.tess.entity.TaskEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestTaskDao extends BaseTest {

	@Autowired
	private TaskDao taskDao;
	
	private Logger logger = Logger.getLogger(TestTaskDao.class);
	
	//@Test
	public void testSaveTaskEntity() {
		TaskEntity taskEntity = new TaskEntity();
		taskEntity.setCreateDt(new Timestamp(System.currentTimeMillis()));
		taskEntity.setDescription("just test");
		taskEntity.setManageCd("TEST-001");
		taskEntity.setTaskId(1);
		taskEntity.setTaskName("测试任务");
		taskEntity.setVersion(new Timestamp(System.currentTimeMillis()));
		taskDao.addTaskEntity(taskEntity);
	}
	
	
	public void testFindTaskEntity() {
		TaskEntity taskEntity = new TaskEntity();
		taskEntity.setTaskId(1);
		TaskEntity result = taskDao.findTaskEntity(taskEntity);
		logger.debug("result=" +  new Gson().toJson(result));
	}
	
	@Test
	public void testUpdateTaskEntity() {
		TaskEntity taskEntity = new TaskEntity();
		taskEntity.setTaskId(1);
		TaskEntity result = taskDao.findTaskEntity(taskEntity);
		result.setTaskName("再来一下");
		result.setManageCd("UUU");
		taskDao.updateTaskEntity(result);
	}
}
