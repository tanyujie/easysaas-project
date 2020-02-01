package org.easymis.easysaas.open.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.open.entitys.mybatis.dto.Human;

@Mapper
public interface CompanyHumanMapper {
	@Select("select * from human t WHERE t.id = #{staffId}")
	Human getById(@Param("staffId") String staffId);
	@Select({"<script>",
        "SELECT * from human",
        "WHERE id IN", 
          "<foreach item='item' index='index' collection='ids'",
            "open='(' separator=',' close=')'>",
            "#{item}",
          "</foreach>",
        "</script>"}) 
	public List<Human> list(@Param("ids") List<String> ids);
}
