package org.easymis.easyicc.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.easymis.easyicc.domain.entity.ThirdPartyConfig;

public interface ThirdPartyConfigMapper {
	int insert(ThirdPartyConfig bean);

	int update(ThirdPartyConfig bean);

	int delete(Long id);

	ThirdPartyConfig selectById(String id);

	List<ThirdPartyConfig> queryList(ThirdPartyConfig bean);

	List<ThirdPartyConfig> queryListByMap(Map<String, Object> params);
}
