package org.easymis.easysaas.imserver.controller;

import org.easymis.easysaas.imserver.service.BackTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Api(value = "/setting/businessGroup", description = "退回类型设置")
@Controller
@RequestMapping("/backType")
public class BackTypeController {
	@Autowired
	private BackTypeService service;
}
