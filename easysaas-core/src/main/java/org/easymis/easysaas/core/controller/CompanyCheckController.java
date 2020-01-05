package org.easymis.easysaas.core.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(description = "企业抽查检查")
@RequestMapping("companyCheck")
@RestController
@Validated
public class CompanyCheckController {

}
