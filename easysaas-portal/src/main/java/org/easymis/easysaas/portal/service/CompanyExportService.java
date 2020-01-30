package org.easymis.easysaas.portal.service;

import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyExport;

public interface CompanyExportService {
	void save(CompanyExport bean);
    void uploadExcel(CompanyExport record, byte[] bytes, Integer queryNumber, String memberId, Integer skip, String keyword, String recordNo,String toMail);
}
