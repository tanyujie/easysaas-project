package org.easymis.easysaas.portal.controller;

import org.easymis.easysaas.portal.config.ElasticSearchConfig;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Api(description = "vip相关")
@Validated
@Controller
public class VipController {
    @RequestMapping("/vipintro.html")
    public String vipintro() {
        return "vip/vipintro";
    }
    @RequestMapping("/vipbusiness.html")
    public String vipbusiness() {
        return "vip/vipbusiness";
    }
    
}
