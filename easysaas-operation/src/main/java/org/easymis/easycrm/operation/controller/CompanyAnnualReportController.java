package org.easymis.easycrm.operation.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(description = "企业年报")
@RequestMapping("CompanyAnnualReport")
@RestController
@Validated
public class CompanyAnnualReportController {

}
