package org.easymis.easysaas.portal.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(description = "税务评级")
@RequestMapping("taxRate")
@RestController
@Validated
public class TaxRateController {

}
