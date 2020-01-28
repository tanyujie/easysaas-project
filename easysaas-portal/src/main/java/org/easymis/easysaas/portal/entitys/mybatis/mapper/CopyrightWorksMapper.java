package org.easymis.easysaas.portal.entitys.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.portal.entitys.mybatis.dto.CopyrightWorks;

public interface CopyrightWorksMapper {
	@Select("select * from copyright_works")

	public List<CopyrightWorks> getList(HashMap<String, Object> params);

	@Insert("insert into copyright_works(id,company_id,register_no,name,type,author,finish_time,first_publish_time,register_time,publish_time,country,province,city,writer,source_url,deleted,update_time,create_time)values(#{id},#{companyId},#{registerNo},#{name},#{type},#{author},#{finishTime},#{firstPublishTime},#{registerTime},#{publishTime},#{country},#{province},#{city},#{writer},#{sourceUrl},#{deleted},#{updateTime},#{createTime})")
	public void save(CopyrightWorks bean);

	@Insert("insert into copyright_works(id,company_id,register_no,name,type,author,finish_time,first_publish_time,register_time,publish_time,country,province,city,writer,source_url,deleted,update_time,create_time)values(#{id},#{companyId},#{registerNo},#{name},#{type},#{author},#{finishTime},#{firstPublishTime},#{registerTime},#{publishTime},#{country},#{province},#{city},#{writer},#{sourceUrl},#{deleted},#{updateTime},#{createTime})")
	public void saveBatch(List<CopyrightWorks> beans);

	@Update("UPDATE copyright_works SET id= #{id},company_id= #{companyId},register_no= #{registerNo},name= #{name},type= #{type},author= #{author},finish_time= #{finishTime},first_publish_time= #{firstPublishTime},register_time= #{registerTime},publish_time= #{publishTime},country= #{country},province= #{province},city= #{city},writer= #{writer},source_url= #{sourceUrl},deleted= #{deleted},update_time= #{updateTime},create_time= #{createTime} WHERE id= #{id}")
	public void update(CopyrightWorks bean);

	@Delete(" DELETE FROM copyright_works WHERE id = #{id}")
	public void delete(String id);

	public void removeBatch(List<String> list);

	public void restoreBatch(List<String> list);

	public void deleteBatch(List<String> list);

	@Select("select * from copyright_works t WHERE t.id = #{id}")
	public CopyrightWorks findById(String id);

	@Select(" SELECT t.* FROM copyright_works t }")
	public List<CopyrightWorks> findByIds(List<String> list);
	@Select({"<script>",
        "SELECT * from copyright_works",
        " WHERE company_Id=#{companyId}", 
          "order by register_time desc",
        "</script>"}) 
	List<CopyrightWorks>  findByCompanyId(@Param("companyId") String companyId);
}