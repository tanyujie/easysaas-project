package org.easymis.easysaas.portal.service;

import java.util.List;

import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyExportHistory;
import org.easymis.easysaas.portal.entitys.vo.SearchOutput;

public interface CompanyExportHistoryService {
	List<String> findByShort(String memberId, String exportQueryMD5);

	List<SearchOutput> compareDifferenceOfTarget(List<String> cacheLongs, List<SearchOutput> infoList);

	void saveOutput(List<SearchOutput> differenceList, String memberId, String exportedQueryMD5);
	void saveBatch(List<CompanyExportHistory> historyRecords);
}
