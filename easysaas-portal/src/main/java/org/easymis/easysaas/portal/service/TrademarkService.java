package org.easymis.easysaas.portal.service;

import com.github.pagehelper.PageInfo;

public interface TrademarkService {
	PageInfo findByPage(String companyId,Integer pageNum, Integer pageSize);
}
