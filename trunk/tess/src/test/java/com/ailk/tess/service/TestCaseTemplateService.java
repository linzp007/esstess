package com.ailk.tess.service;

import com.ailk.tess.BaseTest;
import com.ailk.tess.dto.CaseTemplateDto;
import com.ailk.tess.entity.CaseTemplateEntity;
import com.ailk.tess.util.TessConst;
import com.trg.search.SearchResult;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * User: Administrator
 * Date: 13-2-15
 * Time: 下午4:16
 */
public class TestCaseTemplateService extends BaseTest {
    private static Logger log = Logger.getLogger(TestCaseTemplateService.class);
    @Autowired
    private CaseTemplateService caseTemplateService;

    @Test
    public void testSaveCaseTemplate() {
        CaseTemplateEntity caseTemplate = new CaseTemplateEntity();
        caseTemplate.setManageCd("CASE0029");
        caseTemplate.setStatusCd(TessConst.CaseTemplateStatus.ENABLE);
        caseTemplate.setCreateDt(new Timestamp(new Date().getTime()));
        caseTemplate.setTemplateName("接入类订单下发");
        caseTemplateService.addCaseTemplate(caseTemplate);
    }

    @Test
    public void testFindAllCaseTemplatePaged() {
        SearchResult<CaseTemplateEntity> caseTemplateEntityList = caseTemplateService.findAllCaseTemplatePaged(1);
        System.out.println(caseTemplateEntityList.getResult().get(0).getTemplateName());
    }
}
