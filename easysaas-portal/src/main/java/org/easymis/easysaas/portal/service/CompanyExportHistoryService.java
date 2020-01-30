package org.easymis.easysaas.portal.service;

import java.util.List;

import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyExportHistory;
import org.easymis.easysaas.portal.entitys.vo.SearchOutput;

public interface CompanyExportHistoryService {
	List<String> findByShort(String memberId, String exportQueryMD5);

	public List<SearchOutput> compareDifferenceOfTarget(List<String> longs, List<SearchOutput> targetList);

	void saveOutput(List<SearchOutput> targetList, String memberId, String exportedQueryMD5);
	void saveBatch(List<CompanyExportHistory> historyRecords);
}
