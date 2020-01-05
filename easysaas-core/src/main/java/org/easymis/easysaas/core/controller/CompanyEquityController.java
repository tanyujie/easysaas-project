package org.easymis.easysaas.core.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(description = "股权出质相关接口")
@Validated
@RequestMapping("/companyEquity")
@RestController
public class CompanyEquityController {

}
