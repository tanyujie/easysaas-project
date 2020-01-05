package org.easymis.easycrm.operation.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(description = "行政处罚相关接口")
@Validated
@RequestMapping("/companyPunishment")
@RestController
public class CompanyPunishmentController {

}
