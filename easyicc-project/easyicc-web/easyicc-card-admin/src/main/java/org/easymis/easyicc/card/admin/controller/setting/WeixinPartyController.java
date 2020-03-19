package org.easymis.easyicc.card.admin.controller.setting;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymis.easyicc.card.admin.controller.IdentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.eutils.web.platform.permission.user.OnLine;
import cn.eutils.web.platform.ui.Page;
import cn.eutils.web.platform.ui.PageConfig;
import cn.eutils.web.platform.ui.RespResult;
import cn.jesong.webcall.cuour.common.CmdConstant;
import cn.jesong.webcall.cuour.dao.HibernateDAO;
import cn.jesong.webcall.cuour.entity.Company;
import cn.jesong.webcall.cuour.entity.WeixinInfo;
import cn.jesong.webcall.cuour.service.CompanyService;
import cn.jesong.webcall.cuour.service.WeixinInfoService;
import io.swagger.annotations.Api;

/**
 * 
 * 微信接口配置
 *
 */
@Api(value = "/setting/school", description = "微信接口配置")
@Controller
@RequestMapping("/weChatParty")
public class WeixinPartyController extends IdentityRepository{
	
	private final static String PREFIX = "/setting/weixinParty";
	
	@Autowired
	private CompanyService cService;
	
	@Autowired
	private WeixinInfoService wxService;
	
	@RequestMapping("/indexWeixinParty")
	public String indexThirdParty(ModelMap model) throws Exception {
		return PREFIX + "/index";
	}
	
	/**
	 * 微信接口列表
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/queryPage")
	@ResponseBody
	public Page<WeixinInfo> queryPage(HttpServletRequest request) {
		Page<WeixinInfo> page = new Page<WeixinInfo>();
		try {
			Object params = this.getQueryParams(request);
			if (params == null) {
				params = new HashMap<String, Object>();
			}
			page = this.getHibernateService()
					.pageQueryByTemplate(PageConfig.createPageConfig(request),
							params);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return page;
	}
	
	@RequestMapping(value = "/createWeixinInfo", method = RequestMethod.GET)
	public String createWeixinInfo(ModelMap model) {
		try {
			List<Company> list = cService.getCompanys();
			model.put("companys", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return PREFIX + "/form";
	}

	/**
	 * 新增名片接口
	 * 
	 * @param ci
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/createWeixinInfo", method = RequestMethod.POST)
	@Transactional
	public void createWeixinInfo(WeixinInfo weixin, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		try {
			if (weixin != null) {
				int companyId = OnLine.getCurrentUserDetails().getCompanyId();
			//	String companyName = cService.getCompanyName(companyId);
				weixin.setCompanyId(companyId);
				weixin.setIsDelete(CmdConstant.IS_DELETE_NO);
				weixin.setUserName(OnLine.getCurrentUserDetails().getRealName());
				weixin.setCompanyName(cService.getCompanyName(companyId));
				wxService.insert(weixin);
			//	acService.insert(ac);
			//	this.service.saveCardInterface(cif);
			}
			RespResult.getSuccess().writeToResponse(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 更新页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateWeixin", method = RequestMethod.GET)
	public String updateWeixin(HttpServletRequest request, ModelMap model) {
		int id = Integer.parseInt(request.getParameter("id") == null ? "0"
				: request.getParameter("id"));
		WeixinInfo entity = this.getHibernateService().get(id);
		
		model.put("entity", entity);
		model.put("id", "" + id);
		this.updatePageInit(entity, request, model);
		return this.getPrefix() + "/" + this.getEditPage();
	}

	/**
	 * 更新
	 * 
	 * @param entity
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/updateWeixin", method = RequestMethod.POST)
	public void updateWeixin(WeixinInfo weixin, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		try {
			// int id = Integer.parseInt(request.getParameter("id") == null ?
			// "0" : request.getParameter("id"));
			String id = request.getSession().getAttribute("id") == null ? ""
					: (String) request.getSession().getAttribute("id");
			
			
			String hql = "update WeixinInfo set status=?,sendOpportunity=? where id=?";
			this.getHibernateService().executeUpdate(hql, weixin.getStatus(),
					weixin.getSendOpportunity(), Integer.parseInt(id));
			request.getSession().removeAttribute("id");
			RespResult.getSuccess().writeToResponse(response);
		} catch (Exception e) {
			RespResult.getError(e).writeToResponse(response);
		}
	}
	
	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteWeixin")
	@ResponseBody
	public RespResult deleteWeixin(HttpServletRequest request) {
		try {
			int id = Integer.parseInt(request.getParameter("id") == null ? "0"
					: request.getParameter("id"));
			String hql = "delete from WeixinInfo  where id=?";
			this.getHibernateService().executeUpdate(hql, id);
			return RespResult.getSuccess();
		} catch (Exception e) {
			return RespResult.getError(e);
		}
	}
	
	@Override
	protected String getPrefix() {
		return "/setting/weixinParty";
	}

	@Override
	protected Object getQueryParams(HttpServletRequest request) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("isDelete", CmdConstant.IS_DELETE_NO);
		int companyId = OnLine.getCurrentUserDetails().getCompanyId();
		params.put("companyId", companyId);
		return params;
	}

	@Override
	protected HibernateDAO<Integer, WeixinInfo> getHibernateService() {
		return wxService;
	}
}
