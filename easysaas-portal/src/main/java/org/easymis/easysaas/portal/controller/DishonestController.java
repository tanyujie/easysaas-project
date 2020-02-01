package org.easymis.easysaas.portal.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.easymis.easysaas.common.result.PageData;
import org.easymis.easysaas.common.result.exception.ElasticSearchMaxRecordException;
import org.easymis.easysaas.portal.entitys.vo.SearchOutput;
import org.easymis.easysaas.portal.entitys.vo.SearchVo;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Api(description = "查老赖查询入口接口")
@Controller
@Validated
@Slf4j
public class DishonestController {
    @ApiOperation(value = "根据各种条件查询老赖信息", response = SearchOutput.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "wd", value = "搜索关键字", dataType = "string", required = false),
		@ApiImplicitParam(name = "province", value = "省名称", dataType = "string", required = false),
		@ApiImplicitParam(name = "city", value = "市名称", dataType = "string", required = false),
		@ApiImplicitParam(name = "district", value = "区名称", dataType = "string", required = false),
    })
    @RequestMapping("/dishonest")
	public String dishonest(SearchVo searchVo, ModelMap map) throws IOException, ElasticSearchMaxRecordException {
		//PageData pageData = searchService.esQuery(searchVo);

		//map.put("pageData", pageData);
		return "/dishonest/index";

	}
    @ApiOperation(value = "根据各种条件查询老赖信息", response = SearchOutput.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "name", value = "搜索关键字", dataType = "string", required = false),
		@ApiImplicitParam(name = "type", value = "查询类型1企业2个人", dataType = "integer", required = false),
    })
    @RequestMapping("/dishonest/result")
    public String result(String name,Integer type) {
    	
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        boolean matchPhrase = false;
        if (matchPhrase == Boolean.TRUE) {
            //不进行分词搜索
            boolQuery.must(QueryBuilders.matchPhraseQuery("name", "m"));
        } else {
            boolQuery.must(QueryBuilders.matchQuery("name", "m-m"));
        }
        List<Map<String, Object>> list = null;//ElasticsearchUtil.searchListData(indexName, esType, boolQuery, 10, "name", null, "name");
		if (type == null || type == 1)
			return "/dishonest/resultCompany";
		else
			return "/dishonest/resultPerson";
    	   
    }  
    @ApiOperation(value = "查询企业老赖详情", response = SearchOutput.class)
    @RequestMapping("/dishonest/detail/company/{id}.html")
    public String companyDetail() {
    	return "/dishonest/companyDetail";
    }
    @ApiOperation(value = "查询个人老赖详情", response = SearchOutput.class)
    @RequestMapping("/dishonest/detail/person/{id}.html")
    public String personDetail() {
    	return "/dishonest/personDetail";
    	
    }
}
