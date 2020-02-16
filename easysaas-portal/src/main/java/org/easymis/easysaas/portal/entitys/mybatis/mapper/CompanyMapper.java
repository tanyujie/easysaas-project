package org.easymis.easysaas.portal.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.easymis.easysaas.portal.entitys.mybatis.dto.Company;

public interface CompanyMapper {

	@Select(" SELECT t.* FROM bi_dbs t }")
	public List<Company> getList(Company params);

	@Insert("insert into bi_dbs(dbs_id,database_name,sqlalchemy_uri,password,cache_timeout,extra,select_as_create_tabe_as,allow_ctas,expose_in_sqllab,force_ctas_schema,allow_run_async,allow_run_sync,perm,verbose_name,impersonate_user,allow_multi_schema_metadata_fetch)values(#{dbsId},#{databaseName},#{sqlalchemyUri},#{password},#{cacheTimeout},#{extra},#{selectAsCreateTabeAs},#{allowCtas},#{exposeInSqllab},#{forceCtasSchema},#{allowRunAsync},#{allowRunSync},#{perm},#{verboseName},#{impersonateUser},#{allowMultiSchemaMetadataFetch})")
	public void save(Company bean);

	@Insert("insert into bi_dbs(dbs_id,database_name,sqlalchemy_uri,password,cache_timeout,extra,select_as_create_tabe_as,allow_ctas,expose_in_sqllab,force_ctas_schema,allow_run_async,allow_run_sync,perm,verbose_name,impersonate_user,allow_multi_schema_metadata_fetch)values(#{dbsId},#{databaseName},#{sqlalchemyUri},#{password},#{cacheTimeout},#{extra},#{selectAsCreateTabeAs},#{allowCtas},#{exposeInSqllab},#{forceCtasSchema},#{allowRunAsync},#{allowRunSync},#{perm},#{verboseName},#{impersonateUser},#{allowMultiSchemaMetadataFetch})")
	public void saveBatch(List<Company> beans);

	@Update("UPDATE bi_dbs SET dbs_id= #{dbsId},database_name= #{databaseName},sqlalchemy_uri= #{sqlalchemyUri},password= #{password},cache_timeout= #{cacheTimeout},extra= #{extra},select_as_create_tabe_as= #{selectAsCreateTabeAs},allow_ctas= #{allowCtas},expose_in_sqllab= #{exposeInSqllab},force_ctas_schema= #{forceCtasSchema},allow_run_async= #{allowRunAsync},allow_run_sync= #{allowRunSync},perm= #{perm},verbose_name= #{verboseName},impersonate_user= #{impersonateUser},allow_multi_schema_metadata_fetch= #{allowMultiSchemaMetadataFetch} WHERE dbs_id= #{dbsId}")
	public void update(Company bean);

	@Delete(" DELETE FROM bi_dbs WHERE dbs_id = #{dbsId}")
	public void delete(String dbs_id);

	public void removeBatch(List<String> list);

	public void restoreBatch(List<String> list);

	public void deleteBatch(List<String> list);

	@Select("select * from company t WHERE t.company_id = #{companyId}")
	public Company findById(@Param("companyId") String companyId);

	@Select({"<script>",
        "SELECT * from company",
        "WHERE companyId IN", 
          "<foreach item='item' index='index' collection='ids'",
            "open='(' separator=',' close=')'>",
            "#{item}",
          "</foreach>",
        "</script>"}) 
	public List<Company> findByIds(@Param("ids")List<String> ids);
	@Select("select * from company t WHERE t.parent_id = #{companyId}")
	public List<Company> getBranchList(@Param("companyId") String companyId);
	
}