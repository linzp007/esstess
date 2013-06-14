package com.ailk.tess.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ailk.tess.controller.CaseTemplateController;
import com.ailk.tess.dao.BaseDao;
import com.ailk.tess.dao.CaseTaskDao;
import com.ailk.tess.entity.CaseTaskEntity;
import com.trg.search.ISearch;
import com.trg.search.SearchResult;

@Repository
public class CaseTaskDaoImpl extends BaseDao<CaseTaskEntity, Integer> implements CaseTaskDao {
	private static Logger log = Logger.getLogger(CaseTemplateController.class);

	public SearchResult<CaseTaskEntity> findCaseTaskEntityList(ISearch search) {
		log.debug("dao....");
		SearchResult<CaseTaskEntity> searchResult = searchAndCount(search);
		return searchResult;
	}
	
	public void deleteCaseTaskEntity(CaseTaskEntity caseTaskEntity) {
		remove(caseTaskEntity);
	}

}
