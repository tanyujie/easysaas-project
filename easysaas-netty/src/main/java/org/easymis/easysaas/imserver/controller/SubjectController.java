package org.easymis.easysaas.imserver.controller;

import org.easymis.easysaas.imserver.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Api(value = "/setting/subject", description = "校区配置")
@Controller
@RequestMapping("/subject")
public class SubjectController extends IdentityRepository{
	@Autowired
	private SubjectService subjectService;
	
}
