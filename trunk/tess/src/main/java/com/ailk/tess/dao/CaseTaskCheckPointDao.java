package com.ailk.tess.dao;

import com.ailk.tess.entity.CaseTaskCheckPointEntity;


public interface CaseTaskCheckPointDao {

	/**
	 * 保存用例任务检查点
	 * @param caseTaskCheckPointEntity
	 */
	public void saveCaseTaskCheckPoint(CaseTaskCheckPointEntity caseTaskCheckPointEntity);
	
	/**
	 * 查询用例任务检查点
	 * @param caseTaskCheckPointEntity
	 * @return
	 */
	public CaseTaskCheckPointEntity findCaseTaskCheckPoint(CaseTaskCheckPointEntity caseTaskCheckPointEntity);
	
	/**
	 * 查询用例任务检查点
	 * @param caseTaskCheckPointId
	 * @return
	 */
	public CaseTaskCheckPointEntity findCaseTaskCheckPoint(int caseTaskCheckPointId);
	
	/**
	 * 修改用例任务检查点
	 * @param caseTaskCheckPointEntity
	 */
	public void updateCaseTaskCheckPoint(CaseTaskCheckPointEntity caseTaskCheckPointEntity);
	
	/**
	 * 删除用例任务检查点
	 * @param caseTaskCheckPointEntity
	 */
	public void deleteCaseTaskCheckPoint(CaseTaskCheckPointEntity caseTaskCheckPointEntity);
	
	/**
	 * 删除用例任务检查点
	 * @param caseTaskCheckPointEntity
	 */
	public void deleteCaseTaskCheckPoint(int caseTaskCheckPointEntity);
}
