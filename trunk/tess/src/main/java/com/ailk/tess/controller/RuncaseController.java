package com.ailk.tess.controller;

import com.ailk.tess.entity.CaseTemplateEntity;
import com.ailk.tess.service.CaseTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * User: Administrator
 * Date: 13-2-20
 * Time: 下午11:41
 */
@Controller
@RequestMapping("/runcase")
public class RuncaseController {

    @Autowired
    private CaseTemplateService caseTemplateService;

    /**
     * 执行用例
     * @param caseTemplateId
     */
    @RequestMapping("/run/{caseTemplateId}")
    public void runCase(@PathVariable int caseTemplateId) {

    }
}
