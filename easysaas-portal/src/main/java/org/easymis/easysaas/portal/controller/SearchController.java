package org.easymis.easysaas.portal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
