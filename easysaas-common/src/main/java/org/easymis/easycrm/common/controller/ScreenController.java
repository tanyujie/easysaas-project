package org.easymis.easycrm.common.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(description = "首页大屏展示")
@RequestMapping("companyScreen")
@RestController
@Validated
public class ScreenController {

}
