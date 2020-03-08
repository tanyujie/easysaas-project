package org.easymis.easysaas.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * web页跳转
 *
 * @author wangkai  2019/7/20
 */
@Controller
@RequestMapping
public class RenderController {

    /**
     * 首页 二维码登录
     */
    @RequestMapping(method = RequestMethod.GET,value = "/")
    public String index(){

        return "index";
    }

    /**
     * 手机扫描后的登录页
     */
    @GetMapping(value = "/mobile/index")
    public String mobileLogin(Model model, @RequestParam String token){

        model.addAttribute("token",token);
        return "/mobile/login";
    }

    /**
     * 确认登录后的欢迎页
     */
    @GetMapping(value = "/welcome")
    public String welcome(Model model,@RequestParam String userName){
        model.addAttribute("userName",userName);
        return "/welcome";
    }
}
