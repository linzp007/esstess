package com.ailk.tess.controller;

import com.ailk.tess.dto.CaseTemplateDto;
import com.ailk.tess.entity.CaseTemplateEntity;
import com.ailk.tess.service.CaseTemplateService;
import com.trg.search.SearchResult;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("/list/{currPage}")
    @ResponseBody
    public SearchResult<CaseTemplateDto> getAllCaseTemplatePaged(@PathVariable("currPage") int currPage) {
        SearchResult<CaseTemplateEntity> searchResult = caseTemplateService.findAllCaseTemplatePaged(currPage);
        List<CaseTemplateDto> ctemplateDtos = new ArrayList<CaseTemplateDto>();
        for(int i = 0; i < searchResult.getResult().size(); i++) {
           CaseTemplateDto dto = new CaseTemplateDto();
           BeanUtils.copyProperties(searchResult.getResult().get(i),dto);
           ctemplateDtos.add(dto);
        }
        SearchResult<CaseTemplateDto> searchResultDto = new SearchResult<CaseTemplateDto>();
        searchResultDto.setTotalCount(searchResult.getTotalCount());
        searchResultDto.setResult(ctemplateDtos);
        return searchResultDto;
    }
}
