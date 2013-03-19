package com.ailk.tess.service.impl;

import com.ailk.tess.dao.CaseTemplateDao;
import com.ailk.tess.entity.CaseTemplateEntity;
import com.ailk.tess.metadata.MetaData;
import com.ailk.tess.service.RuncaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: Administrator
 * Date: 13-2-21
 * Time: 涓婂崍12:11
 */
@Service
public class RuncaseServiceImpl implements RuncaseService {

    @Autowired
    private CaseTemplateDao caseTemplateDao;
    public void run(int caseTemplateId) {
        // 1, 鍙栧嚭鐢ㄤ緥淇℃伅
        CaseTemplateEntity caseTemplateEntity = new CaseTemplateEntity();
        caseTemplateEntity.setTemplateId(caseTemplateId);
        caseTemplateEntity = caseTemplateDao.findCaseTemplate(caseTemplateEntity);

        // 2, 鍙栧嚭妯℃澘
        String xmlTemplate = caseTemplateDao.getTemplateXml(caseTemplateId);
        // instantiateTemplate(xmlTemplate, metadata)
        // 3, 鐢熸垚ID
        // 4, 鍙栧嚭绗竴鏉′换鍔�
        // 5, 鎵ц浠诲姟(浠诲姟鎵ц缁撴潫鍚� 浼氳Е鍙戞鏌ョ偣妫�煡, 瀹屼簡鎵ц涓嬩竴涓换鍔�
    }

    public void instantiateTemplate(String xmlTemplate, MetaData tessMetadata) {
        //1, 鍙栧緱鎵�湁鍗犱綅绗�
        //2, 閬嶅巻鍗犱綅绗�
        //鐢熸垚, 骞跺啓鍥炴姤鏂囦腑, 璁板綍鍒癿etadata涓�

    }
}
