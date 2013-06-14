package com.ailk.tess.dao;

import com.ailk.tess.entity.CaseTaskEntity;
import com.trg.search.ISearch;
import com.trg.search.SearchResult;

public interface CaseTaskDao {
	
	/**
	 * 查找指定用例下的所以任务
	 * @param 
	 */
	public SearchResult<CaseTaskEntity> findCaseTaskEntityList(ISearch search);
	
	/**
	 * 删除指定的用例下的任务
	 * @param 
	 */
	public void deleteCaseTaskEntity(CaseTaskEntity caseTaskEntity);

}
