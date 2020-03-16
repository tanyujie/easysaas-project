package org.easymis.easysaas.imserver.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.easymis.easysaas.imserver.entitys.mybatis.dto.VisitorColSelf;
import org.easymis.easysaas.imserver.entitys.mybatis.mapper.VisitorColSelfMapper;
import org.easymis.easysaas.imserver.service.CardConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CardConfigServiceImpl implements CardConfigService {
	@Autowired
	private VisitorColSelfMapper visitorColSelfMapper;
	@Override
	public List<VisitorColSelf> getShowVisitorCols(String orgId) throws Exception {
		// TODO Auto-generated method stub
		List<VisitorColSelf> list= visitorColSelfMapper.findByOrgId(orgId);
		List<VisitorColSelf> rtnList = new ArrayList<VisitorColSelf>();
		for(VisitorColSelf col : list){
			if(col.getHidden() == 1){
				rtnList.add(col);
			}
		}
		return rtnList;
	}

}
