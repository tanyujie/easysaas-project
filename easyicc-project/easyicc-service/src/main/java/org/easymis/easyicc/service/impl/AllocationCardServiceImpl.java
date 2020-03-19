package org.easymis.easyicc.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.easymis.easyicc.domain.vo.StaffSalesVo;
import org.easymis.easyicc.mybatis.mapper.CardMapper;
import org.easymis.easyicc.mybatis.mapper.VisitorInfoMapper;
import org.easymis.easyicc.service.AllocationCardService;
import org.easymis.easyicc.service.CardLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.cache.CacheFactory;
@Service
public class AllocationCardServiceImpl implements AllocationCardService {
	private final static SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
	private final static Log _logger = LogFactory.getLog(AllocationCardService.class);
	@Autowired
	private CacheFactory cacheFactory;
	@Autowired
	private CardMapper cardMapper;
	@Autowired
	private VisitorInfoMapper visitorInfoMapper;
	@Autowired
	private CardLogService cardLogService;
	@Override
	public List<StaffSalesVo> getCanAllocationSaleUser(String companyId, String subjectId, String schoolId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Map<String, String> getStatus(String companyId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean updateCard(String cardId, String modifyIdentity, String subjectId, String schoolId) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean setNotValidate(String companyId, String cardId) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean userAllocationCard(String companyId, String cardId, String userId, String operatorId) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean allocation(String cardId) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void clearCache(String companyId, String userId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void clearAlternateCache(String companyId, String userId) {
		// TODO Auto-generated method stub
		
	}

	
}
