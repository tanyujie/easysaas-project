package org.easymis.easysaas.core.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.easymis.easysaas.core.service.CompanyChangeInfoService;
import org.easymis.easysaas.core.utils.web.RestfulMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@Api(description = "变更记录相关接口")
@Validated
@RequestMapping("/companyChange")
@RestController
public class CompanyChangeController {
	@Autowired
	private CompanyChangeInfoService companyChangeInfoService;

	@ApiOperation(value = "变更记录")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "companyId", value = "公司id", dataType = "int", required = true),
			@ApiImplicitParam(name = "pageNum", value = "页数", dataType = "int", required = true),
			@ApiImplicitParam(name = "pageSize", value = "每页显示个数", dataType = "int", required = true)
	})
	@GetMapping("/info")
	public RestfulMessage info(@NotNull @Min(1) Long companyId,Integer pageNum, Integer pageSize){
		//RestfulMessage result = SearchResult.buildSuccess();
/*		pageNum = Objects.isNull(pageNum)?1:pageNum;
		pageSize = Objects.isNull(pageSize)?5:pageSize;
		IPage<CompanyChangeInfo> page = companyChangeInfoService.page(new Page<>(pageNum, pageSize), new LambdaQueryWrapper<CompanyChangeInfo>().eq(CompanyChangeInfo::getCompanyId, companyId).orderByDesc(CompanyChangeInfo::getChangeTime));
		
		page.getRecords().forEach(
                company -> {
                	company.setContentBefore(removeHtmlTag(company.getContentBefore()));
                	company.setContentAfter(removeHtmlTag(company.getContentAfter()));
                });
		result.success(page);*/
		return RestfulMessage.success();
	}
	/**
	 * 删除Html标签
	 */
	public static String removeHtmlTag(String htmlStr) {
	    //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
	    String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
	    //定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
	    String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
	    //定义HTML标签的正则表达式
	    String regEx_html = "<[^>]+>";
	    //定义一些特殊字符的正则表达式 如：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    String regEx_special = "\\&[a-zA-Z]{1,10};";

	    //1.过滤script标签
	    Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
	    Matcher m_script = p_script.matcher(htmlStr);
	    htmlStr = m_script.replaceAll("");
	    //2.过滤style标签
	    Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
	    Matcher m_style = p_style.matcher(htmlStr);
	    htmlStr = m_style.replaceAll("");
	    //3.过滤html标签
	    Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
	    Matcher m_html = p_html.matcher(htmlStr);
	    htmlStr = m_html.replaceAll("");
	    //4.过滤特殊标签
	    Pattern p_special = Pattern.compile(regEx_special, Pattern.CASE_INSENSITIVE);
	    Matcher m_special = p_special.matcher(htmlStr);
	    htmlStr = m_special.replaceAll("");

	    return htmlStr;
	}

}
