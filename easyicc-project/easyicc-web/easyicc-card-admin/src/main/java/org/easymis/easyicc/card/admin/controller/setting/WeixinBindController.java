package org.easymis.easyicc.card.admin.controller.setting;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.easymis.easyicc.card.admin.controller.IdentityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.BarcodeFormat;

import cn.eutils.web.platform.permission.user.OnLine;
import cn.jesong.webcall.cuour.common.QRCode;
import cn.jesong.webcall.cuour.common.SessionUtil;
import cn.jesong.webcall.cuour.controller.setting.WeixinBindController;
import cn.jesong.webcall.cuour.util.DateUtil;
import cn.jesong.webcall.cuour.util.SendMessage;
import io.swagger.annotations.Api;
import net.kinfe.util.properties.ConfigLoader;

/**
 * 
 * 绑定 微信用户
 *
 */
@Api(value = "/setting/school", description = "绑定 微信用户")
@Controller
@RequestMapping("/weChatBind")
public class WeixinBindController extends IdentityRepository{
	
	private final static Log logger = LogFactory.getLog(WeixinBindController.class);

	private final static String PREFIX = "/setting/allocation";
	
//	@Autowired
//	private WeixinInfoService wxService;

 /*
     * start 获取微信用户基本信息
     */
	@RequestMapping(value = "/binding")
	public String Oauth2MeUrl(HttpServletRequest request, HttpServletResponse response,
			@RequestParam String code,@RequestParam String userId) {
		logger.info("进入微信反调函数 ========================= ");
		System.out.println("进入微信反调函数 ========================= ");
		System.out.println("获取code："+code);
		String key = userId + DateUtil.getCurrentDate1();
		String openId = "";
		String nickName = "";
		String headImgUrl = "";
		try {
			if (StringUtils.isNotEmpty(code)) {
				JSONObject jsonObject =SendMessage.queryUserOpenId(code);
				openId = jsonObject.getString("openid");
				JSONObject userJsonObject=SendMessage.queryUserInfo(openId);
				if (userJsonObject != null){
					nickName=(String) userJsonObject.get("nickname");
					headImgUrl=(String) userJsonObject.get("headimgurl");
					openId=(String) userJsonObject.get("openid");
				}
				SessionUtil.setOpenId(request, openId, key);
				SessionUtil.setNickname(request, nickName, key);
				SessionUtil.setHeadImgUrl(request, headImgUrl, key);
				
			}
		} catch (Exception e) {
			logger.error(e);
		}
		request.setAttribute("notifyOpenId", openId);
		request.setAttribute("notifyUserNickName", nickName);
		request.setAttribute("notifyHeadImgUrl", headImgUrl);
		request.setAttribute("userId", userId);
		logger.info("获取微信用户基本信息为： "+openId+nickName+headImgUrl);
		
		return PREFIX + "/weixin";
	}
	
	@RequestMapping(value = "/createCode", method = RequestMethod.GET)
	@ResponseBody
	public void createCode(HttpServletRequest request, HttpServletResponse response) {
	//	int imageSize = NumberUtils.toInt(request.getParameter("imageSize"), 1);
		int width = NumberUtils.toInt(request.getParameter("width"), 430);
		int height = NumberUtils.toInt(request.getParameter("height"), 430);
		String userId = request.getParameter("userId");
		Properties prop = ConfigLoader.getInstance().load();
		String serverType = prop.getProperty("server.script.domain.type", "");
	//	long token = NumberUtils.toLong(request.getParameter("token"), 0);
		try {
			OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
			String CropId = "wxf5f153db1f8a580e";
			String redirect_uri = "http://api.easyliao.com/"+serverType+ "/cn/jesong/webcall/cuour/weixinBind/binding";
			/*String CropId = "wx39b32f5ff0e35daa";
			String redirect_uri="http://e165518g57.imwork.net/cuour/weixinBind/binding";*/
			redirect_uri += "?userId=" + userId;
			redirect_uri = java.net.URLEncoder.encode(redirect_uri, "utf-8");
			String createUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
					+ CropId
					+ "&redirect_uri="
					+ redirect_uri
					+ "&response_type=code&scope=snsapi_userinfo&state=yuqing#wechat_redirect";
			String filePostfix = "png";
			logger.info("路径为：----------------- "+createUrl);
			BufferedImage image = QRCode.encode(createUrl, filePostfix, BarcodeFormat.QR_CODE, width, height, null);
			if (image != null) {
				ImageIO.write(image, filePostfix, outputStream);
			}

			outputStream.close();

		} catch (Exception e) {
			logger.error(e);
		}
	}
	
	@RequestMapping(value = "/getOpenid", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> getOpenid(HttpServletRequest request,
			HttpServletResponse response) {
		String userId = this.getUserId();
		String key = userId + DateUtil.getCurrentDate1();
		Map<String, String> map = new HashMap<String, String>();
		String openid = SessionUtil.getOpenId(request, key);
		String nickname = SessionUtil.getNickname(request, key);
		String headimgurl = SessionUtil.getHeadImgUrl(request, key);
		map.put("openid", openid);
		map.put("nickname", nickname);
		map.put("headimgurl", headimgurl);
		return map;
	}
	
}
