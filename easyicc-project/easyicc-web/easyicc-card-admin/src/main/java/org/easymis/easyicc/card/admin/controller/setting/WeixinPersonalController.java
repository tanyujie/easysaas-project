package org.easymis.easyicc.card.admin.controller.setting;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.easymis.easyicc.card.admin.controller.IdentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.eutils.web.platform.permission.user.OnLine;
import cn.jesong.webcall.core.client.CoreClient;
import cn.jesong.webcall.cuour.cache.CacheFactory;
import cn.jesong.webcall.cuour.cache.entity.SaleUser;
import cn.jesong.webcall.cuour.controller.setting.WeixinPersonalController;
import cn.jesong.webcall.resource.User;
import io.swagger.annotations.Api;
import net.kinfe.util.StringUtils;

/**
 * 
全局微信推送
 *
 */
@Api(value = "/setting/school", description = "全局微信推送")
@Controller
@RequestMapping("/weChatPersonal")
public class WeixinPersonalController extends IdentityRepository{
	
	private final static Log logger = LogFactory.getLog(WeixinPersonalController.class);
	
	private final static String PREFIX = "/setting/weixinPersonal";
	
	@Autowired
	private CacheFactory cacheFactory;
	
	@RequestMapping("/index")
	public String indexThirdParty(ModelMap model) throws Exception {
		try {
			int companyId = OnLine.getCurrentUserDetails().getCompanyId();
			String userId = OnLine.getCurrentUserDetails().getUserId();
			if(companyId > 0) {
				try {
					User user = CoreClient.getUserMgr(companyId).getUser(userId);
					if(user != null) {
						String notifyOpenId = user.getExtendConfigProperty("notifyOpenId");
						String notifyUserNickName = user.getExtendConfigProperty("notifyUserNickName");
						String notifyIsOpen = user.getExtendConfigProperty("notifyIsOpen");
						String notifyHeadImgUrl = user.getExtendConfigProperty("notifyHeadImgUrl");
						
						if(notifyOpenId != null && !"".equals(notifyOpenId)) {
							model.put("notifyOpenId", notifyOpenId);
						}
						
						if(notifyUserNickName != null && !"".equals(notifyUserNickName)) {
							model.put("notifyUserNickName", notifyUserNickName);
						}
						
						if(notifyIsOpen != null && !"".equals(notifyIsOpen)) {
							model.put("notifyIsOpen", notifyIsOpen);
						}
						
						if(notifyHeadImgUrl != null && !"".equals(notifyHeadImgUrl)) {
							model.put("notifyHeadImgUrl", notifyHeadImgUrl);
						}

					}
				} catch(Exception e) {
					logger.error(e.getMessage(),e);
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return PREFIX + "/index";
	}

	/**
	 * 微信页面的提交保存新增
	 * 
	 * @param ci
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/submitConfig", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitConfig(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		logger.info("保存微信用户基本信息 ========================= ");
		try {
			/*int companyId = OnLine.getCurrentUserDetails().getCompanyId();
			String userId = OnLine.getCurrentUserDetails().getUserId();*/
			//int companyId =	NumberUtils.toInt(request.getParameter("companyId")); 
			String userId = request.getParameter("userId");
			String password=request.getParameter("password");
			String notifyOpenId = request.getParameter("notifyOpenId");
			String notifyUserNickName = request.getParameter("notifyUserNickName");
			String notifyIsOpen = request.getParameter("notifyIsOpen");
			String notifyHeadImgUrl = request.getParameter("notifyHeadImgUrl");
			logger.info("用户信息的保存:"+ userId+" ,"+password+ " ,"+notifyOpenId+", "+notifyUserNickName);
			User user = CoreClient.getUserMgr(null).getUser(userId);
			if(user !=null){
				//对比用户名和密码
				String userPassword=user.getPassword();
				//String passwordMD=DigestUtils.md5Hex(password);
				String passwordMD=StringUtils.md5(password);
				int	companyId=user.getCompanyId();
				logger.info("密码是否相同："+ userPassword+" ,  "+passwordMD);
				if(userPassword.equals(passwordMD)){
					user.setExtendConfigProperty("notifyIsOpen", notifyIsOpen);
					user.setExtendConfigProperty("notifyOpenId", notifyOpenId);
					user.setExtendConfigProperty("notifyUserNickName", notifyUserNickName);
					user.setExtendConfigProperty("notifyHeadImgUrl", notifyHeadImgUrl);
					CoreClient.getUserMgr(companyId).updateCustomer(user);
					// 更新缓存中的数据
					SaleUser saleUser = cacheFactory.getSubjectUserCache().getUser(companyId, userId);
					if(saleUser != null) {
						saleUser.setWeixinPushStatus("true".equals(notifyIsOpen));
						saleUser.setUserWeiXinOpenId(notifyOpenId);
						
					}
					map.put("result", "success");
				}else {
					map.put("result", "1");
				}
			}else {
				map.put("result", "1");
			}
			
		//	RespResult.getSuccess().writeToResponse(response);
		} catch (Exception e) {
			map.put("result", "error");
			logger.error(e.getMessage(),e);
		}
		logger.info("获取map的值：" + map.get("result"));
		return map;
	}
	
	/**
	 * 页面按钮更新操作
	 * 
	 * @param ci
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/submitConfigupdate", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitConfigupdate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		logger.info("保存微信用户基本信息 ========================= ");
		try {
			String userId = request.getParameter("userId");
			String notifyOpenId = request.getParameter("notifyOpenId");
			String notifyUserNickName = request.getParameter("notifyUserNickName");
			String notifyIsOpen = request.getParameter("notifyIsOpen");
			String notifyHeadImgUrl = request.getParameter("notifyHeadImgUrl");
			
			User user = CoreClient.getUserMgr(null).getUser(userId);
			int	companyId=user.getCompanyId();
			user.setExtendConfigProperty("notifyIsOpen", notifyIsOpen);
			user.setExtendConfigProperty("notifyOpenId", notifyOpenId);
			user.setExtendConfigProperty("notifyUserNickName", notifyUserNickName);
			user.setExtendConfigProperty("notifyHeadImgUrl", notifyHeadImgUrl);
			CoreClient.getUserMgr(companyId).updateCustomer(user);
			// 更新缓存中的数据
			SaleUser saleUser = cacheFactory.getSubjectUserCache().getUser(companyId, userId);
			if(saleUser != null) {
				saleUser.setWeixinPushStatus("true".equals(notifyIsOpen));
				saleUser.setUserWeiXinOpenId(notifyOpenId);
				
			}
			map.put("result", "success");
		//	RespResult.getSuccess().writeToResponse(response);
		} catch (Exception e) {
			map.put("result", "error");
			logger.error(e.getMessage(),e);
		}
		
		return map;
	}
}
