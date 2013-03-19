package com.ailk.tess.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: Linzp
 * Date: 13-2-13
 */
@Controller
public class GeneralController {
    @RequestMapping(value = "index.do")
    public void index_jsp(Model model) {
        model.addAttribute("name", "linzp");
        System.out.println("index_jsp run 0002");
    }
}
