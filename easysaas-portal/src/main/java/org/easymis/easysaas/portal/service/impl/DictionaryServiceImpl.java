package org.easymis.easysaas.portal.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.easymis.easysaas.portal.service.DictionaryService;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class DictionaryServiceImpl implements DictionaryService {

	@Override
	public List getEstiblishYearType() {
		 List<Map> list = new ArrayList<>();
         list.addAll(processParamlist("1年内=1-2年=2-3年=3-5年=5-10年=10年以上", "1=2=3=4=5=6"));
		return list;
	}
	public List getRegisteredCapitalType() {
		 return processParamlist("100万以下=100-200万=200-500万=500-1000万=1000万以上", "1=2=3=4=5");
	}

    /**
     * 　　* @description: 处理esQueryMoreParamList方法中参数返回
     */
    private List processParamlist(String strParams, String keyParams) {
        String[] strParam = strParams.split("=");
        String[] keyParam = keyParams.split("=");
        List<Map> paramList = new ArrayList<>();
        for (int i = 0; i < strParam.length; i++) {
            Map<String, Object> map2 = new HashMap<>();
            map2.put("key", keyParam[i]);
            map2.put("title", strParam[i]);
            paramList.add(map2);
        }
        return paramList;

    }
    private Map<String, Object> processParamlist(String desc, String name, String strParams, String keyParams) {
        String[] strParam = strParams.split("=");
        String[] keyParam = keyParams.split("=");
        Map<String, Object> map1 = new HashMap<>();
        List<Map> paramList = new ArrayList<>();
        for (int i = 0; i < strParam.length; i++) {
            Map<String, Object> map2 = new HashMap<>();
            map2.put("key", keyParam[i]);
            map2.put("title", strParam[i]);
            paramList.add(map2);
        }
        map1.put("name", name);
        map1.put("desc", desc);
        map1.put("list", paramList);
        return map1;

    }
}
