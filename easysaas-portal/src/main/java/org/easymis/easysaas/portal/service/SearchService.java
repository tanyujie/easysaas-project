package org.easymis.easysaas.portal.service;

import java.io.IOException;

import org.easymis.easysaas.common.result.PageData;
import org.easymis.easysaas.common.result.exception.ElasticSearchMaxRecordException;
import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyExport;
import org.easymis.easysaas.portal.entitys.vo.ExportQueryVo;
import org.easymis.easysaas.portal.entitys.vo.SearchVo;
import org.easymis.easysaas.portal.entitys.vo.SecurityUserDetails;
import org.springframework.scheduling.annotation.Async;

public interface SearchService {
	public PageData esQuery(SearchVo searchVo) throws IOException, ElasticSearchMaxRecordException;

	@Async("QueryQuantityAsyncExecutorPool")
	void exportQueryResult(ExportQueryVo exportQueryVo, Integer exportNumber, String email,
			SecurityUserDetails userDetails, String exportQueryString, String exportQueryMD5,
			CompanyExport queryRecord) throws Exception;
}
