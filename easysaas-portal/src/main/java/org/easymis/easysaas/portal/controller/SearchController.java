package org.easymis.easysaas.portal.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.easymis.easysaas.common.contant.RegexConstant;
import org.easymis.easysaas.common.result.PageData;
import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.common.result.exception.ElasticSearchMaxRecordException;
import org.easymis.easysaas.common.utils.MD5Util;
import org.easymis.easysaas.common.utils.PayUtils;
import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyExport;
import org.easymis.easysaas.portal.entitys.vo.ExportQueryVo;
import org.easymis.easysaas.portal.entitys.vo.SearchOutput;
import org.easymis.easysaas.portal.entitys.vo.SearchVo;
import org.easymis.easysaas.portal.service.CompanyExportService;
import org.easymis.easysaas.portal.service.SearchService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
@Api(description = "查询入口接口")
@Controller
@Validated
@Slf4j
public class SearchController extends IdentityRepository{
	
	@Autowired
	SearchService searchService;
	@Autowired
	private CompanyExportService companyExportRecordService;
    @ApiOperation(value = "根据各种条件查询公司信息", response = SearchOutput.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "wd", value = "搜索关键字", dataType = "string", required = false),
		@ApiImplicitParam(name = "province", value = "省名称", dataType = "string", required = false),
		@ApiImplicitParam(name = "city", value = "市名称", dataType = "string", required = false),
		@ApiImplicitParam(name = "district", value = "区名称", dataType = "string", required = false),
    })
    @RequestMapping(value = {"/search", "/search/{t}"})
	public String search(SearchVo searchVo,  @PathVariable(required = false)String t,ModelMap map) throws IOException, ElasticSearchMaxRecordException {
		Integer term=0;
    	if(StringUtils.isNotEmpty(t))
    		term=new Integer(t.substring(1));
    	searchVo.setTerm(term);
    	PageData pageData = searchService.esQuery(searchVo);

		map.put("vo", searchVo);
		map.put("pageData", pageData);
		if (term < 100)
			return "/search";
		else if (term >= 100 && term < 200)
			return "/search/searchT100";
		else if (term >= 100 && term < 300)
			return "/search/searchT200";
		else if (term >= 300 && term < 400)
			return "/search/searchT300";
		else
			return "/search/searchT400";
	}
    @ApiOperation(value = "根据各种条件查询公司信息并导出", response = SearchOutput.class)
	@ApiImplicitParams(value = {
			@ApiImplicitParam(name = "sortType", value = "排序类型：1距离从近到远,2距离从远到近,3注册资本从高到低,4注册资本从低到高,5成立日期从早到晚,6成立日期从晚到早,7参保人数从多到少,8参保人员从少到多", dataType = "int", required = false),
			@ApiImplicitParam(name = "companyName", value = "公司名,与法人参数互斥只能传一个，另一个为空", dataType = "string", required = false),
			@ApiImplicitParam(name = "legalPersonName", value = "法人，与公司名参数互斥只能传一个，另一个为空", dataType = "string", required = false),
			@ApiImplicitParam(name = "province", value = "省名称", dataType = "string", required = false),
			@ApiImplicitParam(name = "city", value = "市名称", dataType = "string", required = false),
			@ApiImplicitParam(name = "district", value = "区名称", dataType = "string", required = false),
			@ApiImplicitParam(name = "cateFirst", value = "分类-门类名称", dataType = "string", required = false),
			@ApiImplicitParam(name = "cateSecond", value = "分类-大类名称", dataType = "string", required = false),
			@ApiImplicitParam(name = "cateThird", value = "分类-中类名称", dataType = "string", required = false),
			@ApiImplicitParam(name = "distance", value = "距离，单位是km,如：0.5，3", dataType = "float", required = false),
			@ApiImplicitParam(name = "latitude", value = "纬度", dataType = "float", required = false),
			@ApiImplicitParam(name = "longitude", value = "经度", dataType = "float", required = false),
			@ApiImplicitParam(name = "registerCapitalFrom", value = "注册资本金额范围-开始，单位万元", dataType = "int", required = false),
			@ApiImplicitParam(name = "registerCapitalTo", value = "注册资本金额范围-结束，单位万元", dataType = "int", required = false),
			@ApiImplicitParam(name = "estiblishTimeFrom", value = "成立时间范围-开始，时间格式：20190101", dataType = "int", required = false),
			@ApiImplicitParam(name = "estiblishTimeTo", value = "成立时间范围-结束，时间格式：20190101", dataType = "int", required = false),
			@ApiImplicitParam(name = "registerCapitalType", value = "资本币种：人民币,美元,其他", dataType = "string", required = false),
			@ApiImplicitParam(name = "insurancePersonNumberFrom", value = "参保人数范围-开始", dataType = "int", required = false),
			@ApiImplicitParam(name = "insurancePersonNumberTo", value = "参保人数范围-结束", dataType = "int", required = false),
			@ApiImplicitParam(name = "telType", value = "电话类型：1有手机号2有座机号3有联系方式4无联系方式", dataType = "int", required = false),
			@ApiImplicitParam(name = "haveEmail", value = "邮件:1有0无", dataType = "int", required = false),
			@ApiImplicitParam(name = "haveWebSite", value = "网址:1有0无", dataType = "int", required = false),
			@ApiImplicitParam(name = "companyStatus", value = "企业状态：1筹建2在业3存续", dataType = "int", required = false),
			@ApiImplicitParam(name = "companyTypeTag", value = "企业类型标签", dataType = "string", required = false),
			@ApiImplicitParam(name = "exportNumber", value = "导出数量", dataType = "string", required = true),
			@ApiImplicitParam(name = "recordId", value = "查询记录id", dataType = "int", required = true),
			@ApiImplicitParam(name = "keyword", value = "关键字", dataType = "string", required = true) })
    @ResponseBody
	@RequestMapping(value = "/company/export.do", method = { RequestMethod.GET, RequestMethod.POST })
	public RestResult exportQuery(@Valid ExportQueryVo exportQueryDto,
			@NotNull(message = "请输入导出的数据") Integer exportNumber,
			@NotNull(message = "请输入正确的邮箱") @Pattern(regexp = RegexConstant.regexp_email, message = "邮箱地址格式不正确") String email,
			Integer recordId) throws Exception {
    	String memberId=this.getIdentityFeature();
		String exportQueryString = JSON.toJSONString(exportQueryDto);
		String exportQueryMD5 = MD5Util.md5(exportQueryString);
		CompanyExport exportRecord = new CompanyExport();

		exportRecord.setCreateTime(LocalDateTime.now());
		exportRecord.setQueryCondition(exportQueryString);
		exportRecord.setUrl("/summary/exportedQuery");
		exportRecord.setQueryConditionMd5(exportQueryMD5);
		exportRecord.setMemberId("");
		exportRecord.setQueryNumber(exportNumber);
		exportRecord.setRoleSn("");
		exportRecord.setRecordNo(PayUtils.generateNoncestr(16));
		exportRecord.setKeyword(exportQueryDto.getKeyword());
		exportRecord.setToMail(email);
		companyExportRecordService.save(exportRecord);
		searchService.exportQueryResult(exportQueryDto, exportNumber, email, memberId,exportQueryString, exportQueryMD5, exportRecord);
		return RestResult.buildSuccess();
		
	}
    @RequestMapping("/queryMatchData")
    public String queryMatchData() {
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        boolean matchPhrase = false;
        if (matchPhrase == Boolean.TRUE) {
            //不进行分词搜索
            boolQuery.must(QueryBuilders.matchPhraseQuery("name", "m"));
        } else {
            boolQuery.must(QueryBuilders.matchQuery("name", "m-m"));
        }
        List<Map<String, Object>> list = null;//ElasticsearchUtil.searchListData(indexName, esType, boolQuery, 10, "name", null, "name");
        return JSONObject.toJSONString(list);
    }
  
    
}
