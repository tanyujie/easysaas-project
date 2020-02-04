package org.easymis.easysaas.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Api(description = "地图查询企业查询入口")
@Controller
@Validated
@Slf4j
public class MapController {
    @RequestMapping("/map")
    public String vipintro() {
        return "map";
    }
}
