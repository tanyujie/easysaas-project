package org.easymis.easyicc.service;

import java.util.List;

import org.easymis.easyicc.common.result.RestResult;
import org.easymis.easyicc.domain.entity.Scheduling;

import com.github.pagehelper.PageInfo;

public interface SchedulingService {
	public boolean save(Scheduling bean);

	public boolean update(Scheduling bean);

	public Scheduling findById(String id);

	List findByOrgId(String orgId);

	public PageInfo findByOrgId(String orgId, Integer pageNum, Integer pageSize);

	public RestResult deleteByIds(String ids);
}
