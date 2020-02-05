package org.easymis.easysaas.portal.controller;

import java.io.IOException;

import org.easymis.easysaas.common.result.exception.ElasticSearchMaxRecordException;
import org.easymis.easysaas.portal.entitys.mybatis.dto.Human;
import org.easymis.easysaas.portal.entitys.vo.HumanPageData;
import org.easymis.easysaas.portal.entitys.vo.HumanSearchVo;
import org.easymis.easysaas.portal.entitys.vo.SearchOutput;
import org.easymis.easysaas.portal.entitys.vo.SearchVo;
import org.easymis.easysaas.portal.service.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(description = "查老板")
@Controller
@Validated
public class HumanController {
	@Autowired
	HumanService humanService;
	
    @ApiOperation(value = "根据各种条件查询人员信息", response = SearchOutput.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "name", value = "搜索关键字", dataType = "string", required = false),
    })
    @RequestMapping("/human")
	public String humanIndex(SearchVo searchVo, ModelMap map) throws IOException, ElasticSearchMaxRecordException {
		//PageData pageData = searchService.esQuery(searchVo);

		//map.put("pageData", pageData);
		return "/human/index";

	}
    @ApiOperation(value = "热门搜索", response = SearchOutput.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "name", value = "搜索关键字", dataType = "string", required = false),
    })
    @RequestMapping("/human/hot.json")
	public String hot(SearchVo searchVo, ModelMap map) throws IOException, ElasticSearchMaxRecordException {
		//PageData pageData = searchService.esQuery(searchVo);

		//map.put("pageData", pageData);
		return "/human/index";

	}
    @ApiOperation(value = "根据各种条件查询人员信息", response = SearchOutput.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "name", value = "搜索关键字", dataType = "string", required = false),
    })
    @RequestMapping("/human/result")
    public String result(HumanSearchVo searchVo,ModelMap map) throws IOException, ElasticSearchMaxRecordException {
    	HumanPageData pageData = humanService.esQuery(searchVo);
    	map.put("searchVo", searchVo);
    	map.put("pageData", pageData);
    	return "/human/result";
    }
    @ApiOperation(value = "查询企业老赖详情", response = SearchOutput.class)
    @RequestMapping("/human/detail/{id}.html")
	public String detail(@PathVariable("id") String id, ModelMap map) {
    	Human vHuman = humanService.findById(id);
    	map.put("human", vHuman);
		return "/human/humanDetail";

	}
}
