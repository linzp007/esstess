package com.ailk.tess.dao.impl;

import org.springframework.stereotype.Repository;

import com.ailk.tess.dao.BaseDao;
import com.ailk.tess.dao.CheckPointDao;
import com.ailk.tess.entity.CheckPointEntity;
@Repository
public class CheckPointDaoImpl extends BaseDao<CheckPointEntity, Integer> implements CheckPointDao {

	/*
	 * (non-Javadoc)
	 * @see com.ailk.tess.dao.CheckPointDao#saveCheckPoint(com.ailk.tess.entity.CheckPointEntity)
	 */
	public void saveCheckPoint(CheckPointEntity checkPointEntity) {
		save(checkPointEntity);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ailk.tess.dao.CheckPointDao#findCheckPoint(com.ailk.tess.entity.CheckPointEntity)
	 */
	public CheckPointEntity findCheckPoint(CheckPointEntity checkPointEntity) {
		return find(checkPointEntity.getCheckPointId());
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.ailk.tess.dao.CheckPointDao#findCheckPoint(java.lang.Integer)
	 */
	public CheckPointEntity findCheckPoint(Integer checkPointId) {
		return find(checkPointId);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ailk.tess.dao.CheckPointDao#updateCheckPoint(com.ailk.tess.entity.CheckPointEntity)
	 */
	public void updateCheckPoint(CheckPointEntity checkPointEntity) {
		getSession().update(checkPointEntity);
	}

	/*
	 * (non-Javadoc)
	 * @see com.ailk.tess.dao.CheckPointDao#deleteCheckPoint(com.ailk.tess.entity.CheckPointEntity)
	 */
	public void deleteCheckPoint(CheckPointEntity checkPointEntity) {
		removeById(checkPointEntity.getCheckPointId());
	}

}
