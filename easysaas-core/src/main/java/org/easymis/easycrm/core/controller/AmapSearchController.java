package org.easymis.easycrm.core.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Api(description = "高德查询接口")
@Validated
@RequestMapping("/amapSearch")
@RestController
@Slf4j
public class AmapSearchController {

}
