package org.easymis.easysaas.imserver.controller;

import java.util.HashMap;
import java.util.Map;

import org.easymis.easysaas.imserver.entitys.mybatis.dto.CardRule;
import org.easymis.easysaas.imserver.service.AllocationCardService;
import org.easymis.easysaas.imserver.service.BackTypeService;
import org.easymis.easysaas.imserver.service.CardConfigService;
import org.easymis.easysaas.imserver.service.CardLogService;
import org.easymis.easysaas.imserver.service.CardRuleService;
import org.easymis.easysaas.imserver.service.NotifyService;
import org.easymis.easysaas.imserver.service.SchoolService;
import org.easymis.easysaas.imserver.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Api(value = "/allocation/card", description = "名片分配")
@Controller
@RequestMapping("/allocation/card")
public class AllocationCardController extends IdentityRepository{
	@Autowired
	private CardConfigService cardConfigService;
	
	@Autowired
	private AllocationCardService allocationCardService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private SchoolService schoolService;
	
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
		model.put("subjects", subjectService.getListByTemplate(params));
		model.put("schools", this.schoolService.getListByTemplate(params));
		model.put("backTypes", this.backTypeService.getListByTemplate(params));
		
		CardRule rule = this.ruleService.get(companyId);
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
		//	String userId = OnLine.getCurrentUserDetails().getUserId();
		//	weixinService.action(card)
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return PREFIX + "/index";
	}
}
