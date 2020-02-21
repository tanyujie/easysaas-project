package org.easymis.easysaas.crm.controller;

import org.easymis.easysaas.common.parameter.BasePageRequest;
import org.easymis.easysaas.crm.service.CrmCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * <p>
 * Title: 客户信息
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author 谭宇杰 @date 2020年2月21日
 */
@Api(description = "客户预约")
@Controller
@Validated
@Slf4j
public class CrmCustomerController {
	@Autowired
	CrmCustomerService crmCustomerService;

	@ApiOperation(value = "查看列表页")
	public void queryPageList(BasePageRequest basePageRequest) {
		JSONObject jsonObject = basePageRequest.getJsonObject().fluentPut("type", 2);
		basePageRequest.setJsonObject(jsonObject);
		// renderJson(adminSceneService.filterConditionAndGetPageList(basePageRequest));
	}

	@ApiOperation(value = "根据客户id获取客户详细信息")
	// @NotNullValidate(value = "customerId", message = "客户id不能为空")
	@RequestMapping(value = { "/read" }, method = { RequestMethod.GET, RequestMethod.POST })
	public void queryById(String customerId) {
		/*
		 * boolean auth = AuthUtil.isPoolAuth(customerId); if (auth) {
		 * renderJson(R.ok().put("data",new Record().set("dataAuth",0))); return; }
		 * renderJson(R.ok().put("data", crmCustomerService.queryById(customerId)));
		 */
	}

	@ApiOperation(value = "根据客户id删除客户信息")
	@RequestMapping(value = { "/delete" }, method = { RequestMethod.GET, RequestMethod.POST })
	// @NotNullValidate(value = "customerIds", message = "客户id不能为空")
	public void deleteByIds(String customerIds) {
		// renderJson(crmCustomerService.deleteByIds(customerIds));
	}

	@ApiOperation(value = "设置成交状态")
	public void setDealStatus(String ids, Integer dealStatus) {
		// renderJson(crmCustomerService.setDealStatus(ids,dealStatus));
	}
	// 客户转移
	public void transfer() {
		
	}
	//查询团队成员
	//添加团队成员
	//编辑团队成员
	//删除团队成员
	//客户保护规则设置
	//获取客户保护规则设置
	//添加跟进记录
	//查看跟进记录
	//客户批量导出
	//全部导出
	//客户放入公海
}
