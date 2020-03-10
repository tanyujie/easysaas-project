package org.easymis.easysaas.crm.controller.main;

import java.util.List;

import org.easymis.easysaas.common.parameter.BasePageRequest;
import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.dto.Organize;
import org.easymis.easysaas.crm.service.OrganizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(description = "组织管理")
@Controller
@Validated
@Slf4j
public class OrganizeController {
	@Autowired
	OrganizeService service;
	//设置系统配置
	//setSysConfig
    public RestResult queryPageList(BasePageRequest basePageRequest){
        JSONObject jsonObject = basePageRequest.getJsonObject().fluentPut("type",1);
        basePageRequest.setJsonObject(jsonObject);
    	return null;//crmSceneService.filterConditionAndGetPageList(basePageRequest);
    }
    //queryModuleSetting 已启用应用
    @ApiOperation(value = "组织管理首页", notes = "html", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = { "/organize/index.html" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String index(ModelMap map) throws Exception {

		return "organize/index";
	}

	@ApiOperation(value = "组织分页列表", notes = "JSON ", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = { "/organize/page.json" }, method = { RequestMethod.GET, RequestMethod.POST })
	public RestResult pageJson(@ModelAttribute Page page, ModelMap map) throws Exception {
		return RestResult.buildSuccess(service.getPage(page, new Organize()));
	}

	@ApiOperation(value = "组织分页列表", notes = "JSON ", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = { "/organize/list.json" }, method = { RequestMethod.GET, RequestMethod.POST })
	public RestResult listJson(ModelMap map) throws Exception {
		List roleList = service.getList(new Organize());
		return new RestResult().buildSuccess("roleList", roleList);
	}

	@ApiOperation(value = "添加", notes = "html", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = { "/organize/add.html" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String forwardAdd(ModelMap map) throws Exception {
		return "organize/role/add";
	}

	@ApiOperation(value = "添加", notes = "JSON ", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = { "/organize/save.do" }, method = { RequestMethod.GET, RequestMethod.POST })
	public RestResult save(Organize bean) throws Exception {

		return service.save(bean);
	}

	@ApiOperation(value = "删除", notes = "JSON ", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = { "/organize/delete.do" }, method = { RequestMethod.GET, RequestMethod.POST })
	public RestResult delete(String roleId) throws Exception {
		service.delete(roleId);
		return RestResult.buildSuccess();
	}

	@ApiOperation(value = "编辑", notes = "html", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = { "organize/edit.html" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String forwardEdit(ModelMap map) throws Exception {
		return "organize/role/edit";
	}

	@ApiOperation(value = "修改组织", notes = "JSON ", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = { "/organize/update.do" }, method = { RequestMethod.GET, RequestMethod.POST })
	public RestResult update(Organize bean, ModelMap map) throws Exception {
		return RestResult.buildSuccess(service.update(bean));
	}

	// 根据id查询组织信息
	@RequestMapping(value = "/organize/get", method = RequestMethod.GET)
	@ResponseBody
	public RestResult getRoleById(String roleId) {
		return RestResult.buildSuccess(service.findById(roleId));
	}

	@ApiOperation(value = "详情", notes = "html", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = { "/organize/view.html" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String view() throws Exception {
		return "organize/role/view";
	}
}
