package org.easymis.easysaas.crm.service.impl;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.mybatis.dto.SchoolRoom;
import org.easymis.easysaas.crm.entitys.mybatis.mapper.SchoolMapper;
import org.easymis.easysaas.crm.service.SchoolRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

@Service
public class SchoolRoomServiceImpl implements SchoolRoomService{
	@Autowired
	private SchoolRoomMapper mapper;
	@Override
	public boolean save(SchoolRoom bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(SchoolRoom bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SchoolRoom findById(String id) {
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
