package org.easymis.easysaas.portal.service;

import com.github.pagehelper.PageInfo;

public interface CopyrightWorksService {
	PageInfo findByPage(String companyId,Integer pageNum, Integer pageSize);
}
