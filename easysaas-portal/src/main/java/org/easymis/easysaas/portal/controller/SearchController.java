package org.easymis.easysaas.portal.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.easymis.easysaas.portal.config.ElasticSearchConfig;
import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyDto;
import org.easymis.easysaas.portal.entitys.vo.SearchOutput;
import org.easymis.easysaas.portal.entitys.vo.SearchVo;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SearchController {
    @Autowired
    private JestClient jestClient;
    @ApiOperation(value = "根据各种条件查询公司信息", response = SearchOutput.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "wd", value = "搜索关键字", dataType = "string", required = false),
		@ApiImplicitParam(name = "province", value = "省名称", dataType = "string", required = false),
		@ApiImplicitParam(name = "city", value = "市名称", dataType = "string", required = false),
		@ApiImplicitParam(name = "district", value = "区名称", dataType = "string", required = false),
    })
    @RequestMapping("/search")
    public String search(SearchVo searchVo,ModelMap map) throws IOException {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
           BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
           
           if (!StringUtils.isEmpty(searchVo.getWd())) {
               boolQueryBuilder.must(QueryBuilders.matchQuery("name", searchVo.getWd().trim()).operator(Operator.AND).analyzer("ik_max_word"));
               //boolQueryBuilder.must(QueryBuilders.matchQuery("name", wd.trim()));
           }
           //搜索范围
		if (!StringUtils.isEmpty(searchVo.getSearchType())) {
			if ("company".equals(searchVo.getSearchType())) {

			} else if ("human".equals(searchVo.getSearchType())) {

			} else if ("service".equals(searchVo.getSearchType())) {

			} else if ("trademark".equals(searchVo.getSearchType())) {

			} else if ("contact".equals(searchVo.getSearchType())) {

			} else if ("scope".equals(searchVo.getSearchType())) {

			}

		}
           //机构类型
           if (!StringUtils.isEmpty(searchVo.getCompanyType())) {
        	   
           }
           //省份地区
           if (!StringUtils.isEmpty(searchVo.getProvince())) {
        	   
           }
           //区县
           if (!StringUtils.isEmpty(searchVo.getAreaCode())) {
        	   
           }
           /**成立时间范围*/
           if(Objects.nonNull(searchVo.getEstiblishTimeYearType())) {
           	//	        list.add(processParamlist("注册时间", "estiblishTimeYearType", "1年内=1-2年=2-3年=3-5年=5-10年=10年以上", "1=2=3=4=5=6"));
           	LocalDate now = LocalDate.now();
           	DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
               Integer estiblishTimeFrom = new Integer(now.minus(1, ChronoUnit.YEARS).format(format));
               Integer estiblishTimeTo = new Integer(now.format(format));
           	if(searchVo.getEstiblishTimeYearType()==1)
               boolQueryBuilder.filter().add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));
           	if(searchVo.getEstiblishTimeYearType()==2) {
                   estiblishTimeFrom = new Integer(now.minus(2, ChronoUnit.YEARS).format(format));
                   estiblishTimeTo = new Integer(now.minus(1, ChronoUnit.YEARS).format(format));
                   boolQueryBuilder.filter().add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));        		
           	}

           	if(searchVo.getEstiblishTimeYearType()==3) {
                   estiblishTimeFrom = new Integer(now.minus(3, ChronoUnit.YEARS).format(format));
                   estiblishTimeTo = new Integer(now.minus(2, ChronoUnit.YEARS).format(format));
                   boolQueryBuilder.filter().add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));        		
           	}
           	if(searchVo.getEstiblishTimeYearType()==4) {
                   estiblishTimeFrom = new Integer(now.minus(5, ChronoUnit.YEARS).format(format));
                   estiblishTimeTo = new Integer(now.minus(3, ChronoUnit.YEARS).format(format));
                   boolQueryBuilder.filter().add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));        		
           	}
           	if(searchVo.getEstiblishTimeYearType()==5) {
                   estiblishTimeFrom = new Integer(now.minus(10, ChronoUnit.YEARS).format(format));
                   estiblishTimeTo = new Integer(now.minus(5, ChronoUnit.YEARS).format(format));
                   boolQueryBuilder.filter().add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));    
           		
           	}
           	if(searchVo.getEstiblishTimeYearType()==5) {
                   estiblishTimeFrom = new Integer(now.minus(10, ChronoUnit.YEARS).format(format));
                   estiblishTimeTo = new Integer(now.minus(5, ChronoUnit.YEARS).format(format));
                   boolQueryBuilder.filter().add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));    
           		
           	}
           	if(searchVo.getEstiblishTimeYearType()==6) {
                   estiblishTimeFrom = new Integer(now.minus(1000, ChronoUnit.YEARS).format(format));
                   estiblishTimeTo = new Integer(now.minus(10, ChronoUnit.YEARS).format(format));
                   boolQueryBuilder.filter().add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));    
           		
           	}
           	//21-7天内22-15天内23-1个月内24-3个月内25-半年内26-一年内
              	if(searchVo.getEstiblishTimeYearType()==21) {
                   estiblishTimeFrom = new Integer(now.minus(7, ChronoUnit.DAYS).format(format));
                   estiblishTimeTo = new Integer(now.minus(1, ChronoUnit.DAYS).format(format));
                   boolQueryBuilder.filter().add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));        		
           	}
              	else if(searchVo.getEstiblishTimeYearType()==22) {
                   estiblishTimeFrom = new Integer(now.minus(15, ChronoUnit.DAYS).format(format));
                   estiblishTimeTo = new Integer(now.minus(1, ChronoUnit.DAYS).format(format));
                   boolQueryBuilder.filter().add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));        		
           	}
              	else if(searchVo.getEstiblishTimeYearType()==23) {
                   estiblishTimeFrom = new Integer(now.minus(1, ChronoUnit.MONTHS).format(format));
                   estiblishTimeTo = new Integer(now.minus(1, ChronoUnit.DAYS).format(format));
                   boolQueryBuilder.filter().add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));        		
           	}
              	else if(searchVo.getEstiblishTimeYearType()==24) {
                   estiblishTimeFrom = new Integer(now.minus(3, ChronoUnit.MONTHS).format(format));
                   estiblishTimeTo = new Integer(now.minus(1, ChronoUnit.DAYS).format(format));
                   boolQueryBuilder.filter().add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));        		
           	}
              	else if(searchVo.getEstiblishTimeYearType()==25) {
                   estiblishTimeFrom = new Integer(now.minus(6, ChronoUnit.MONTHS).format(format));
                   estiblishTimeTo = new Integer(now.minus(1, ChronoUnit.DAYS).format(format));
                   boolQueryBuilder.filter().add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));        		
           	} else if(searchVo.getEstiblishTimeYearType()==26) {
                   estiblishTimeFrom = new Integer(now.minus(1, ChronoUnit.YEARS).format(format));
                   estiblishTimeTo = new Integer(now.minus(1, ChronoUnit.DAYS).format(format));
                   boolQueryBuilder.filter().add(QueryBuilders.rangeQuery("estiblish_time").gte(estiblishTimeFrom).lt(estiblishTimeTo));        		
           	}
           	
           }
           /**注册资本金额范围*/

           if(Objects.nonNull(searchVo.getRegisteredCapitalNumberType())) {
               //list.add(processParamlist("注册资本", "registeredCapitalNumberType", "100万以下=100-200万=200-500万=500-1000万=1000万以上", "1=2=3=4=5"));
           	if(searchVo.getRegisteredCapitalNumberType()==1)
           		boolQueryBuilder.filter().add(QueryBuilders.rangeQuery("registered_capital").gte(0).lte(100*1000000));
           	if(searchVo.getRegisteredCapitalNumberType()==2)
                   boolQueryBuilder.filter().add(QueryBuilders.rangeQuery("registered_capital").gte(100*1000000).lte(200*1000000));
           	if(searchVo.getRegisteredCapitalNumberType()==3)
                   boolQueryBuilder.filter().add(QueryBuilders.rangeQuery("registered_capital").gte(200*1000000).lte(500*1000000));
           	if(searchVo.getRegisteredCapitalNumberType()==4)
                   boolQueryBuilder.filter().add(QueryBuilders.rangeQuery("registered_capital").gte(500*1000000).lte(1000*1000000));
           	if(searchVo.getRegisteredCapitalNumberType()==5)
                   boolQueryBuilder.filter().add(QueryBuilders.rangeQuery("registered_capital").gte(1000*1000000));
           }
           /**联系方式*/
           if (new Integer(1).equals(searchVo.getHaveContact())) {
        	   
           }
           if (new Integer(0).equals(searchVo.getHaveContact())) {
        	   
           }
           /**手机*/
           if (new Integer(1).equals(searchVo.getHaveMobile())) {
        	   
           }
           if (new Integer(0).equals(searchVo.getHaveMobile())) {
        	   
           }
           /**商标*/
           if (new Integer(1).equals(searchVo.getHaveTrademark())) {
        	   
           }
           if (new Integer(0).equals(searchVo.getHaveTrademark())) {
        	   
           }
           /**邮箱*/
           if (new Integer(1).equals(searchVo.getHaveEmail())) {
               boolQueryBuilder.filter(QueryBuilders.boolQuery().must(QueryBuilders.existsQuery("email")).must(QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("email", "")).mustNot(QueryBuilders.termsQuery("email", "无"))));
           }
           if (new Integer(0).equals(searchVo.getHaveEmail())) {
               boolQueryBuilder.filter(QueryBuilders.boolQuery().should(QueryBuilders.termQuery("email", "")).should(QueryBuilders.termsQuery("email", "无")).should(QueryBuilders.boolQuery().mustNot(QueryBuilders.existsQuery("email"))));
           }
           /**网站*/
           if (new Integer(1).equals(searchVo.getHaveWebSite())) {
               boolQueryBuilder.filter(QueryBuilders.boolQuery().must(QueryBuilders.existsQuery("website")).must(QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("website", "")).mustNot(QueryBuilders.termsQuery("website", "无"))));
           }
           if (new Integer(0).equals(searchVo.getHaveWebSite())) {
               boolQueryBuilder.filter(QueryBuilders.boolQuery().should(QueryBuilders.termQuery("website", "")).should(QueryBuilders.termsQuery("website", "无")).should(QueryBuilders.boolQuery().mustNot(QueryBuilders.existsQuery("website"))));
           }
           /**高亮公司名*/
           HighlightBuilder highlightBuilder = new HighlightBuilder();
           highlightBuilder.field("name");
           searchSourceBuilder.query(boolQueryBuilder);
           searchSourceBuilder.highlighter(highlightBuilder);
           
           //searchSourceBuilder.size(dto.getPageSize());
          // searchSourceBuilder.from(dto.getPageNo());
           searchSourceBuilder.timeout(TimeValue.timeValueSeconds(20));
           String queryStr = searchSourceBuilder.toString();
           log.info("\n******es语句：" + queryStr);
           Search search = new Search.Builder(queryStr).addIndex(ElasticSearchConfig.INDEX_NAME).build();
           SearchResult result = jestClient.execute(search);
           /**返回字段处理*/
           List<SearchResult.Hit<CompanyDto, Void>> hits = result.getHits(CompanyDto.class, false);
           List<CompanyDto> outList = new ArrayList<>();
           try {
               for (SearchResult.Hit<CompanyDto, Void> esQueryOutputDTOVoidHit : hits) {
            	   CompanyDto out = esQueryOutputDTOVoidHit.source;
                   if (StringUtils.isEmpty(out.getName()) == false) {
                       out.setNameHighlight(esQueryOutputDTOVoidHit.highlight.get("name").get(0));
                   }


                   outList.add(out);
               }
           } catch (Exception e) {
               e.printStackTrace();
           }

           map.put("companyList", outList);
        return "/search";

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
    @RequestMapping("/dishonest")
    public String dishonest() {
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        boolean matchPhrase = false;
        if (matchPhrase == Boolean.TRUE) {
            //不进行分词搜索
            boolQuery.must(QueryBuilders.matchPhraseQuery("name", "m"));
        } else {
            boolQuery.must(QueryBuilders.matchQuery("name", "m-m"));
        }
        List<Map<String, Object>> list = null;//ElasticsearchUtil.searchListData(indexName, esType, boolQuery, 10, "name", null, "name");
        return "/dishonest";
    }    
    
}
