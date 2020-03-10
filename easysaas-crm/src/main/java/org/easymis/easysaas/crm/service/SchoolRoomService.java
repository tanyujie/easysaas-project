package org.easymis.easysaas.crm.service;

import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.crm.entitys.dto.SchoolRoom;

import com.github.pagehelper.PageInfo;

public interface SchoolRoomService {
	public boolean save(SchoolRoom bean);

	public boolean update(SchoolRoom bean);

	public SchoolRoom findById(String id);

	public PageInfo findByOrgId(String orgId, Integer pageNum, Integer pageSize);

	public RestResult deleteByIds(String ids);
}
