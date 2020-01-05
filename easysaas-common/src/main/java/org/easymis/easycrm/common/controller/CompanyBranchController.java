package org.easymis.easycrm.common.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(description = "分支机构相关接口")
@Validated
@RequestMapping("/CompanyBranch")
@RestController
public class CompanyBranchController {

}
