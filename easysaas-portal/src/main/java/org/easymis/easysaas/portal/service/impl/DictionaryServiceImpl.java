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
	public List getSearchTypeList() {
		 List<Map> list = new ArrayList<>();
         list.addAll(processParamlist("企业名称=法人/股东/高管=产品服务=商标=联系方式=经营范围", "company=human=service=trademark=similarAddress=scope"));
		return list;
	}
	public List getOrganizationTypeList() {
		 List<Map> list = new ArrayList<>();
         list.addAll(processParamlist("企业=事业单位=基金会=社会组织=律所=香港特别行政区企业=台湾省企业", "normal_company=institution=npo_foundation=npo=lawFirm=hk=tw"));
		return list;
	}
	@Override
	public List getEstiblishYearType() {
		 List<Map> list = new ArrayList<>();
         list.addAll(processParamlist("1年内=1-2年=2-3年=3-5年=5-10年=10年以上", "1=2=3=4=5=6"));
		return list;
	}

	public String getEstiblishYear(String key) {
		List<Map> list = getEstiblishYearType();
		String title = null;
		for (int i = 0; i < list.size(); i++) {
			HashMap<?, ?> map = (HashMap<?, ?>) list.get(i);
			if (map.get("key").equals(key)) {
				title = map.get("title").toString();
				break;
			}
		}
		return title;
	}
	public List getRegisteredCapitalType() {
		 return processParamlist("100万以下=100-200万=200-500万=500-1000万=1000万以上", "1=2=3=4=5");
	}
	public String getRegisteredCapital(String key) {
		List<Map> list = getRegisteredCapitalType();
		String title = null;
		for (int i = 0; i < list.size(); i++) {
			HashMap<?, ?> map = (HashMap<?, ?>) list.get(i);
			if (map.get("key").equals(key)) {
				title = map.get("title").toString();
				break;
			}
		}
		return title;
	}
	@Override
	public List getCompanyStatusList() {
		//在业=3|存续=4|迁入=22|迁出=21|已注销=36|被吊销=37
		return processParamlist("在业=存续=吊销=注销=迁出", "3=4=37=36=21");
	}
	public String getCompanyStatus(String key) {
		List<Map> list = getCompanyStatusList();
		String title = null;
		for (int i = 0; i < list.size(); i++) {
			HashMap<?, ?> map = (HashMap<?, ?>) list.get(i);
			if (map.get("key").equals(key)) {
				title = map.get("title").toString();
				break;
			}
		}
		return title;
	}
	@Override
	public List getMoneyList() {
		// TODO Auto-generated method stub
		return processParamlist("人民币=美元=其他", "1=2=3");
	}
	public String getMoney(String key) {
		List<Map> list = getMoneyList();
		String title = null;
		for (int i = 0; i < list.size(); i++) {
			HashMap<?, ?> map = (HashMap<?, ?>) list.get(i);
			if (map.get("key").equals(key)) {
				title = map.get("title").toString();
				break;
			}
		}
		return title;
	}
	@Override
	public List getCompanyTypeList() {
		// TODO Auto-generated method stub
		return processParamlist("有限责任公司=股份有限公司=集体所有制=国有企业=个体工商户=个人独资企业=有限合伙=普通合伙=外商投资企业=港、澳、台=联营企业=私营企业", "1=2=3=4=5=6=7=8=9=10=11=12");
	}
	public String getCompanyType(String key) {
		List<Map> list = getCompanyTypeList();
		String title = null;
		for (int i = 0; i < list.size(); i++) {
			HashMap<?, ?> map = (HashMap<?, ?>) list.get(i);
			if (map.get("key").equals(key)) {
				title = map.get("title").toString();
				break;
			}
		}
		return title;
	}
	@Override
	public List getSocialSecurityList() {
		// TODO Auto-generated method stub
		return processParamlist("小于50人=50-99人=100-499人=500-999人=1000-4999人=5000-9999人=10000人以上", "1=2=3=4=5=6=7");
	}
	public String getSocialSecurity(String key) {
		List<Map> list = getSocialSecurityList();
		String title = null;
		for (int i = 0; i < list.size(); i++) {
			HashMap<?, ?> map = (HashMap<?, ?>) list.get(i);
			if (map.get("key").equals(key)) {
				title = map.get("title").toString();
				break;
			}
		}
		return title;
	}
	@Override
	public List getSortList() {
		// TODO Auto-generated method stub
		return processParamlist("默认排序=成立日期从早到晚=成立日期从晚到早=注册资本从高到低=注册资本从低到高", "1=2=3=4=5");
	}

	@Override
	public String getSortDepict(String key) {
		List<Map> list = getSortList();
		String title = null;
		for (int i = 0; i < list.size(); i++) {
			HashMap<?, ?> map = (HashMap<?, ?>) list.get(i);
			if (map.get("key").equals(key)) {
				title = map.get("title").toString();
				break;
			}
		}
		return title;
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
