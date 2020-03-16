package org.easymis.easysaas.imserver.entitys.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.CardRule;

public interface CardRuleMapper {
	 @Select("select * from card_rule t WHERE t.org_id = #{orgId}")  
	 CardRule findByOrgId(@Param("orgId") String orgId);
}
