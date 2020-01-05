package org.easymis.easycrm.web.service;

import java.util.List;

import org.easymis.easycrm.web.entitys.mybatis.dto.CrmCustomer;
import org.easymis.easycrm.web.entitys.mybatis.vo.CrmCustomerVo;

import com.github.pagehelper.PageInfo;

public interface CrmCustomerService {
	CrmCustomer findById(String id);
	List findByList(CrmCustomerVo vo);
	PageInfo findByPage(CrmCustomerVo vo);
	Boolean save(CrmCustomer bean);
	Boolean update(CrmCustomer bean);	
	Boolean delete(List<String> ids);	

}
