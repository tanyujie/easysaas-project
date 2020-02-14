package org.easymis.easysaas.portal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.easymis.easysaas.common.result.PageData;
import org.easymis.easysaas.common.result.RestResult;
import org.easymis.easysaas.common.result.exception.ElasticSearchMaxRecordException;
import org.easymis.easysaas.portal.config.SpringBootBeanUtil;
import org.easymis.easysaas.portal.entitys.vo.SearchOutput;
import org.easymis.easysaas.portal.entitys.vo.SearchVo;
import org.easymis.easysaas.portal.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Api(description = "热门搜索(公司)接口")
@RestController
@RequestMapping("/hotSearch/company")
@Slf4j
public class HotSearchCompanyController {
	
	RedisTemplate<String, Object> redisTemplate=(RedisTemplate) SpringBootBeanUtil.getBean("redisTemplate");
	
	@Autowired
	SearchService searchService;

	@RequestMapping(value = "/getTopTen")
	public RestResult redisGetTop10() {

		Long now = System.currentTimeMillis();
		List<HashMap> result = new ArrayList<>();
		ZSetOperations zSetOperations = redisTemplate.opsForZSet();
		ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
		Set<String> value = zSetOperations.reverseRangeByScore("alias", 1, Double.MAX_VALUE);

		// key不为空的时候 推荐相关的最热前十名
		for (String val : value) {
			if (result.size() > 9) {// 只返回最热的前十名
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
		return RestResult.buildSuccess(result);
	}
	@RequestMapping(value = "/getTop20")
	public RestResult redisGetTop20() {

		Long now = System.currentTimeMillis();
		List<HashMap> result = new ArrayList<>();
		ZSetOperations zSetOperations = redisTemplate.opsForZSet();
		ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
		Set<String> value = zSetOperations.reverseRangeByScore("alias", 1, Double.MAX_VALUE);

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
		return RestResult.buildSuccess(result);
	}
	/**
	 * 根据key搜索相关最热的前十名
	 */
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public RestResult redisGet(@RequestBody Map<String, Object> params) {
		String key = params.get("key").toString();
		Long now = System.currentTimeMillis();
		List<String> result = new ArrayList<>();
		ZSetOperations zSetOperations = redisTemplate.opsForZSet();
		ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
		Set<String> value = zSetOperations.reverseRangeByScore("alias", 0, Double.MAX_VALUE);
		// key不为空的时候 推荐相关的最热前十名
		for (String val : value) {
			val = val.split("\\|")[0];
			if (StringUtils.containsIgnoreCase(val, key)) {
				if (result.size() > 9) {// 只返回最热的前十名
					break;
				}
				Long time = (Long) valueOperations.get(val);
				if ((now - time) < 2592000000L) {// 返回最近一个月的数据
					result.add(val);
				} else {// 时间超过一个月没搜索就把这个词热度归0
					zSetOperations.add("alias", val, 0);
				}
			}
		}
		return RestResult.buildSuccess(result);
	}

	/**
	 * 每次点击给相关词热度+1
	 */
	@RequestMapping(value = "/incrementScore", method = RequestMethod.POST)
	public RestResult incrementScore(@RequestBody Map<String, Object> params) {
		String key = params.get("key").toString();
		Long now = System.currentTimeMillis();
		ZSetOperations zSetOperations = redisTemplate.opsForZSet();
		ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
		zSetOperations.incrementScore("alias", key, 1);
		valueOperations.getAndSet(key, now);
		return RestResult.buildSuccess();
	}

	/**
	 * 手动导入数据测试
	 * 
	 * @throws IOException
	 * @throws ElasticSearchMaxRecordException
	 */
	@RequestMapping(value = "/add")
	public RestResult redisAdd() throws IOException, ElasticSearchMaxRecordException {
		PageData pageData = new PageData();
		SearchVo dto = new SearchVo();
		dto.setWd("成都");
		dto.setPageNo(1);
		dto.setPageSize(100);
		pageData = searchService.esQuery(dto);
		List<SearchOutput> outList = (List<SearchOutput>) pageData.getInfo();

		Long now = System.currentTimeMillis();
		ZSetOperations zSetOperations = redisTemplate.opsForZSet();
		ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();

		for (int i = 0, lengh = outList.size(); i < lengh; i++) {
			String alias = outList.get(i).getAlias() + "|" + outList.get(i).getCompanyId();
			try {
				if (zSetOperations.score("alias", alias) <= 0) {
					zSetOperations.add("alias", alias, 0);
					valueOperations.set(alias, now);
				}
			} catch (Exception e) {
				zSetOperations.add("alias", alias, 0);
				valueOperations.set(alias, now);
			}
		}
		return RestResult.buildSuccess();
	}
}
