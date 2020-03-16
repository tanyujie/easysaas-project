package org.easymis.easysaas.imserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Api(value = "/setting/thirdParty", description = "第三方接口配置")
@Controller
@RequestMapping("/thirdParty")
public class ThirdPartyController {

}
