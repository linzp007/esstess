package com.ailk.tess.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ailk.tess.controller.CaseTemplateController;
import com.ailk.tess.dao.TemplateXmlDao;
import com.ailk.tess.entity.TemplateXmlEntity;
import com.ailk.tess.service.TemplateXmlService;

@Service
@Transactional
public class TemplateXmlServiceImpl implements TemplateXmlService {
	@Resource
	private TemplateXmlDao templateXmlDao;
	
	@Transactional
	public void addTemplateXml(TemplateXmlEntity templateXmlEntity) {
		templateXmlDao.addTemplateXml(templateXmlEntity);
	}

}
