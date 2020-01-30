package org.easymis.easysaas.portal.service.impl;

import java.util.List;

import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyExportHistory;
import org.easymis.easysaas.portal.entitys.vo.SearchOutput;
import org.easymis.easysaas.portal.service.CompanyExportHistoryService;
import org.springframework.stereotype.Service;
@Service
public class CompanyExportHistoryServiceImpl implements CompanyExportHistoryService {

	@Override
	public List<String> findByShort(String memberId, String exportQueryMD5) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SearchOutput> compareDifferenceOfTarget(List<String> cacheLongs, List<SearchOutput> infoList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOutput(List<SearchOutput> differenceList, String memberId, String exportedQueryMD5) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveBatch(List<CompanyExportHistory> historyRecords) {
		// TODO Auto-generated method stub

	}

}
