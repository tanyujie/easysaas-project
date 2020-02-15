package org.easymis.easysaas.portal.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.easymis.easysaas.portal.config.SpringBootBeanUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Api(description = "首页")
@Validated
@Slf4j
@Controller
public class IndexController {
	@RequestMapping("/")
	public String index(ModelMap model) {
		Long now = System.currentTimeMillis();
		List<HashMap> result = new ArrayList<>();
		List<HashMap> resultHuman = new ArrayList<>();
		RedisTemplate<String, Object> redisTemplate=(RedisTemplate) SpringBootBeanUtil.getBean("redisTemplate");
		ZSetOperations zSetOperations = redisTemplate.opsForZSet();
		ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
		Set<String> value = zSetOperations.reverseRangeByScore("alias", 1, Double.MAX_VALUE);

		Set<String> valueHuman = zSetOperations.reverseRangeByScore("hotSearchHuman", 1, Double.MAX_VALUE);

		// key不为空的时候 推荐相关的最热前十名
		for (String val : valueHuman) {
			if (result.size() > 9) {// 只返回最热的前十名
				break;
			}
			Long time = (Long) valueOperations.get(val);
			if ((now - time) < 2592000000L) {// 返回最近一个月的数据
				HashMap map = new HashMap();
				if (val.split("\\|").length > 1) {
					map.put("id", val.split("\\|")[0]);
					map.put("name", val.split("\\|")[1]);
					map.put("count", zSetOperations.score("hotSearchHuman", val));
					resultHuman.add(map);

				}

			} else {// 时间超过一个月没搜索就把这个词热度归0
				zSetOperations.add("hotSearchHuman", val, 0);
			}

		}
		// key不为空的时候 推荐相关的最热前十名
		for (String val : value) {
			if (result.size() > 23) {// 只返回最热的前十名
				break;
			}
			Long time = (Long) valueOperations.get(val);
			if(time!=null)
			if ((now - time) < 2592000000L) {// 返回最近一个月的数据
				HashMap<String,Object> map = new HashMap();
				if (val.split("\\|").length > 1) {
					map.put("id", val.split("\\|")[0]);
					map.put("alias", val.split("\\|")[1]);
					map.put("count", zSetOperations.score("alias", val));
					result.add(map);

				}

			} else {// 时间超过一个月没搜索就把这个词热度归0
				zSetOperations.add("alias", val, 0);
			}

		}
		model.put("hotSearchCompanyList", result);
		model.put("hotSearchHumanList", resultHuman);
		return "/index";
	}
}
