package org.easymis.easycrm.common.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(description = "动产抵押相关接口")
@Validated
@RequestMapping("/companyMortgage")
@RestController
public class CompanyMortgageController {

}
