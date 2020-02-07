package org.easymis.easysaas.portal.entitys.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.easymis.easysaas.portal.entitys.mybatis.dto.DishonestExec;

public interface DishonestExecMapper {
	@Select({"<script>",
        "SELECT * from dishonest_exec",
        " WHERE dishonest_Id=#{dishonestId}", 
          "order by publish_date desc",
        "</script>"}) 
	List<DishonestExec>  findByDishonestId(@Param("dishonestId") String dishonestId);
}
