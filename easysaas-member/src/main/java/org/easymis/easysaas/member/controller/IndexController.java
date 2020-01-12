package org.easymis.easysaas.member.controller;

import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "测试首页加载API")
@Controller
public class IndexController {
    @Autowired
    //private GeneralTaskService generalTaskService;
	@ApiOperation(value = "WebSocket测试首页", notes = "", produces = MediaType.TEXT_HTML_VALUE)
	@RequestMapping(value = { "/index.html", "/index" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String index() throws Exception {
		System.out.println("WebSocket测试首页!!!");
		//model.addAttribute("userId", "test001");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //异步发送邮件
       // generalTaskService.sendEmailAsyncExecutor(outputStream.toByteArray(), "tanyujie@sharepanzer.com");
		return "/index";
	}
}
