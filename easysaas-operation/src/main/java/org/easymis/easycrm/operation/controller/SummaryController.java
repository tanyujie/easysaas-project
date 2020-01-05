package org.easymis.easycrm.operation.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Api(description = "查询入口接口")
@Validated
@RequestMapping("/summary")
@RestController
@Slf4j
public class SummaryController {

}
