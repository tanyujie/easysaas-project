package org.easymis.easycrm.common.controller;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.easymis.easycrm.common.entitys.mybatis.dto.Company;
import org.easymis.easycrm.common.entitys.mybatis.dto.CompanyCategory;
import org.easymis.easycrm.common.entitys.mybatis.dto.CompanyCategoryCode;
import org.easymis.easycrm.common.entitys.mybatis.dto.CompanyLogo;
import org.easymis.easycrm.common.entitys.mybatis.vo.CompanyAllInfoOutputVo;
import org.easymis.easycrm.common.service.CompanyCategoryCodeService;
import org.easymis.easycrm.common.service.CompanyCategoryService;
import org.easymis.easycrm.common.service.CompanyLogoService;
import org.easymis.easycrm.common.service.CompanyService;
import org.easymis.easycrm.common.utils.web.RestfulMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@Api(description = "企业信息相关接口测试")
@RequestMapping("/company")
@RestController
public class CompanyBaseInfoController {

	@Autowired
	private CompanyService companyService;	
	@Autowired
	private CompanyLogoService companyLogoService;
	@Autowired
	private CompanyCategoryService companyCategoryService;
	@Autowired
	private CompanyCategoryCodeService companyCategoryCodeService;
	@ApiImplicitParams({
			@ApiImplicitParam(name = "companyId", value = "公司id", dataType = "int", required = true)
	})
	@GetMapping("/getInfo")
	public RestfulMessage allInfo(@NotNull @Min(1) String companyId) {
		RestfulMessage result = RestfulMessage.success();
		//company表信息
		Company detail = companyService.getById(companyId);
		if(Objects.isNull(detail)) {
			return RestfulMessage.failure("未查询到公司信息");
		}
		CompanyAllInfoOutputVo out = new CompanyAllInfoOutputVo();
		BeanUtils.copyProperties(detail, out);
		/**金额处理：
		 * 1 把金额显示为100.4800万人民币的处理为100.48。
		 * 2 如果为100.00处理为100。
		 * 3 如果金额中包含空格，去掉空格
		 */
		String pattern = "(\\d)+\\.(\\d)+";
		Pattern compile = Pattern.compile(pattern);
		String num="";
		String regcapital=detail.getRegCapital(),actualCapital=detail.getActualCapital();
		//
		if(StringUtils.isEmpty(regcapital) == false){
			Matcher matcher = compile.matcher(regcapital);
			if(matcher.find()) {
				num = matcher.group();
			}
			if(StringUtils.isEmpty(num)==false) {
				regcapital = regcapital.replace(num, String.format("%.2f", Float.valueOf(num)));
				regcapital = regcapital.replace(".00", "");
				regcapital = regcapital.replaceAll(" ","");
				out.setRegCapital(regcapital);
			}
		}
		//
		if(StringUtils.isEmpty(actualCapital) == false){
			Matcher matcher = compile.matcher(actualCapital);
			if(matcher.find()) {
				num = matcher.group();
			}
			if(StringUtils.isEmpty(num)==false) {
				actualCapital = actualCapital.replace(num, String.format("%.2f", Float.valueOf(num)));
				actualCapital = actualCapital.replace(".00", "");
				actualCapital = actualCapital.replaceAll(" ","");
				out.setActualCapital(actualCapital);
			}
		}
		//业态信息
		CompanyCategory category = companyCategoryService.getById(companyId);
		if (Objects.nonNull(category)) {
			CompanyCategoryCode cateCode = companyCategoryCodeService.findByCategoryCode(category.getCategoryCode());
			out.setCate1(cateCode.getCate1());
			out.setCate2(cateCode.getCate2());
			out.setCate3(cateCode.getCate3());
			out.setCategoryCode(cateCode.getCategoryCode());
		}
		//区域信息与清分信息
/*		CompanyCleanInfo cleanInfo = companyCleanInfoService.getById(companyId);
		if (Objects.nonNull(cleanInfo)) {
			LambdaQueryWrapper<AreaCode> query = new LambdaQueryWrapper<AreaCode>().eq(AreaCode::getCode, cleanInfo.getAreaCode());
			AreaCode areaCode = areaCodeService.getOne(query);
			if(Objects.nonNull(areaCode)){
				out.setAreaCode(areaCode.getCode());
				out.setProvince(areaCode.getProvince());
				out.setCity(areaCode.getCity());
				out.setDistrict(areaCode.getDistrict());
			}
			out.setStaffNumRange(cleanInfo.getStaffNumRange());
			out.setSocialSecurityStaffNum(cleanInfo.getSocialSecurityStaffNum());
		}*/
		//logo
		CompanyLogo logo = companyLogoService.getById(companyId);
		if (Objects.isNull(logo) == false) {
			out.setLogoUrl(logo.getSourceUrl());
		}
		return result.success(out);
	}
	
}
