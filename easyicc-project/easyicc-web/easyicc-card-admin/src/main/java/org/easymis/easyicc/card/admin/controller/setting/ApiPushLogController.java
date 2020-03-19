package org.easymis.easyicc.card.admin.controller.setting;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.easymis.easyicc.card.admin.controller.IdentityRepository;
import org.easymis.easyicc.domain.entity.ApiPushLog;
import org.easymis.easyicc.service.CardApiPushLogService;
import org.easymis.easyicc.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@Api(value = "/apiPushLog", description = "名片推送日记")
@Controller
@RequestMapping("/apiPushLog")
public class ApiPushLogController extends IdentityRepository {	
	
	private final static String PREFIX = "/setting/apiPushLog";
	
	private final static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Autowired
	private NotifyService notifyService;
	@Autowired
	private CardApiPushLogService apiPushLogService;

	
	@RequestMapping("/index")
	public String index(ModelMap model) throws Exception{		
		
		String companyId = getCompanyId();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("companyId", companyId);
		
		return PREFIX + "/index";
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public PageInfo<ApiPushLog> query(HttpServletRequest request) throws Exception{
		String companyId = getCompanyId(); 
		String useId=this.getUserId();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("companyId", companyId);
		params.put("useId", useId);
		String startTime = request.getParameter("startTime");
		if(startTime != null){
			params.put("startTime", formatter.parse(startTime));//+" 00:00:00"
		}
		String endTime = request.getParameter("endTime");
		if(endTime != null){
			params.put("endTime", formatter.parse(endTime));//+" 23:59:59"
		}
		String status = request.getParameter("status");
		if(status != null && status.trim().length() > 0){
			params.put("status", status);
		}
		String phoneNumber = request.getParameter("phoneNumber");
		if(phoneNumber != null && phoneNumber.trim().length() > 0){
			params.put("phoneNumber", phoneNumber);
		}
		this.notifyService.clearNotifyTime(companyId, getUserId());
		PageInfo<ApiPushLog> pageInfo = this.apiPushLogService.pageApiPushVisitorInfo(new Page(), params);

		return pageInfo;
	}
	
	/*
	 * 调用同步的几口进行同步
	 * 
	*/
	
	@RequestMapping("/actionInvoke")
	@ResponseBody
	public void actionInvoke(HttpServletRequest request) throws Exception{}
	
	
	// 名片推送日记的导出
	@RequestMapping(value = "download")
	public void downloadCrm( HttpSession session,HttpServletRequest request, HttpServletResponse response) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Map> listMap=new ArrayList<Map>();
		List<String> keys = new ArrayList<String>();
		List<String> heads = new ArrayList<String>();
		List<String> keysFirst = new ArrayList<String>();
		List<String> headsFirst = new ArrayList<String>();
		keys.add("name");
		heads.add("姓名");
		keys.add("mobile");
		heads.add("手机号");
		keys.add("tel");
		heads.add("电话");
		keys.add("createTime");
		heads.add("创建时间");
		keys.add("status");
		heads.add("推送状态");
		keys.add("pushTime");
		heads.add("推送时间");
		keys.add("firsrErrorTime");
		heads.add("第一次推送失败时间");
		keys.add("latErrorTime");
		heads.add("最后一次推送失败时间");
		keys.add("pushCount");
		heads.add("推送次数");
		keys.add("responseStr");
		heads.add("推送结果");
		String companyId = getCompanyId(); 
		String useId=getUserId();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("companyId", companyId);
		params.put("useId", useId);
		String startTime = request.getParameter("startTime");
		if(startTime != null && !startTime.equals("")){
			params.put("startTime", formatter.parse(startTime));//+" 00:00:00"
		}
		String endTime = request.getParameter("endTime");
		if(endTime != null && !endTime.equals("")){
			params.put("endTime", formatter.parse(endTime));//+" 23:59:59"
		}
		String status = request.getParameter("status");
		if(status != null && status.trim().length() > 0){
			params.put("status", status);
		}
		String phoneNumber = request.getParameter("phoneNumber");
		if(phoneNumber != null && phoneNumber.trim().length() > 0){
			params.put("phoneNumber", phoneNumber);
		}
		this.notifyService.clearNotifyTime(companyId, getUserId());
		List<ApiPushLog> apiPushLog = this.apiPushLogService.downApiPushVisitorInfo(new Page(), params);
		//List<ApiPushLog> apiPushLog=page.getRows();
		if(apiPushLog.size()>=1){
			for(ApiPushLog log : apiPushLog){
				Map<String, Object> mapApi = new HashMap<String, Object>();
				mapApi.put("name", log.getName());
				mapApi.put("mobile", log.getMobile());
				mapApi.put("tel", log.getTel());
				mapApi.put("createTime",log.getCreateTime()==null?log.getCreateTime():sdf.format(log.getCreateTime()));
				mapApi.put("status", log.getStatus()==0?"失败":"成功");
				mapApi.put("pushTime", log.getPushTime()==null?log.getPushTime():sdf.format(log.getPushTime()));
				mapApi.put("firsrErrorTime", log.getFirsrErrorTime()==null?log.getFirsrErrorTime():sdf.format(log.getFirsrErrorTime()));
				mapApi.put("latErrorTime", log.getLatErrorTime()==null?log.getLatErrorTime():sdf.format(log.getLatErrorTime()));
				mapApi.put("pushCount", log.getPushCount());
				mapApi.put("responseStr", log.getResponseStr());
				listMap.add(mapApi);
			}
		}
		keysFirst.addAll(keys);
		headsFirst.addAll(heads);
		response.setContentType("application/download");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ URLEncoder.encode("名片推送日记导出", "utf-8") + ".xls");
		String title = "名片推送日记";
/*		ExportUtil.export(listMap, title,
				keysFirst.toArray(new String[keys.size()]),
				headsFirst.toArray(new String[heads.size()]),
				response.getOutputStream());*/
	}
}
