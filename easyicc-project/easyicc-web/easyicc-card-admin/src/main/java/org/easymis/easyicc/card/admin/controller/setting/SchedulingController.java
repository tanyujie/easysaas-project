package org.easymis.easyicc.card.admin.controller.setting;

import org.easymis.easyicc.common.result.RestResult;
import org.easymis.easyicc.domain.entity.Scheduling;
import org.easymis.easyicc.domain.entity.School;
import org.easymis.easyicc.service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "/scheduling/school", description = "排班班次")
@Controller
@RequestMapping("/scheduling")
public class SchedulingController {
	@Autowired
	private SchedulingService service;
	@ApiOperation(value = "查询接口", response = School.class)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "pageNum", value = "页码", dataType = "int", required = false),
		@ApiImplicitParam(name = "pageSize", value = "每页显示记录", dataType = "int", required = false),
	})
	@RequestMapping(value = { "/findByOrgId.json" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public RestResult findByOrgId(Integer pageNum, Integer pageSize) {
		String orgId="";
		return RestResult.buildSuccess(service.findByOrgId(orgId, pageNum, pageSize));
	}
	
	@ApiOperation(value = "保存项目配置")
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
	public RestResult add(Scheduling bean) {
		if (service.save(bean))
			return RestResult.buildSuccess();
		else
			return RestResult.buildFail();
	}
	
	@ApiOperation(value = "修改项目配置信息")
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
	public RestResult update(Scheduling bean) {
		if (service.update(bean))
			return RestResult.buildSuccess();
		else
			return RestResult.buildFail();
	}
	
	@ApiOperation(value = "查看项目配置信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "ids", value = "项目配置id", dataType = "string", required = false),
	})
	@RequestMapping(value = { "/read.json" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public RestResult read(String schoolId) {
		return RestResult.buildSuccess(service.findById(schoolId));
	}
	
	@ApiOperation(value = "删除项目配置信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "ids", value = "项目配置id列表", dataType = "string", required = false),
	})
	@RequestMapping(value = { "/delete.do" }, method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public RestResult delete(String ids) {
		return service.deleteByIds(ids);
	}	
}
