package org.easymis.easysaas.crm.controller.main;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.easymis.commons.utils.Page;
import org.easymis.commons.utils.R;
import org.easymis.dbview.modules.system.entitys.mybatis.dto.OrganizeRole;
import org.easymis.dbview.modules.system.entitys.mybatis.vo.OrganizeRoleVo;
import org.easymis.dbview.modules.system.exception.ServiceException;
import org.easymis.dbview.modules.system.service.OrganizeRoleService;
import org.easymis.dbview.utils.web.RestfulMessage;
import org.easymis.easysaas.common.parameter.BasePageRequest;
import org.easymis.easysaas.common.result.RestResult;
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
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(description = "组织用户角色管理")
@Controller
@Validated
@Slf4j
public class RoleController {

	@Autowired
	RoleService service;

	@ApiOperation(value = "角色管理首页", notes = "html", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = { "/organize/role/index.html" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String index(@ModelAttribute Page page, ModelMap map) throws Exception {
		PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
		List roleList = service.getList(new OrganizeRoleVo());
		PageInfo<OrganizeRole> p = new PageInfo<OrganizeRole>(roleList);
		map.put("roleList", roleList);
		return getTplPath(map, "system/organize/role/index");
	}

	@ApiOperation(value = "角色分页列表", notes = "html", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = { "/organize/role/getAllRoleList" }, method = { RequestMethod.GET, RequestMethod.POST })
	public RestResult getAllRoleList(@ModelAttribute Page page, ModelMap map) throws Exception {
		return new R().ok();
	}
	@ApiOperation(value = "角色分页列表", notes = "JSON ", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = { "/organize/role/page.json" }, method = { RequestMethod.GET, RequestMethod.POST })
	public RestResult pageJson(@ModelAttribute Page page, ModelMap map) throws Exception {
		PageHelper.startPage(page.getCurrentPage(), page.getPageSize());
		List roleList = service.getList(new OrganizeRoleVo());
		PageInfo<OrganizeRole> p = new PageInfo<OrganizeRole>(roleList);
		return new R().put("pageInfo", p);
	}
	@ApiOperation(value = "角色分页列表", notes = "JSON ", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = { "/organize/role/list.json" }, method = { RequestMethod.GET, RequestMethod.POST })
	public R listJson(ModelMap map) throws Exception {
		List roleList = service.getList(new OrganizeRoleVo());
		return new R().put("roleList", roleList);
	}

	@ApiOperation(value = "添加", notes = "html", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = { "/organize/role/add.html" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String forwardAdd(ModelMap map) throws Exception {
		return getTplPath(map, "organize/role/add");
	}

	@ApiOperation(value = "添加", notes = "JSON ", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = { "/organize/role/save.do" }, method = { RequestMethod.GET, RequestMethod.POST })
	public RestResult save(@ModelAttribute Page page, ModelMap map, OrganizeRole bean) throws Exception {
		if (service.findByName(bean.getRoleName()) == null) {
			//bean.setStatus(true);
			//bean.setCreateTime(new Date());
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession();
			service.save(bean);
			return new R().ok();
		}
		return new R().error("角色已存在");
	}

	@ApiOperation(value = "删除", notes = "JSON ", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = { "/organize/role/delete.do" }, method = { RequestMethod.GET, RequestMethod.POST })
	public RestResult delete(@ModelAttribute Page page, ModelMap map, String roleId) throws Exception {		
		if(service.findById(roleId).getIsSuper()!=1) {
			service.delete(roleId);
			return new R().ok();
		}else {
			return new R().error();
		}
	}

	@ApiOperation(value = "编辑", notes = "html", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = { "/organize/role/edit.html" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String forwardEdit(@ModelAttribute Page page, ModelMap map) throws Exception {
		return getTplPath(map, "organize/role/edit");
	}

	@ApiOperation(value = "修改角色", notes = "JSON ", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = { "/organize/role/update.do" }, method = { RequestMethod.GET, RequestMethod.POST })
	public RestResult update(OrganizeRoleVo bean, ModelMap map) throws Exception {
		String rank = "user";
		OrganizeRoleVo vo = new OrganizeRoleVo();
		vo.setRoleName(bean.getRoleName());		
		if (service.getList(vo).size()<2) {
			OrganizeRoleVo role = service.findById(bean.getRoleId());
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession();
			role.setRoleName(bean.getRoleName());
			role.setDepict(bean.getDepict());
			service.update(role);
			return R.ok();
		}
		return new R().error("角色已存在");
	}

	@ApiOperation(value = "详情", notes = "JSON ", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = { "/organize/role/view.json" }, method = { RequestMethod.GET, RequestMethod.POST })
	public RestResult viewJson(@ModelAttribute Page page, ModelMap map, String roleId) throws Exception {
		OrganizeRole role = service.findById(roleId);
		return new R().put("role", role);
	}
    // 根据id查询角色信息
    @RequestMapping(value = "/organize/role/getRoleById", method = RequestMethod.GET)
    @ResponseBody
    public RestResult getRoleById(HttpSession httpSession, String roleId) {
        try {
            return RestfulMessage.success(service.findById(roleId));
        }catch (Exception e){
        	throw new ServiceException("failure", "OrganizeRoleController/getOrganizeById", "获取失败");
        }
    }
	@ApiOperation(value = "详情", notes = "html", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = { "/organize/role/view.html" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String view(@ModelAttribute Page page, ModelMap map, String roleId) throws Exception {
		OrganizeRole role = service.findById(roleId);
		return getTplPath(map, "organize/role/view");
	}



}
