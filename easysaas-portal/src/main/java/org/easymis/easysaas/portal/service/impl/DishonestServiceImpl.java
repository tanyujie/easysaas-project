package org.easymis.easysaas.portal.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.easymis.easysaas.common.result.PageData;
import org.easymis.easysaas.common.result.PageVO;
import org.easymis.easysaas.common.result.exception.ElasticSearchMaxRecordException;
import org.easymis.easysaas.portal.config.ElasticSearchConfig;
import org.easymis.easysaas.portal.entitys.vo.DishonestOto;
import org.easymis.easysaas.portal.entitys.vo.DishonestSearchVo;
import org.easymis.easysaas.portal.entitys.vo.SearchOutput;
import org.easymis.easysaas.portal.service.DishonestService;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class DishonestServiceImpl implements DishonestService {
	@Autowired
	private JestClient jestClient;
	@Override
	public PageData esQuery(DishonestSearchVo searchVo) throws IOException, ElasticSearchMaxRecordException {
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		PageData pageData = new PageData();
		if (!StringUtils.isEmpty(searchVo.getName())) {
            boolQueryBuilder.must(QueryBuilders.matchQuery("name", searchVo.getName().trim()).operator(Operator.AND).analyzer("ik_max_word"));
		}
		
		/** 高亮公司名 */
		HighlightBuilder highlightBuilder = new HighlightBuilder();
		highlightBuilder.field("name");
		searchSourceBuilder.query(boolQueryBuilder);
		searchSourceBuilder.highlighter(highlightBuilder);

		searchSourceBuilder.size(searchVo.getPageSize());
		searchSourceBuilder.from((searchVo.getPageNo() - 1) * searchVo.getPageSize());
		searchSourceBuilder.timeout(TimeValue.timeValueSeconds(20));
		
		String queryStr = searchSourceBuilder.toString();
		log.info("\n******es语句：" + queryStr);
		Search search = new Search.Builder(queryStr).addIndex(ElasticSearchConfig.INDEX_NAME_DISHONEST).build();
		SearchResult result = jestClient.execute(search);
		
		/** 返回字段处理 */
		List<SearchResult.Hit<DishonestOto, Void>> hits = result.getHits(DishonestOto.class, false);

		List<DishonestOto> outList = new ArrayList<>();
		try {
			for (SearchResult.Hit<DishonestOto, Void> esQueryOutputDTOVoidHit : hits) {
				DishonestOto out = esQueryOutputDTOVoidHit.source;
				if (StringUtils.isNotEmpty(out.getName())) {
					out.setNameHighlight(esQueryOutputDTOVoidHit.highlight.get("name").get(0));
				}

				outList.add(out);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        Long total = result.getJsonObject().get("hits").getAsJsonObject().get("total").getAsJsonObject().get("value").getAsLong();
        if (outList.size() == 0)
            total = 0L;
        pageData.setInfo(outList);
        PageVO pageVO = new PageVO();
        pageVO.setTotal(total);
        pageVO.setPageSize(searchVo.getPageSize());
        pageVO.setPageNum(searchVo.getPageNo());
        Long pages = total / searchVo.getPageSize();
        if (total % searchVo.getPageSize() > 0)
            pages = pages + 1;
        pageVO.setPages(pages.intValue());
        pageData.setPage(pageVO);     
		return pageData;
	}

}
