package org.easymis.easysaas.imserver.service.impl;

import java.util.List;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.Scheduling;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.Subject;
import org.easymis.easysaas.imserver.service.SchedulingService;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
@Service
public class SchedulingServiceImpl implements SchedulingService {

	@Override
	public boolean save(Subject bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Subject bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Scheduling findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByOrgId(String orgId) {
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
