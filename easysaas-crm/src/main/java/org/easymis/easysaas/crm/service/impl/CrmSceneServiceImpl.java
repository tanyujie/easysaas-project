package org.easymis.easysaas.crm.service.impl;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.mybatis.dto.CrmScene;
import org.easymis.easysaas.crm.entitys.mybatis.dto.School;
import org.easymis.easysaas.crm.service.CrmSceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
@Service
public class CrmSceneServiceImpl implements CrmSceneService {
	@Autowired
	private CrmSceneMapper mapper;
	@Override
	public boolean save(CrmScene bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(CrmScene bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public School findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageInfo findByOrgId(String orgId, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RestResult deleteByIds(String ids) {
		// TODO Auto-generated method stub
		return null;
	}

}
