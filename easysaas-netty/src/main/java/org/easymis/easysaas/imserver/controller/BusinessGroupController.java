package org.easymis.easysaas.imserver.controller;

import org.easymis.easysaas.imserver.service.BusinessGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Api(value = "/setting/businessGroup", description = "业务组配置")
@Controller
@RequestMapping("/businessGroup")
public class BusinessGroupController extends IdentityRepository{
	@Autowired
	private BusinessGroupService service;
	
}
