package com.ailk.tess.controller;


import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ailk.tess.dto.CaseTemplateDto;
import com.ailk.tess.dto.ResultDto;
import com.ailk.tess.dto.TaskDto;
import com.ailk.tess.dto.TemplateXmlDto;
import com.ailk.tess.entity.CaseTemplateEntity;
import com.ailk.tess.entity.TaskEntity;
import com.ailk.tess.entity.TemplateXmlEntity;
import com.ailk.tess.service.CaseTemplateService;
import com.ailk.tess.service.TaskService;
import com.ailk.tess.service.TemplateXmlService;

import static com.ailk.tess.util.TessConst.*;
import com.ailk.tess.util.TessUtils;
import com.trg.search.SearchResult;

/**
 * User: Administrator
 * Date: 13-2-16
 * Time: 下午4:57
 */
@Controller
@RequestMapping("/casetemplate")
public class CaseTemplateController {
    private static Logger log = Logger.getLogger(CaseTemplateController.class);

    @Autowired
    private CaseTemplateService caseTemplateService;
    @Autowired
    private TemplateXmlService templateXmlService;

    /**
     * 获取用例模板列表
     * @param currPage
     * @return
     */
    @RequestMapping("/list/{currPage}")
    @ResponseBody
    public SearchResult<CaseTemplateDto> getAllCaseTemplatePaged(@PathVariable("currPage") int currPage) {
        SearchResult<CaseTemplateEntity> searchResult = caseTemplateService.findAllCaseTemplatePaged(currPage);
        List<CaseTemplateDto> ctemplateDtos = new ArrayList<CaseTemplateDto>();
        for (int i = 0; i < searchResult.getResult().size(); i++) {
           CaseTemplateDto dto = new CaseTemplateDto();
           BeanUtils.copyProperties(searchResult.getResult().get(i),dto);
           ctemplateDtos.add(dto);
        }
        SearchResult<CaseTemplateDto> searchResultDto = new SearchResult<CaseTemplateDto>();
        searchResultDto.setTotalCount(searchResult.getTotalCount());
        searchResultDto.setResult(ctemplateDtos);
        return searchResultDto;
    }
    
    /**
     * 显示用例模板细节
     * @param caseTemplateDto
     * @return
     */
    @RequestMapping("/detail")
    @ResponseBody
    public CaseTemplateDto displayCaseTemplate(CaseTemplateDto caseTemplateDto){
    	ResultDto result = ResultDto.defaultResult();
    	try {
    		CaseTemplateEntity caseTemplateEntity = new CaseTemplateEntity();
    		caseTemplateEntity.setTemplateId(caseTemplateDto.getTemplateId());
    		caseTemplateEntity=caseTemplateService.findCaseTemplateEntity(caseTemplateEntity);
    		caseTemplateDto.setManageCd(caseTemplateEntity.getManageCd());
    		caseTemplateDto.setTemplateName(caseTemplateEntity.getTemplateName());
    		caseTemplateDto.setStatusCd(caseTemplateEntity.getStatusCd());
    	} catch (Exception e) {
    		log.error("修改用例模版出错:{}", e);
    		result.setCode(ResultDto.FAIL);
    		result.setMsg(e.getMessage());
    	}
    	return caseTemplateDto;
    }
    
    /**
     * 修改用例模板
     * @param caseTemplateDto
     * @return
     */
    @RequestMapping("/modify")
    @ResponseBody
    public ResultDto modifyCaseTemplate(CaseTemplateDto caseTemplateDto){
    	ResultDto result = ResultDto.defaultResult();
    	try {
    		CaseTemplateEntity caseTemplateEntity = new CaseTemplateEntity();
    		caseTemplateEntity.setTemplateId(caseTemplateDto.getTemplateId());
    		caseTemplateEntity = caseTemplateService.findCaseTemplateEntity(caseTemplateEntity);
    		caseTemplateEntity.setTemplateName(caseTemplateDto.getTemplateName());
    		caseTemplateEntity.setManageCd(caseTemplateDto.getManageCd());
    		caseTemplateEntity.setStatusCd(caseTemplateDto.getStatusCd());
    		caseTemplateService.addCaseTemplate(caseTemplateEntity);
    	} catch (Exception e) {
    		log.error("修改除用例模版出错:{}", e);
    		result.setCode(ResultDto.FAIL);
    		result.setMsg(e.getMessage());
    	}
    	return result;
    }
    
