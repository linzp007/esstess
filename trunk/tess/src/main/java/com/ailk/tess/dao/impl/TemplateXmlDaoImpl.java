package com.ailk.tess.dao.impl;

import org.springframework.stereotype.Repository;

import com.ailk.tess.dao.BaseDao;
import com.ailk.tess.dao.TemplateXmlDao;
import com.ailk.tess.entity.TemplateXmlEntity;

@Repository
public class TemplateXmlDaoImpl extends BaseDao<TemplateXmlEntity, Integer> implements TemplateXmlDao {

	public void addTemplateXml(TemplateXmlEntity templateXml) {
		save(templateXml);
	}

}
