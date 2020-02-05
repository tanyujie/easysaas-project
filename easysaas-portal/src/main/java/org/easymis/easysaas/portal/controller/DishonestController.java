package org.easymis.easysaas.portal.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.easymis.easysaas.common.result.exception.ElasticSearchMaxRecordException;
import org.easymis.easysaas.portal.entitys.mybatis.dto.Dishonest;
import org.easymis.easysaas.portal.entitys.vo.DishonestPageData;
import org.easymis.easysaas.portal.entitys.vo.DishonestSearchVo;
import org.easymis.easysaas.portal.entitys.vo.SearchOutput;
import org.easymis.easysaas.portal.entitys.vo.SearchVo;
import org.easymis.easysaas.portal.service.DishonestService;
import org.easymis.easysaas.portal.service.IdentityCardAddressService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.BeanUtils;
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
import lombok.extern.slf4j.Slf4j;

@Api(description = "查老赖查询入口接口")
@Controller
@Validated
@Slf4j
public class DishonestController extends IdentityRepository{
	@Autowired
	DishonestService dishonestService;
	@Autowired
	IdentityCardAddressService identityCardAddressService;
	
	
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
    
    @ApiOperation(value = "热门搜索", response = SearchOutput.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "wd", value = "搜索关键字", dataType = "string", required = false),
		@ApiImplicitParam(name = "province", value = "省名称", dataType = "string", required = false),
		@ApiImplicitParam(name = "city", value = "市名称", dataType = "string", required = false),
		@ApiImplicitParam(name = "district", value = "区名称", dataType = "string", required = false),
    })
    @RequestMapping("/dishonest/hot.json")
	public String hot(SearchVo searchVo, ModelMap map) throws IOException, ElasticSearchMaxRecordException {
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
    public String result(DishonestSearchVo searchVo,ModelMap map) throws IOException, ElasticSearchMaxRecordException {
    	
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        boolean matchPhrase = false;
        if (matchPhrase == Boolean.TRUE) {
            //不进行分词搜索
            boolQuery.must(QueryBuilders.matchPhraseQuery("name", "m"));
        } else {
            boolQuery.must(QueryBuilders.matchQuery("name", "m-m"));
        }
        List<Map<String, Object>> list = null;//ElasticsearchUtil.searchListData(indexName, esType, boolQuery, 10, "name", null, "name");
    	
        DishonestSearchVo vo= new DishonestSearchVo();
        if(searchVo.getProvince()!=null)
        searchVo.setProvinceName(identityCardAddressService.findProvince(searchVo.getProvince()).getProvince());
    	BeanUtils.copyProperties(searchVo, vo);
        vo.setType(1);
        DishonestPageData companyPageData = dishonestService.esQuery(vo);
    	vo.setType(2);
        DishonestPageData  personPageData= dishonestService.esQuery(vo);

		
		map.put("searchVo", searchVo);
		

		if (searchVo.getType() != null && searchVo.getType() == 1) {
			companyPageData.setTotalPerson(personPageData.getPage().getTotal());
			companyPageData.setTotalCompany(companyPageData.getPage().getTotal());
			map.put("pageData", companyPageData);
			return "/dishonest/resultCompany";
		}else {
			personPageData.setTotalPerson(personPageData.getPage().getTotal());
			personPageData.setTotalCompany(companyPageData.getPage().getTotal());
			map.put("pageData", personPageData);
			return "/dishonest/resultPerson";
		}

    	   
    }  
    @ApiOperation(value = "查询企业老赖详情", response = SearchOutput.class)
    @RequestMapping("/dishonest/detail/{id}.html")
	public String detail(@PathVariable("id") String id, ModelMap map) {
		Dishonest vDishonest = dishonestService.findById(id);
		// DishonestOto dishonest= new DishonestOto();
		// BeanUtils.copyProperties(vDishonest, dishonest);
		map.put("dishonest", vDishonest);
		if (vDishonest.getDishonestType() == 1)
			return "/dishonest/companyDetail";
		else
			return "/dishonest/personDetail";
	}
    @ApiOperation(value = "查询企业老赖详情", response = SearchOutput.class)
    @RequestMapping("/dishonest/detail/company/{id}.html")
    public String companyDetail() {
    	return "/dishonest/companyDetail";
    }
    @ApiOperation(value = "查询个人老赖详情", response = SearchOutput.class)
    @RequestMapping("/dishonest/detail/person/{id}.html")
	public String personDetail(@PathVariable("id") String id, ModelMap map)
			throws IllegalAccessException, InvocationTargetException {
    	Dishonest vDishonest=dishonestService.findById(id);
    	//DishonestOto dishonest= new DishonestOto();
    	// BeanUtils.copyProperties(vDishonest, dishonest);
    	map.put("dishonest", vDishonest);
    	return "/dishonest/personDetail";
    	
    }
}
