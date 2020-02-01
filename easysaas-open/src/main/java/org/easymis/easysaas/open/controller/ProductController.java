package org.easymis.easysaas.open.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(description = "产品信息")
@RequestMapping("product")
@RestController
@Validated
public class ProductController {

}
