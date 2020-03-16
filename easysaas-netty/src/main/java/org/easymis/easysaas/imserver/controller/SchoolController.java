package org.easymis.easysaas.imserver.controller;

import org.easymis.easysaas.imserver.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Api(value = "/setting/school", description = "项目配置")
@Controller
@RequestMapping("/school")
public class SchoolController extends IdentityRepository{
	@Autowired
	private SchoolService schoolService;
	
}
