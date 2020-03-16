package org.easymis.easysaas.imserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Api(value = "/scheduling/school", description = "排班班次")
@Controller
@RequestMapping("/scheduling")
public class SchedulingController {
	@Autowired
	private SchedulingService service;
}
