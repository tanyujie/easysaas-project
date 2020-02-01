package org.easymis.easysaas.open.service;

import com.github.pagehelper.PageInfo;

public interface CopyrightWorksService {
	PageInfo findByPage(String companyId,Integer pageNum, Integer pageSize);
}
