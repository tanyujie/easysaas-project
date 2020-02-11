package org.easymis.easysaas.portal.utils;

import java.util.ArrayList;
import java.util.List;

import org.easymis.easysaas.portal.entitys.mybatis.dto.IdentityCardAddress;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class DistrictUtil {
    private Object categoryThreeLevelJson() {
        String districtJson = System.getProperty("categoryThreeLevelJson");
        return JSON.parse(districtJson);
    }
    public static List<IdentityCardAddress> getProvinceList(){
        JSONArray districtArray= JSON.parseArray(System.getProperty("provinceJson"));
        ArrayList<IdentityCardAddress> provinceList = new ArrayList<IdentityCardAddress>();
    	for (int i = 0; i < districtArray.size(); i++) {    
    		JSONObject dataObject=districtArray.getJSONObject(i);
    		if(dataObject.getString("parentCode")!=null&&dataObject.getString("parentCode").equals("086")) {
    			provinceList.add(dataObject.toJavaObject(IdentityCardAddress.class));
    		}
    	}
    	return provinceList;
    }
    private static List<IdentityCardAddress> getCityList(){
        JSONArray districtArray= JSON.parseArray(System.getProperty("provinceJson"));
        ArrayList<IdentityCardAddress> cityList = new ArrayList<IdentityCardAddress>();
    	for (int i = 0; i < districtArray.size(); i++) {    
    		JSONObject dataObject=districtArray.getJSONObject(i);
    		if(dataObject.getString("parentCode")!=null&&dataObject.getString("parentCode").equals("086")) {    			
    			cityList.addAll(getCityList(dataObject.toJavaObject(IdentityCardAddress.class).getBase()));
    		}
    	}
    	return cityList;
    }
    public static List<IdentityCardAddress> getCityList(String base){
        JSONArray districtArray= JSON.parseArray(System.getProperty("provinceJson"));
        IdentityCardAddress province=getProvince(base);
        ArrayList<IdentityCardAddress> provinceList = new ArrayList<IdentityCardAddress>();
    	for (int i = 0; i < districtArray.size(); i++) {    
    		JSONObject dataObject=districtArray.getJSONObject(i);
    		if(dataObject.getString("parentCode")!=null&&dataObject.getString("parentCode").equals(province.getCode())) {
    			provinceList.add(dataObject.toJavaObject(IdentityCardAddress.class));
    		}
    	}
    	return provinceList;
    }
    public static List<IdentityCardAddress> getDistrictList(String cityCode){
        JSONArray districtArray= JSON.parseArray(System.getProperty("provinceJson"));
        
        IdentityCardAddress city=getCity(cityCode);
        if(null==city) {
        	city=getCityList(cityCode).get(0);
        }        	
        ArrayList<IdentityCardAddress> districtList = new ArrayList<IdentityCardAddress>();
    	for (int i = 0; i < districtArray.size(); i++) {    
    		JSONObject dataObject=districtArray.getJSONObject(i);
    		if(dataObject.getString("parentCode")!=null&&dataObject.getString("parentCode").equals(city.getCode())) {
    			districtList.add(dataObject.toJavaObject(IdentityCardAddress.class));
    		}
    	}
    	return districtList;
    }
   public static IdentityCardAddress getProvince(String base) {
	   List<IdentityCardAddress> provinceList=getProvinceList();
	   IdentityCardAddress province=null;
	   for(int i=0;i<provinceList.size();i++) {
		   province=provinceList.get(i);
		   if(province.getBase().equals(base))
			   break;
	   }
	return province;
   }

	public static IdentityCardAddress getCity(String cityCode) {
		List<IdentityCardAddress> cityList = getCityList();
		IdentityCardAddress city = null;
		for (int i = 0; i < cityList.size(); i++) {
			if (cityList.get(i).getCode().equals(cityCode)) {
				city = cityList.get(i);
				break;
			}
		}
		return city;
	}
	public static IdentityCardAddress getDistrict(String districtCode) {
		JSONArray districtArray= JSON.parseArray(System.getProperty("provinceJson"));	
		IdentityCardAddress district = null;
    	for (int i = 0; i < districtArray.size(); i++) {    
    		JSONObject dataObject=districtArray.getJSONObject(i);
    		if(dataObject.getString("code").equals(districtCode)) {
    			district=dataObject.toJavaObject(IdentityCardAddress.class);
    			break;
    		}
    	}
		return district;
	}
}
