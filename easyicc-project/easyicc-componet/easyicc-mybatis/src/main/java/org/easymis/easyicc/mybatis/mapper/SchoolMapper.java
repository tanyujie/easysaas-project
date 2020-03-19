package org.easymis.easyicc.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easyicc.domain.entity.School;

public interface SchoolMapper {
	@Select("select * from school t WHERE t.org_id = #{orgId}")
	School findByOrgId(@Param("orgId") String orgId);

	@Insert("INSERT INTO school(school_id, org_id, name, school_type, province_id, city_id, district_id, address_detail, contact, contact_backup) "
			+ "VALUES"
			+ " (#{schoolId}, #{orgId}, #{name}, #{schoolType}, #{provinceId}, #{cityId}, #{districtId}, #{addressDetail}, #{contact}, #{contactBackup});")
	boolean insertByBean(School bean);
	@Update("UPDATE member set name=#{username},account=#{account},email=#{email},mobile=#{mobile},wx=#{wx},address=#{address},photo=#{photo},sex=#{sex} WHERE id = #{id}")
	boolean update(School bean);
	@Select("select * from school t WHERE t.school_id = #{schoolId}")
	School findById(@Param("schoolId") String schoolId);
}
