package org.easymis.easysaas.imserver.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.imserver.entitys.mybatis.dto.Card;

public interface VisitorInfoMapper {
	 @Select("select * from js_visitor_info where id =#{cardId}")  
	List<Card> findByCardId(@Param("cardId") String cardId);
}
