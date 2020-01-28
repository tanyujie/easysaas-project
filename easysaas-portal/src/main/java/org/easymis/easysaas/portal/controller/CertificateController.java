package org.easymis.easysaas.portal.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(description = "资质证书")
@RequestMapping("certificate")
@RestController
@Validated
public class CertificateController {

}
