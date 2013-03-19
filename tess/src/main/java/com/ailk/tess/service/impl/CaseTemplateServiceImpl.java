package com.ailk.tess.service.impl;

import com.ailk.tess.dao.CaseTemplateDao;
import com.ailk.tess.entity.CaseTemplateEntity;
import com.ailk.tess.service.CaseTemplateService;
import com.ailk.tess.util.TessConst;
import com.trg.search.ISearch;
import com.trg.search.Search;
import com.trg.search.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: Administrator
 * Date: 13-2-15
 * Time: 上午1:09
 */
@Service
@Transactional
public class CaseTemplateServiceImpl implements CaseTemplateService{
    @Resource
    private CaseTemplateDao caseTemplateDao;

    @Transactional
    public void addCaseTemplate(CaseTemplateEntity caseTemplateEntity) {
        caseTemplateDao.addCaseTemplate(caseTemplateEntity);
    }

    public CaseTemplateEntity findCaseTemplateEntity(CaseTemplateEntity caseTemplateEntity){
        return  caseTemplateDao.findCaseTemplate(caseTemplateEntity);
    }

    public SearchResult<CaseTemplateEntity> findAllCaseTemplatePaged(int currPage) {
        Search search = new Search();
        search.setMaxResults(TessConst.PAGE_SIZE_CASE_TEMPLATE);
        return caseTemplateDao.findAllCaseTemplatePaged(search);
    }

    public void deleteCaseTemplate(CaseTemplateEntity caseTemplateEntity) {
        caseTemplateDao.deleteCaseTemplate(caseTemplateEntity);
    }
}
