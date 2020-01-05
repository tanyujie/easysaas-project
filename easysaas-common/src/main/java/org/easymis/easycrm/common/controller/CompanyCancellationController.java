package org.easymis.easycrm.common.controller;

import javax.validation.constraints.NotNull;

import org.easymis.easycrm.common.entitys.mybatis.dto.CompanyOther;
import org.easymis.easycrm.common.service.CompanyOtherService;
import org.easymis.easycrm.common.utils.web.RestfulMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(description = "企业注销与吊销信息")
@RequestMapping("companyCancellation")
@RestController
@Validated
public class CompanyCancellationController {
    @Autowired
    private CompanyOtherService otherInfoService;

    @ApiModelProperty("注销与吊销信息")
    @GetMapping("queryCancellationInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "企业id", required = true, dataType = "int")
    })
    @ApiResponses({
            @ApiResponse(code = 0, message = "成功", response = CompanyOther.class)
    })
    public RestfulMessage getCancellationInfo(@NotNull String companyId) {
    	CompanyOther otherInfo = otherInfoService.getById(companyId);
        
    	return RestfulMessage.success(otherInfo);
    }
}
