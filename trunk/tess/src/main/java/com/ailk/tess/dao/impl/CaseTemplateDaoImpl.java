package com.ailk.tess.dao.impl;

import com.ailk.tess.controller.CaseTemplateController;
import com.ailk.tess.dao.BaseDao;
import com.ailk.tess.dao.CaseTemplateDao;
import com.ailk.tess.entity.CaseTemplateEntity;
import com.ailk.tess.entity.TemplateXmlEntity;
import com.trg.search.*;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.Log4jConfigListener;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: Administrator
 * Date: 13-2-15
 * Time: 上午1:44
 */
@Repository
public class CaseTemplateDaoImpl extends BaseDao<CaseTemplateEntity, Integer> implements CaseTemplateDao {

    public void addCaseTemplate(CaseTemplateEntity caseTemplate) {
       save(caseTemplate);
    }

    public CaseTemplateEntity findCaseTemplate(CaseTemplateEntity caseTemplateEntity) {
        return find(caseTemplateEntity.getTemplateId());
    }

    public SearchResult<CaseTemplateEntity> findAllCaseTemplatePaged(ISearch search) {
        SearchResult<CaseTemplateEntity> searchResult = searchAndCount(search);
        return searchResult;
    }

    public void deleteCaseTemplate(CaseTemplateEntity caseTemplateEntity) {
        removeById(caseTemplateEntity.getTemplateId());
    }

    public String getTemplateXml(int caseTemplateId) {
    	TemplateXmlEntity templateXmlEntity = (TemplateXmlEntity) getSession().get(TemplateXmlEntity.class, caseTemplateId);
    	if(templateXmlEntity == null){
    		return "is null";
    	}
 	    return templateXmlEntity.getTemplateContent();
    }

}
