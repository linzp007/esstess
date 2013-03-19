package com.ailk.tess.dao;

import com.ailk.tess.BaseTest;
import com.ailk.tess.entity.CaseTemplateEntity;
import com.ailk.tess.util.TessConst;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;

import java.sql.Timestamp;
import java.util.Date;

/**
 * User: Administrator
 * Date: 13-2-17
 * Time: 下午2:49
 */
public class TestCaseTemplateDao extends BaseTest {
    private static Logger log = Logger.getLogger(TestCaseTemplateDao.class);

    @Autowired
    private CaseTemplateDao caseTemplateDao;

    //@Test
    public void testSaveCaseTemplate() {

        CaseTemplateEntity caseTemplate = new CaseTemplateEntity();
        caseTemplate.setManageCd("CASE2004");
        caseTemplate.setStatusCd(TessConst.CaseTemplateStatus.ENABLE);
        caseTemplate.setCreateDt(new Timestamp(new Date().getTime()));
        caseTemplate.setTemplateName("接入类订单下发");
        caseTemplateDao.addCaseTemplate(caseTemplate);
    }

    @Test
    public void testDeleteCaseTemplate() {
        CaseTemplateEntity caseTemplate = new CaseTemplateEntity();
        caseTemplate.setTemplateId(50);
        caseTemplateDao.deleteCaseTemplate(caseTemplate);
    }

}
