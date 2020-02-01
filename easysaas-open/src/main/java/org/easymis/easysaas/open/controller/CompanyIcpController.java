package org.easymis.easysaas.open.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(description = "网站备案")
@Validated
@RequestMapping("/companyIcp")
@RestController
public class CompanyIcpController {

}
