package org.easymis.easycrm.mobile.service;

import java.util.List;

import org.easymis.easycrm.mobile.entitys.mybatis.dto.CrmCustomer;
import org.easymis.easycrm.mobile.entitys.mybatis.vo.CrmCustomerVo;

import com.github.pagehelper.PageInfo;

public interface CrmCustomerService {
	CrmCustomer findById(String id);
	List findByList(CrmCustomerVo vo);
	PageInfo findByPage(CrmCustomerVo vo);
	Boolean save(CrmCustomer bean);
	Boolean update(CrmCustomer bean);	
	Boolean delete(List<String> ids);	

}
