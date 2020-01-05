package org.easymis.easycrm.web.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.easymis.dbview.modules.system.entitys.mybatis.dto.HrmStaffInfo;
import org.easymis.easycrm.web.entitys.mybatis.dto.Member;
import org.easymis.easycrm.web.service.CrmLeadsService;
import org.easymis.easycrm.web.utils.MD5Utils;
import org.easymis.easycrm.web.utils.R;
import org.easymis.easycrm.web.utils.VrifyCodeUtil;
import org.easymis.easycrm.web.utils.web.RestfulMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description = "登录")
@RequestMapping("login")
@Validated
@Controller
public class LoginController {
	@Autowired
	private CrmLeadsService leadsService;
	
	/**
	 * 访问后台登录页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value="跳转登录页面", notes="跳转登录页面")
	//@SysLog("跳转登陸页面")
	@RequestMapping(value = { "login.html", "login" }, method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public ModelAndView toLogin() throws ClassNotFoundException {
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("login");
		return mv;
	}
    @ApiOperation(value = "登录系统 ",notes = "",produces = MediaType.ALL_VALUE)
    @ApiImplicitParams({ @ApiImplicitParam(name = "username",value = "帐号",dataType = "java.lang.String",required = true), @ApiImplicitParam(name = "password",value = "密码",dataType = "java.lang.String",required = true) })
    @ResponseBody
    @RequestMapping(value = "/v2/common/login_do/login.do",method = { RequestMethod.GET, RequestMethod.POST })
    public RestfulMessage loginV2(HttpServletRequest httpServletRequest,ModelMap map) throws Exception{
        // 首先检测验证码
        if (!VrifyCodeUtil.checkvrifyCode(httpServletRequest, map)) {
            return RestfulMessage.failure(2,"验证码不正确");
        }
        String username = getStringParamDefaultBlank(httpServletRequest, "username");
        String password = getStringParamDefaultBlank(httpServletRequest, "password");
        String organizeId =getStringParamDefaultBlank(httpServletRequest, "organizeId");
		Member member = memberService.doLoginCheck(username, password);
        if(member!=null) {
			boolean chpw = MD5Utils.checkMD5(member.getPassword(), password);
			// 登录失败，密码不对
			if (!chpw) {
	            return RestfulMessage.failure(3,"密码不对");
			}
			//保存員工信息
			HrmStaffInfo staff=staffInfoMng.findByMemberAndOrganize(member.getMemberId(), organizeId);
			String tokenId = UUID.randomUUID().toString().replace("-", "").toLowerCase();
            UsernamePasswordToken token = new UsernamePasswordToken(staff.getStaffId(), password, "login");
            // 获取Shiro管理的Session
            Subject currentUser = SecurityUtils.getSubject();
            logger.info("对用户[" + username + "]进行登录验证..验证开始");
			Session session = currentUser.getSession();
			/** Shiro加入身份验证 **/
			currentUser.login( token );
			 //验证是否登录成功
			if (currentUser.isAuthenticated()) {
				// Shiro添加会话
				session.setAttribute("username", username);
				session.setAttribute(org.easymis.commons.Constants.SESSION_USER, member);
				// 删除验证码Session
				session.removeAttribute(org.easymis.commons.Constants.SESSION_SECURITY_CODE);
				// 保存登录IP
				getRemortIP(username);

				session.setAttribute("staffId", staff.getStaffId());
				session.setAttribute("staffName", staff.getName());
				session.setAttribute(org.easymis.commons.Constants.SESSION_STAFF, staff);	
				if (staff != null) {
					session.setAttribute(tokenId + ":memberId", member.getMemberId());
					session.setAttribute(tokenId + ":staffId", staff.getStaffId());
					session.setAttribute(tokenId + ":orgId", staff.getOrgId());
					session.setAttribute(tokenId + ":staffName", staff.getName());
					session.setAttribute(tokenId + ":sessionStaff", staff);
				}

				JSONObject tokenObject = new JSONObject();
				tokenObject.put("token", tokenId);
				RestfulMessage.success("登录成功", tokenObject);
			}else {
		        return RestfulMessage.failure(4,"登录失败");
			}
        }
        return RestfulMessage.failure(5,"用户不存在");
    }
	@ApiOperation(value="系統注銷", notes="")
	//@SysLog("系統注銷")
	@CrossOrigin(origins = "*")//解决跨域问题的标签
	@ResponseBody
	@RequestMapping(value="/logout.json")
	public R logoutJson(){

		return new R().ok();
	}
	/**
	 * 获取登录用户的IP
	 * 
	 * @throws Exception
	 */
	public void getRemortIP(String username) {
		HttpServletRequest request = this.getRequest();
		Map<String, String> map = new HashMap<String, String>();
		String ip = "";
		if (request.getHeader("x-forwarded-for") == null) {
			ip = request.getRemoteAddr();
		} else {
			ip = request.getHeader("x-forwarded-for");
		}
		map.put("username", username);
		map.put("loginIp", ip);
		//memberService.saveIp(map);
	}
}
