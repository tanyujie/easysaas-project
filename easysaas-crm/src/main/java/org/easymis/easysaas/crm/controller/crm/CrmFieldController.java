package org.easymis.easysaas.crm.controller.crm;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.controller.IdentityRepository;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmField;
import org.easymis.easysaas.crm.service.CrmFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
/**
 * 
　 * <p>Title: 字段信息 </p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年2月21日
 */
@Api(description = "客户预约")
@Controller
@RequestMapping("/crmField")
@Validated
@Slf4j
public class CrmFieldController extends IdentityRepository{
	@Autowired
	private CrmFieldService service;

	@ApiOperation(value = "查询接口", response = CrmField.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "pageNum", value = "页码", dataType = "int", required = false),
		@ApiImplicitParam(name = "pageSize", value = "每页显示记录", dataType = "int", required = false),
	})
	public RestResult findByOrgId(@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		String orgId = getOrgId();
		return RestResult.buildSuccess(service.findByOrgId(orgId, pageNum, pageSize));
	}
	
	@ApiOperation(value = "保存校区")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "name", value = "学校名称", dataType = "string", required = false),
		@ApiImplicitParam(name = "schoolType", value = "类型1直营2合作3加盟4代理", dataType = "int", required = false),
		@ApiImplicitParam(name = "provinceId", value = "省", dataType = "string", required = false),
		@ApiImplicitParam(name = "cityId", value = "市", dataType = "string", required = false),
		@ApiImplicitParam(name = "districtId", value = "区", dataType = "string", required = false),
		@ApiImplicitParam(name = "addressDetail", value = "详细地址", dataType = "string", required = false),
		@ApiImplicitParam(name = "contact", value = "联系电话", dataType = "string", required = false),
		@ApiImplicitParam(name = "contactBackup", value = "备用电话", dataType = "string", required = false),
	})
	@RequestMapping(value = { "/save.do" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public RestResult add(CrmField bean) {
		if (service.save(bean))
			return RestResult.buildSuccess();
		else
			return RestResult.buildFail();
	}
	
	@ApiOperation(value = "修改校区信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "schoolId", value = "学校Id", dataType = "string", required = false),
		@ApiImplicitParam(name = "name", value = "学校名称", dataType = "string", required = false),
		@ApiImplicitParam(name = "schoolType", value = "类型1直营2合作3加盟4代理", dataType = "int", required = false),
		@ApiImplicitParam(name = "provinceId", value = "省", dataType = "string", required = false),
		@ApiImplicitParam(name = "cityId", value = "市", dataType = "string", required = false),
		@ApiImplicitParam(name = "districtId", value = "区", dataType = "string", required = false),
		@ApiImplicitParam(name = "addressDetail", value = "详细地址", dataType = "string", required = false),
		@ApiImplicitParam(name = "contact", value = "联系电话", dataType = "string", required = false),
		@ApiImplicitParam(name = "contactBackup", value = "备用电话", dataType = "string", required = false),
	})
	@RequestMapping(value = { "/update.do" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public RestResult update(CrmField bean) {
		if (service.update(bean))
			return RestResult.buildSuccess();
		else
			return RestResult.buildFail();
	}
	
	@ApiOperation(value = "查看校区信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "ids", value = "校区id", dataType = "string", required = false),
	})
	@RequestMapping(value = { "/read.json" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public RestResult read(String schoolId) {
		return RestResult.buildSuccess(service.findById(schoolId));
	}
	
	@ApiOperation(value = "删除校区信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "ids", value = "校区id列表", dataType = "string", required = false),
	})
	@RequestMapping(value = { "/delete.do" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public RestResult delete(String ids) {
		return service.deleteByIds(ids);
	}
}
