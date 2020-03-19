package org.easymis.easyicc.card.admin.controller.setting;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.easymis.easyicc.card.admin.controller.IdentityRepository;
import org.easymis.easyicc.domain.entity.CardRule;
import org.easymis.easyicc.service.CardRuleService;
import org.easymis.easyicc.service.SchoolAreaService;
import org.easymis.easyicc.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
@Api(value = "/setting/rule", description = "名片分配规则设置")
@Controller
@RequestMapping("/setting/rule")
public class CardRuleController extends IdentityRepository{
	private final static String PREFIX = "/setting/rule";

	@Autowired
	private CardRuleService ruleService;
	
	@Autowired
	private SchoolAreaService schoolAreaService;
	
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping("/index")
	public String index(ModelMap model){
		
		String orgId=getCompanyId();
		model.put("schoolAreaList", schoolAreaService.findByOrgId(orgId));
		model.put("subjects", subjectService.findByOrgId(orgId));
		return PREFIX + "/index";
	}
	
	@RequestMapping("/data")
	@ResponseBody
	public CardRule loadData(){
		CardRule rule = this.ruleService.findByOrgId(getCompanyId());
		if(rule == null){
			rule = new CardRule();
		}
		return rule;
	}
	
	@RequestMapping("/update")
	public void update(CardRule rule, HttpServletResponse response) throws IOException{
		rule.setOrgId(getCompanyId());
		this.ruleService.saveOrUpdate(rule);
	}
}
