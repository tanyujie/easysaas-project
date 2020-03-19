package org.easymis.easyicc.card.admin.controller.setting;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easymis.easyicc.card.admin.controller.IdentityRepository;
import org.easymis.easyicc.domain.entity.Card;
import org.easymis.easyicc.domain.entity.CardRule;
import org.easymis.easyicc.domain.vo.StaffSalesVo;
import org.easymis.easyicc.service.AllocationCardService;
import org.easymis.easyicc.service.BackTypeService;
import org.easymis.easyicc.service.CardConfigService;
import org.easymis.easyicc.service.CardLogService;
import org.easymis.easyicc.service.CardRuleService;
import org.easymis.easyicc.service.NotifyService;
import org.easymis.easyicc.service.SchoolAreaService;
import org.easymis.easyicc.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;

@Api(value = "/allocation/card", description = "名片分配")
@Controller
@RequestMapping("/allocation/card")
public class AllocationCardController extends IdentityRepository{
	private final static String PREFIX = "/setting/allocation";
	private final static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired
	private CardConfigService cardConfigService;
	
	@Autowired
	private AllocationCardService allocationCardService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private SchoolAreaService schoolAreaService;
	
	@Autowired
	private NotifyService notifyService;
	
	@Autowired
	private BackTypeService backTypeService;
	
	@Autowired
	private CardLogService cardLogService;
	
