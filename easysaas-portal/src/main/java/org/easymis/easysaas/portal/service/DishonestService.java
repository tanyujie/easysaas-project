package org.easymis.easysaas.portal.service;

import java.io.IOException;

import org.easymis.easysaas.common.result.exception.ElasticSearchMaxRecordException;
import org.easymis.easysaas.portal.entitys.mybatis.dto.Dishonest;
import org.easymis.easysaas.portal.entitys.vo.DishonestPageData;
import org.easymis.easysaas.portal.entitys.vo.DishonestSearchVo;

public interface DishonestService {
	public DishonestPageData esQuery(DishonestSearchVo searchVo) throws IOException, ElasticSearchMaxRecordException;
	public Dishonest findById(String id);
}