    /**
     * 删除用例模板
     * @param caseTemplateDto
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResultDto deleteCaseTemplate(CaseTemplateDto caseTemplateDto){
    	ResultDto result = ResultDto.defaultResult();
    	try {
    		CaseTemplateEntity caseTemplateEntity = new CaseTemplateEntity();
    		caseTemplateEntity.setTemplateId(caseTemplateDto.getTemplateId());
    		caseTemplateService.deleteCaseTemplate(caseTemplateEntity);	
    	} catch (Exception e) {
    		log.error("删除用例模版出错:{}", e);
    		result.setCode(ResultDto.FAIL);
    		result.setMsg(e.getMessage());
    	}
    	return result;
    }
    
    /**
     * 新增用例模板
     * @param caseTemplateDto
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public ResultDto addCaseTemplate(@Valid @ModelAttribute("caseTemplate") CaseTemplateDto caseTemplateDto, BindingResult br) {
    	ResultDto result = ResultDto.defaultResult();
    	if(br.hasErrors()){
    		List<FieldError> fieldError = br.getFieldErrors();
    		String msg ="";
    		for (Iterator<FieldError> it = fieldError.iterator(); it.hasNext();){
    			FieldError error = it.next();
    			msg = msg + error.getField() + "@" + error.getDefaultMessage()+"|";
    			
    		}
    		result.setMsg(msg);
    		result.setCode(ResultDto.FAIL);
    		return result;
    	}
    	try {
    		CaseTemplateEntity caseTemplateEntity = new CaseTemplateEntity();
    		caseTemplateEntity.setTemplateName(caseTemplateDto.getTemplateName());
    		caseTemplateEntity.setManageCd(caseTemplateDto.getManageCd());
    		caseTemplateEntity.setCreateDt(TessUtils.getSysTimeStamp());
    		caseTemplateEntity.setVersion(TessUtils.getSysTimeStamp());
    		caseTemplateEntity.setStatusCd(CaseTemplateStatus.ENABLE);
    		caseTemplateService.addCaseTemplate(caseTemplateEntity);
    	} catch (Exception e) {
    		log.error("新增用例模版出错:{}", e);
    		result.setCode(ResultDto.FAIL);
    		result.setMsg(e.getMessage());
    	}
    	return result;
    }
    /**
     * 查找模板名称
     * @param templateId
     * @return
     */
    @RequestMapping("/findTemplateName")
    @ResponseBody
    public CaseTemplateDto findTemplateName(CaseTemplateDto caseTemplateDto){
    	CaseTemplateEntity caseTemplateEntity = new CaseTemplateEntity();
		caseTemplateEntity.setTemplateId(caseTemplateDto.getTemplateId());
    	String temp = caseTemplateService.findCaseTemplateEntity(caseTemplateEntity).getTemplateName();
    	caseTemplateDto.setTemplateName(temp);
    	return caseTemplateDto;
    }
    
    
    /**
     * 显示用例模板详情
     * @param templateXmlDto
     * @return
     */
    @RequestMapping("/templateContent")
    @ResponseBody
    public TemplateXmlDto showTemplateContent(TemplateXmlDto templateXmlDto){
    	templateXmlDto.setTemplateContent(caseTemplateService.getTemplateXml(templateXmlDto.getTemplateId()));
    	return templateXmlDto;
    }
    
    /**
     * 修改用例模板详情
     * @param templateXmlDto
     * @return
     */
    @RequestMapping("/modifyTemplateContent")
    @ResponseBody
    public ResultDto modifyTemplateContent(TemplateXmlDto templateXmlDto){
    	ResultDto result = ResultDto.defaultResult();
    	TemplateXmlEntity templateXmlEntity = new TemplateXmlEntity();
    	try{
    		templateXmlEntity.setTemplateId(templateXmlDto.getTemplateId());
    		templateXmlEntity.setTemplateContent(prettyPrint(templateXmlDto.getTemplateContent()));
    		templateXmlService.addTemplateXml(templateXmlEntity);
    	
    		
    	} catch (Exception e){
    		log.error("新增用例模版出错:{}", e);
    		result.setCode(ResultDto.FAIL);
    		result.setMsg(e.getMessage());
    	}
    	return result;
    }
    
    /**
	 * 排版XML
	 * 
	 * @param xml
	 * @return
	 */
	public static String prettyPrint(String xml) {
		String xmlFormat="";
		if (StringUtils.isEmpty(xml)) {
			return "";
		}
		try {
			OutputFormat format = OutputFormat.createPrettyPrint();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			format.setEncoding("gb2312");
			XMLWriter writer = new XMLWriter(baos, format);
			writer.write(DocumentHelper.parseText(xml));
			xmlFormat = baos.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xmlFormat;

	}
  
}
