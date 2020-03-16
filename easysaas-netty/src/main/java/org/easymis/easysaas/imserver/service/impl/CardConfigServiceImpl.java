package org.easymis.easysaas.imserver.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.easymis.easysaas.imserver.entitys.mybatis.dto.Card;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.CardLog;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.VisitorColSelf;
import org.easymis.easysaas.imserver.entitys.mybatis.mapper.VisitorColSelfMapper;
import org.easymis.easysaas.imserver.service.CardConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
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
	@Override
	public PageInfo<Card> pageVisitorCard(Page pageConfig, Map<String, Object> map, int status) throws Exception {
		StringBuilder hql = new StringBuilder();
		hql.append("select a.* from visitor_info a where  a.allocation_status > 0 ");
		List<Object> params = new ArrayList<Object>();
		if(status == 1){//退回
			hql.append(" and a.allocation_status = ? and a.is_back = 1 ");
			params.add(Card.STATUS_WAIT_USE_ALLOCATION);
		}else if(status == 2){//超期回收
			hql.append(" and a.allocation_status = ? and a.is_expired = 1 ");
			params.add(Card.STATUS_WAIT_USE_ALLOCATION);
		}else if(status == 3){//等待分配
			hql.append(" and a.allocation_status = ? and a.is_expired = 0 and a.is_back = 0 and a.back_user_id is null");
			params.add(Card.STATUS_WAIT_USE_ALLOCATION);
		}else if(status == 4){//已处理
			hql.append(" and a.allocation_status = ? and a.is_valid = 1 and a.back_user_id is null");
			params.add(Card.STATUS_FINISHED);
		}else if(status == 5){//未处理
			hql.append("and (a.allocation_status = ? or a.allocation_status = ? ) and a.back_user_id is null");
			params.add(Card.STATUS_SYSTEM_ALLOCATIONED);
			params.add(Card.STATUS_USE_ALLOCATIONED);
		}else if(status == 6){//设置无效
			hql.append(" and a.allocation_status = ? and a.is_valid = 0 ");
			params.add(Card.STATUS_FINISHED);
		}else if(status == 7){//再分配未处理
			hql.append("and a.allocation_status = ? and  a.back_user_id is not null");
			params.add(Card.STATUS_USE_ALLOCATIONED);
		}else if(status == 8){//再分配已处理
			hql.append("and a.allocation_status = ? and a.is_valid = 1 and a.back_user_id is not null");
			params.add(Card.STATUS_FINISHED);
		}else if(status == 9){
			hql.append(" and a.allocation_status = ? ");
			params.add(Card.STATUS_REPEAT);
		}else{
			//1, 2, 3, 6, 9
			hql.append(" and (a.allocation_status = ? or (a.allocation_status = ? and a.is_valid = 0) or  a.allocation_status = ?) ");
			params.add(Card.STATUS_WAIT_USE_ALLOCATION);
			params.add(Card.STATUS_FINISHED);
			params.add(Card.STATUS_REPEAT);
		}
		hql.append("/ and a.company_id = {companyId} /")
		   .append("/ and a.name like {name} / ")
		   .append("/ and a.tel like {tel} / ")
		   .append("/ and a.email like {email} / ")
		   .append("/ and a.note like {note} / ")
		   .append("/ and a.reseve_key like {reseveKey} / ")
		   .append("/ and a.sex = {sex} / ")
		   .append("/ and a.repName like {repName} / ")
		   .append("/ and a.mobile like {mobile} / ")
		   .append("/ and a.qq like {qq} / ")
		   .append("/ and a.msn like {msn} / ")
		   .append("/ and a.url like {url} / ")
		   .append("/ and a.area like {area} /")
		   .append("/ and a.create_time >= {startTime} / ")
		   .append("/ and a.create_time <= {endTime} / ")
		   .append("/ and a.company_name like {companyName} / ")
		   .append("/ and a.ext_column1 like {extColumn1} / ")
		   .append("/ and a.ext_column2 like {extColumn2} / ")
		   .append("/ and a.ext_column3 like {extColumn3} / ")
		   .append("/ and a.ext_column4 like {extColumn4} / ")
		   .append("/ and a.ext_column5 like {extColumn5} / ")
		   .append("/ and a.ext_column6 like {extColumn6} / ")
		   .append("/ and a.ext_column7 like {extColumn7} / ")
		   .append("/ and a.ext_column8 = {extColumn8} / ")//咨询项目
		   .append("/ and a.ext_column9 = {extColumn9} / ")//校区
		   .append("/ and a.ext_column10 like {extColumn10} / ")
		   .append("/ and a.back_type = {backType} /")
		   .append("/ and exists (select 1 from js_cuour_card_log b where a.id = b.card_id and b.user_id like {backUserId} and allocation_type = "+CardLog.ALLOCATION_TYPE_BACK+")/")
		   .append("order by a.create_time desc");
		//SQLEso sql = SQLInfo.parseSQLEso(hql.toString(), map, params.toArray(new Object[params.size()]));
		//Page<Card> page = this.template.query(sql.getSQL(), sql.getParams(), new PageResultSetExtractor<CuourCard>(pageConfig, new VisitorInfoRowMapper()));
		//return page;
	}

}
