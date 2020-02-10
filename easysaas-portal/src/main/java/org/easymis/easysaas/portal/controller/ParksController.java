package org.easymis.easysaas.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Api(description = "园区大全")
@Controller
@Validated
public class ParksController {
	@RequestMapping("/parks")
	public String entry() {
		return "parks/index";
	}
}
