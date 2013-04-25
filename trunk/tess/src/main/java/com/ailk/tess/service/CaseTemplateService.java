package com.ailk.tess.service;

import com.ailk.tess.entity.CaseTemplateEntity;
import com.trg.search.SearchResult;

import java.util.List;

/**
 * User: Administrator
 * Date: 13-2-15
 * Time: 上午1:09
 * @since V1.0
 */
public interface CaseTemplateService {

    /**
     *  新增用例模板
     */
    public void addCaseTemplate(CaseTemplateEntity caseTemplateEntity);

    /**
     * 查找  caseTemplateEntity
     * @return
     */
    public CaseTemplateEntity findCaseTemplateEntity(CaseTemplateEntity caseTemplateEntity);

    /**
     * 根据分页条件查找指定范围内的CaseTemplate
     * @param currPage
     * @return
     */
    public SearchResult<CaseTemplateEntity> findAllCaseTemplatePaged(int currPage);

    /**
     * 删除指定的CaseTemplate
     * @param caseTemplateEntity
     */
    public void deleteCaseTemplate(CaseTemplateEntity caseTemplateEntity);
    
    /**
     * 找到指定的TemplateXml
     * @param caseTemplateId
     * @return
     */
    public String getTemplateXml(int caseTemplateId);
}
