package org.easymis.easyicc.service.impl;

import java.util.List;

import org.easymis.easyicc.common.result.RestResult;
import org.easymis.easyicc.domain.entity.Scheduling;
import org.easymis.easyicc.service.SchedulingService;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
@Service
public class SchedulingServiceImpl implements SchedulingService {

	@Override
	public boolean save(Scheduling bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Scheduling bean) {
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
