package com.ailk.tess.dao;

import java.sql.Timestamp;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ailk.tess.BaseTest;
import com.ailk.tess.entity.CheckPointEntity;

public class TestCheckPointDao extends BaseTest {

	@Autowired
	private CheckPointDao checkPointDao;
	
	@Test
	public void testSaveCheckPoint() {
		CheckPointEntity checkPointEntity = new CheckPointEntity();
		checkPointEntity.setCheckPointId(1);
		checkPointEntity.setCheckPointName("TEST");
		checkPointEntity.setCreateDt(new Timestamp(System.currentTimeMillis()));
		checkPointEntity.setDescription("just test");
		checkPointEntity.setVersion(new Timestamp(System.currentTimeMillis()));
		checkPointEntity.setManageCd("test99");
		checkPointDao.saveCheckPoint(checkPointEntity);
	}
}
