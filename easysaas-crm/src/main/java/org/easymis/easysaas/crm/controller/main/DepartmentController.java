package org.easymis.easysaas.crm.controller.main;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.dto.Department;
import org.easymis.easysaas.crm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(description = "部门管理")
@Controller
@Validated
@Slf4j
public class DepartmentController {

	@Autowired
	DepartmentService service;

	@ApiOperation(value = "部门管理首页", notes = "html", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = { "/department/index.html" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String index(ModelMap map) throws Exception {
		return "department/index";
	}

	@ApiOperation(value = "部门分页列表", notes = "JSON ", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = { "/department/page.json" }, method = { RequestMethod.GET, RequestMethod.POST })
	public RestResult pageJson(@ModelAttribute Page page, ModelMap map) throws Exception {
		return RestResult.buildSuccess(service.getPage(page, new Department()));
	}

	@ApiOperation(value = "部门分页列表", notes = "JSON ", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = { "/department/list.json" }, method = { RequestMethod.GET, RequestMethod.POST })
	public RestResult listJson(ModelMap map) throws Exception {
		return RestResult.buildSuccess(service.getList(new Department()));
	}

	@ApiOperation(value = "添加", notes = "html", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = { "/department/add.html" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String forwardAdd(ModelMap map) throws Exception {
		return "department/add";
	}

	@ApiOperation(value = "添加", notes = "JSON ", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = { "/department/save.do" }, method = { RequestMethod.GET, RequestMethod.POST })
	public RestResult save(ModelMap map, Department bean) {

		return service.save(bean);
	}

	@ApiOperation(value = "删除", notes = "JSON ", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = { "/department/delete.do" }, method = { RequestMethod.GET, RequestMethod.POST })
	public RestResult delete(String departmentId) throws Exception {
		service.delete(departmentId);
		return RestResult.buildSuccess();
	}

	@ApiOperation(value = "编辑", notes = "html", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = { "/department/edit.html" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String forwardEdit(ModelMap map) throws Exception {
		return "department/edit";
	}

	@ApiOperation(value = "修改部门", notes = "JSON ", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = { "/department/update.do" }, method = { RequestMethod.GET, RequestMethod.POST })
	public RestResult update(Department bean, ModelMap map) throws Exception {
		return RestResult.buildSuccess(service.update(bean));
	}

	// 根据id查询部门信息
	@RequestMapping(value = "/department/get", method = RequestMethod.GET)
	@ResponseBody
	public RestResult getRoleById(String departmentId) {
		return RestResult.buildSuccess(service.findById(departmentId));

	}

	@ApiOperation(value = "详情", notes = "html", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = { "/department/view.html" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String view(ModelMap map, String departmentId) throws Exception {
		Department department = service.findById(departmentId);
		return "department/view";
	}

}
