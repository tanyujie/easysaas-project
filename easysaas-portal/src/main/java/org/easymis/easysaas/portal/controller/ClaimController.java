package org.easymis.easysaas.portal.controller;

import org.easymis.easysaas.portal.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Api(description = "企业实名认证")
@Controller
@Validated
public class ClaimController {
	@Autowired
	private CompanyService service;

	@RequestMapping("/claim/entry")
	public String entry() {
		return "claim/entry";
	}
}
