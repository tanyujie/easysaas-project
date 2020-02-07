package org.easymis.easysaas.portal.service;

import com.github.pagehelper.PageInfo;

public interface DishonestExecService {
	PageInfo findByPageOnDishonestId(String dishonestId,Integer pageNum, Integer pageSize);
}
