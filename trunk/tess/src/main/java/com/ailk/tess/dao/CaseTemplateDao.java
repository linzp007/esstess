package com.ailk.tess.dao;

import com.ailk.tess.entity.CaseTemplateEntity;
import com.trg.search.ISearch;
import com.trg.search.SearchResult;

import java.util.List;

/**
 * User: Administrator
 * Date: 13-2-15
 * Time: 上午1:43
 */
public interface CaseTemplateDao {
    /**
     *  新增CaseTemplate
     * @param caseTemplate
     */
    public void addCaseTemplate(CaseTemplateEntity caseTemplate);

    /**
     * 查找caseTemplateEntity
     * @param caseTemplateEntity
     * @return
     */
    public CaseTemplateEntity findCaseTemplate(CaseTemplateEntity caseTemplateEntity);

    /**
     * 根据分页条件, 找出指定范围内的CaseTemplate
     * @return
     */
    public SearchResult<CaseTemplateEntity> findAllCaseTemplatePaged(ISearch search);

    /**
     * 删除指定的CaseTemplate
     * @param caseTemplateEntity
     */
    public void deleteCaseTemplate(CaseTemplateEntity caseTemplateEntity);

    /**
     * 取得用例报文模板
     * @param caseTemplateId
     * @return
     */
    public String getTemplateXml(int caseTemplateId);
}
