package com.ailk.tess.dao.impl;

import org.springframework.stereotype.Repository;

import com.ailk.tess.dao.BaseDao;
import com.ailk.tess.dao.CaseTaskCheckPointDao;
import com.ailk.tess.entity.CaseTaskCheckPointEntity;

@Repository
public class CaseTaskCheckPointDaoImpl extends BaseDao<CaseTaskCheckPointEntity, Integer> implements CaseTaskCheckPointDao {

	/*
	 * (non-Javadoc)
	 * @see com.ailk.tess.dao.CaseTaskCheckPointDao#saveCaseTaskCheckPoint(com.ailk.tess.entity.CaseTaskCheckPointEntity)
	 */
	public void saveCaseTaskCheckPoint(CaseTaskCheckPointEntity caseTaskCheckPointEntity) {
		save(caseTaskCheckPointEntity);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ailk.tess.dao.CaseTaskCheckPointDao#findCaseTaskCheckPoint(com.ailk.tess.entity.CaseTaskCheckPointEntity)
	 */
	public CaseTaskCheckPointEntity findCaseTaskCheckPoint(CaseTaskCheckPointEntity caseTaskCheckPointEntity) {
		return find(caseTaskCheckPointEntity.getCaseTaskCheckPointId());
	}

	/*
	 * (non-Javadoc)
	 * @see com.ailk.tess.dao.CaseTaskCheckPointDao#findCaseTaskCheckPoint(int)
	 */
	public CaseTaskCheckPointEntity findCaseTaskCheckPoint(int caseTaskCheckPointId) {
		return find(caseTaskCheckPointId);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ailk.tess.dao.CaseTaskCheckPointDao#updateCaseTaskCheckPoint(com.ailk.tess.entity.CaseTaskCheckPointEntity)
	 */
	public void updateCaseTaskCheckPoint(CaseTaskCheckPointEntity caseTaskCheckPointEntity) {
		getSession().update(caseTaskCheckPointEntity);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ailk.tess.dao.CaseTaskCheckPointDao#deleteCaseTaskCheckPoint(com.ailk.tess.entity.CaseTaskCheckPointEntity)
	 */
	public void deleteCaseTaskCheckPoint(CaseTaskCheckPointEntity caseTaskCheckPointEntity) {
		removeById(caseTaskCheckPointEntity.getCaseTaskCheckPointId());
	}

	/*
	 * (non-Javadoc)
	 * @see com.ailk.tess.dao.CaseTaskCheckPointDao#deleteCaseTaskCheckPoint(int)
	 */
	public void deleteCaseTaskCheckPoint(int caseTaskCheckPointId) {
		removeById(caseTaskCheckPointId);
	}

}
