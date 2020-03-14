package org.easymis.easysaas.imserver.controller;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.imserver.service.HrmStaffInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "员工管理")
@RestController
@RequestMapping("hrmStaffInfo")
public class HrmStaffInfoController {
	@Autowired
	HrmStaffInfoService service;
	@ApiOperation(value = "查询所有员工", notes = "JSON ", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = { "/list.json" }, method = { RequestMethod.GET, RequestMethod.POST })
	public RestResult listJson(ModelMap map) throws Exception {
		return RestResult.buildSuccess(service.getListByDepartment("2018012402340575"));
	}
}
