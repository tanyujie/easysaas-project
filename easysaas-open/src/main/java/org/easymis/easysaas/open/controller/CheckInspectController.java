package org.easymis.easysaas.open.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(description = "抽查检查")
@RequestMapping("checkInspect")
@RestController
@Validated
public class CheckInspectController {

}
