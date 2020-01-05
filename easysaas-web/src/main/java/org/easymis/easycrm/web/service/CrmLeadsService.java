package org.easymis.easycrm.web.service;

import java.util.List;

import org.easymis.easycrm.web.entitys.mybatis.dto.CrmLeads;
import org.easymis.easycrm.web.entitys.mybatis.vo.CrmLeadsVo;

import com.github.pagehelper.PageInfo;

public interface CrmLeadsService {
	CrmLeads findById(String id);

	List findByList(CrmLeadsVo vo);

	PageInfo findByPage(CrmLeadsVo vo);

	Boolean save(CrmLeads bean);

	Boolean update(CrmLeads bean);

	Boolean delete(List<String> ids);

}
