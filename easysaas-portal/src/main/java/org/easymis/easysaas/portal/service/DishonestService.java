package org.easymis.easysaas.portal.service;

import java.io.IOException;

import org.easymis.easysaas.common.result.PageData;
import org.easymis.easysaas.common.result.exception.ElasticSearchMaxRecordException;
import org.easymis.easysaas.portal.entitys.vo.DishonestSearchVo;

public interface DishonestService {
	public PageData esQuery(DishonestSearchVo searchVo) throws IOException, ElasticSearchMaxRecordException;
}
