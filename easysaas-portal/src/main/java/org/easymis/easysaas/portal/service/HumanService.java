package org.easymis.easysaas.portal.service;

import java.io.IOException;
import java.util.List;

import org.easymis.easysaas.common.result.exception.ElasticSearchMaxRecordException;
import org.easymis.easysaas.portal.entitys.mybatis.dto.CompanyHuman;
import org.easymis.easysaas.portal.entitys.mybatis.dto.Human;
import org.easymis.easysaas.portal.entitys.vo.HumanPageData;
import org.easymis.easysaas.portal.entitys.vo.HumanSearchVo;



public interface HumanService extends IService<CompanyHuman> {
	List findByHumanInvestorIds(List humaninvestorIds);

	Human getById(String staffId);

	Human findById(String id);

	List<Human> list(List<String> humaninvestorIds);

	public HumanPageData esQuery(HumanSearchVo searchVo) throws IOException, ElasticSearchMaxRecordException;
}
