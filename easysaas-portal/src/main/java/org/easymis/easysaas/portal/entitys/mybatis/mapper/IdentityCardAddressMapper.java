package org.easymis.easysaas.portal.entitys.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.portal.entitys.mybatis.dto.IdentityCardAddress;

public interface IdentityCardAddressMapper {
	@Select("select * from identity_card_address t WHERE t.parent_code='086' and t.base = #{base}")
	public IdentityCardAddress findProvince(@Param("base")String base);
}