	@Autowired
	private CardRuleService ruleService;
	@RequestMapping("/index")
	public String index(ModelMap model) throws Exception{
		String orgId = getCompanyId();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("companyId", orgId);
		model.put("cols", cardConfigService.getShowVisitorCols(orgId));
		model.put("subjects", subjectService.findByOrgId(orgId));
		model.put("schoolAreaList", this.schoolAreaService.findByOrgId(orgId));
		model.put("backTypes", this.backTypeService.findByOrgId(orgId));
		
		CardRule rule = this.ruleService.findByOrgId(orgId);
		if(rule == null){
			rule = new CardRule();
		}
		model.put("defaultSubjectId", rule.getDefaultSubjectId());
		model.put("defaultSchoolId", rule.getDefaultSchoolId());
		// 测试数据发送
		try {
		//	Card card = new Card();
		//	card.setCompanyId(1);
		//	card.setId(1989212);
		//	String userId = getUserId();
		//	weixinService.action(card)
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return PREFIX + "/index";
	}
	@RequestMapping("/query")
	@ResponseBody
	public PageInfo<Card> query(@RequestParam("status") int status, HttpServletRequest request) throws Exception{
		String orgId = getCompanyId();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orgId", orgId);
		String startTime = request.getParameter("startTime");
		if(startTime != null){
			params.put("startTime", formatter.parse(startTime));
		}
		String endTime = request.getParameter("endTime");
		if(endTime != null){
			params.put("endTime", formatter.parse(endTime));
		}
		params.put("extColumn8", request.getParameter("subjectId"));
		params.put("extColumn9", request.getParameter("schoolId"));
		
		String backUserId = request.getParameter("backUserId");
		if(backUserId != null && !backUserId.equals("")){
			params.put("backUserId", "%"+backUserId+"%");
		}
		String backType = request.getParameter("backType");
		if(backType != null && !backType.equals("")){
			params.put("backType", Integer.parseInt(backType));
		}
		this.notifyService.clearNotifyTime(orgId,getUserId());
		Page page= new Page();
		PageInfo<Card> pageInfo = this.cardConfigService.pageVisitorCard(page, params, status);

		//	CuourUserDetail ud = (CuourUserDetail)OnLine.getCurrentUserDetails();
			//if(ud.hasDataPermission("3d5c4d88-032f-409f-bf74-1b2f429d1216", "hideTelephone", "1")){
		if(true) {
				for(Card card : pageInfo.getList()){
						String noteString=card.getNote();
						String mobileString=card.getMobile();
						String telString=card.getTel();
						String qqString=card.getQq();
						String msnString=card.getMsn();
						card.setMobile(hidePhoneRule(mobileString));
						card.setQq(hidePhoneRule(qqString));
						card.setTel(hidePhoneRule(telString));
						card.setNote(hideMSNRule(noteString));
						card.setMsn(hideMSNRule(msnString));

				}
			}
		return pageInfo;
	}
	@RequestMapping("/saleUsers")
	@ResponseBody
	public List<Map<String, Object>> getCanAllocationSaleUser(@RequestParam("subjectId") String subjectId, 
			@RequestParam("schoolId") String schoolId) throws Exception{
		List<StaffSalesVo> users = this.allocationCardService.getCanAllocationSaleUser(getCompanyId(), subjectId, schoolId);
		Map<String, String> status = this.allocationCardService.getStatus(getCompanyId());
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for(StaffSalesVo user : users){
			Map<String, Object> info = new HashMap<String, Object>();
			info.put("schoolName", user.getSchoolName());
			info.put("subjectName", user.getSubjectName());
			info.put("businessGroupName", user.getBusinessGroupName());
			info.put("staffId", user.getStaffId());
			info.put("realName", user.getName());
			info.put("allocationCount", user.getAllocationCount());
			info.put("validCount", user.getValidCount());
			info.put("backCount", user.getBackCount());
			info.put("backRatio", user.getBackRatio());
			info.put("actualRatio", user.getActualRatio());
			info.put("fairRatio", user.getFairRatio());
			info.put("finishedCount", user.getFinishedCount());
			info.put("expiredCount", user.getExpiredCount());
			info.put("allocationWeight", user.getAllocationWeight());
			info.put("maxCardSize", user.getMaxCardSize());
			info.put("actualAllocationCount", user.getActualAllocationCount());
			info.put("actualValidCount", user.getActualValidCount());
			String st = status.get(user.getStaffId());
			info.put("status", st == null ? "offline" : st);
			info.put("saleAllocationCount", user.getSaleAllocationCount());
			info.put("saleFinishedCount", user.getSaleFinishedCount());
			list.add(info);
		}
		return list;
	}
	@RequestMapping(value="/allocation", method=RequestMethod.GET)
	public String allocation(@RequestParam("subjectId") int subjectId, 
			@RequestParam("cardId") int cardId, @RequestParam("schoolId") int schoolId, ModelMap model){
		return PREFIX + "/allocation";
	}
	
	@RequestMapping(value="/allocation", method=RequestMethod.POST)
	public void allocation(@RequestParam("allocationCardId") String cardId, 
			@RequestParam("allocationUserId") String userId, HttpServletResponse response) throws IOException{
		if(!userId.equals("")){
			this.allocationCardService.userAllocationCard(getCompanyId(), cardId, userId, getUserId());
			//RespResult.getSuccess().writeToResponse(response);
		}else{
			//RespResult.getError("请选择一个要分配的咨询师！").writeToResponse(response);
		}
		
	}
	
	@RequestMapping("/allocation/oneKey")
	public void allocation(@RequestParam("cardId") String cardId, HttpServletResponse response) throws IOException{
		boolean flag = this.allocationCardService.allocation(cardId);
		if(flag){
			//RespResult.getSuccess().writeToResponse(response);
		}else{
			//RespResult.getError("一键分配失败, 未找到合适的分配客服").writeToResponse(response);
		}
	}
	
	@RequestMapping("/notValidate")
	public void notValidate(@RequestParam("cardId") String cardId, HttpServletResponse response) throws IOException{
		this.allocationCardService.setNotValidate(getCompanyId(), cardId);
		//RespResult.getSuccess().writeToResponse(response);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam("cardId") int cardId, ModelMap model){
		//model.put("entity", this.allocationCardService.getCard(cardId));
		return PREFIX + "/edit";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public void edit(@RequestParam("id") String id, @RequestParam("modifyIdentity") String modifyIdentity, 
			@RequestParam("subjectId") String subjectId, @RequestParam("schooleId") String schooleId, HttpServletResponse response) throws IOException{
		boolean flag = this.allocationCardService.updateCard(id, modifyIdentity, subjectId, schooleId);
		if(flag){
		//	RespResult.getSuccess().writeToResponse(response);
		}else{
			//RespResult.getError("该名片已被修改或者不存在， 请刷新后重试").writeToResponse(response);
		}
		
	}
	
	@RequestMapping("/log/index")
	public String logIndex(ModelMap model) {
		return PREFIX + "/log";
	}
	
	@RequestMapping("/log/query")
	@ResponseBody
	public PageInfo<Map<String, Object>> logQuery(HttpServletRequest request) throws java.text.ParseException{
		Map<String, Object> params = new HashMap<String, Object>();
		String startTime = request.getParameter("startTime");
		if(startTime != null){
			params.put("startTime", formatter.parse(startTime));//+" 00:00:00"
		}
		String endTime = request.getParameter("endTime");
		if(endTime != null){
			params.put("endTime", formatter.parse(endTime));//+" 23:59:59"
		}
		String allocationType = request.getParameter("allocationType");
		if(allocationType != null && !allocationType.equals("")){
			params.put("allocationType", Integer.parseInt(allocationType));
		}
		String userId = request.getParameter("userId");
		if(userId != null && !userId.equals("")){
			params.put("userId", userId);
		}
		String mobile = request.getParameter("mobile");
		if(mobile != null && !mobile.equals("")){
			params.put("mobile", "%"+mobile+"%");
		}
		return this.cardLogService.pageQuery2(getCompanyId(), new Page(), params);
	}
	
	/*
	 * 
	 * 手动按钮清除名片分配的缓存
     */
	@RequestMapping(value="/clearCache", method=RequestMethod.POST)
	public void clearCache(HttpServletResponse response) throws IOException{
		String companyId = getCompanyId();
		String userId = getUserId();
		//System.out.println("测试");
		this.allocationCardService.clearCache(companyId,userId);
		
		//TODO : 清除轮循缓存
		this.allocationCardService.clearAlternateCache(companyId,userId);
	}
	

	
	
	public static String hidePhoneRule(String str){
		if(str != null && ! str.equals("")){
			return str.replaceAll("([0-9]{3}-?)[0-9]{4}([0-9]{3,6})","$1****$2");
		}else {
			return "";
		}
		
	}
	//微信号隐藏和备注的隐藏
	public static String hideMSNRule(String fullString){
		String returnString ="";
		StringBuilder sb = new StringBuilder();
		String reg = "([\\S]{3})(.*)([\\S]{2})";
		Pattern r = Pattern.compile(reg);
		if(fullString != null && fullString != ""){
			fullString = fullString.replace("，", ",");
			String [] atring =fullString.split(",");
			for(int i=0;i<atring.length;i++){
				Matcher m = r.matcher(atring[i]);
				String hideString = "";
				if(m.find()){
					for (int y = 0; y <m.group(2).length(); y++) {
						hideString=hideString+"*";
		            }
					returnString += m.group(1)+hideString+m.group(3);
		        }else{
		        	returnString = fullString;
		        }
				if(i<atring.length-1){
					returnString +=",";
				}
			}
		}
		return returnString;

	}	
}
