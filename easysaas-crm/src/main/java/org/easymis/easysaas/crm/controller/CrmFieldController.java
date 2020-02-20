package org.easymis.easysaas.crm.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(description = "债券信息")
@RequestMapping("bond")
@RestController
@Validated
public class CrmFieldController {

}
