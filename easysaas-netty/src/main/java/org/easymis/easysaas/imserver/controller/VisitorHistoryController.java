package org.easymis.easysaas.imserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Api(value = "/visitorHistory", description = "访问轨迹")
@Controller
@RequestMapping("/visitorHistory")
public class VisitorHistoryController {

}
