package org.easymis.easysaas.crm.controller.main;

import org.easymis.easysaas.common.parameter.BasePageRequest;
import org.easymis.easysaas.common.result.RestResult;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;

import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Api(description = "组织管理")
@Controller
@Validated
@Slf4j
public class OrganizeController {
	//设置系统配置
	//setSysConfig
    public RestResult queryPageList(BasePageRequest basePageRequest){
        JSONObject jsonObject = basePageRequest.getJsonObject().fluentPut("type",1);
        basePageRequest.setJsonObject(jsonObject);
    	return crmSceneService.filterConditionAndGetPageList(basePageRequest);
    }
    //queryModuleSetting 已启用应用

}
