package org.easymis.easysaas.portal.controller;

import org.easymis.easysaas.portal.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
　 * <p>Title: 企业名称检测</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年2月8日
 */
@Controller
public class CheckController {
	
	
    @Autowired
    private CompanyService service;

    
    @RequestMapping("/check")
    public String check() {
        return "check/index";
    }

}