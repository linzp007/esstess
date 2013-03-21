package com.ailk.tess.dao;

import com.ailk.tess.entity.CheckPointEntity;

public interface CheckPointDao {

	/**
	 * 保存检查点
	 * @param checkPointEntity
	 */
	public void saveCheckPoint(CheckPointEntity checkPointEntity);
	
	/**
	 * 查询检查点
	 * @param checkPointEntity
	 * @return
	 */
	public CheckPointEntity findCheckPoint(CheckPointEntity checkPointEntity);
	
	/**
	 * 查询检查点
	 * @param checkPointId
	 * @return
	 */
	public CheckPointEntity findCheckPoint(Integer checkPointId);
	
	/**
	 * 修改检查点
	 * @param checkPointEntity
	 */
	public void updateCheckPoint(CheckPointEntity checkPointEntity);
	
	/**
	 * 删除检查点
	 * @param checkPointEntity
	 */
	public void deleteCheckPoint(CheckPointEntity checkPointEntity);
}
