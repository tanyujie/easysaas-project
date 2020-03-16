package org.easymis.easysaas.imserver.controller;

import org.easymis.easysaas.imserver.service.CardApiPushLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Api(value = "/apiPushLog", description = "名片推送日记")
@Controller
@RequestMapping("/apiPushLog")
public class ApiPushLogController {
	@Autowired
	private CardApiPushLogService service;
}
