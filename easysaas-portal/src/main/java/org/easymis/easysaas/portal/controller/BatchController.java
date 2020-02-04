package org.easymis.easysaas.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Api(description = "批量查询入口接口")
@Controller
@Validated
@Slf4j
public class BatchController {
    @RequestMapping("/batch")
    public String batch() {
        return "batch";
    }
}
