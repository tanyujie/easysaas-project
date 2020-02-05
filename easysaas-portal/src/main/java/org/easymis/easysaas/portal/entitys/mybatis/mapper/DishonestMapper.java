package org.easymis.easysaas.portal.entitys.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.portal.entitys.mybatis.dto.Dishonest;

public interface DishonestMapper {
	@Select("select * from dishonest t WHERE t.id = #{id}")
	public Dishonest findById(@Param("id")String id);
}
