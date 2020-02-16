package org.easymis.easysaas.portal.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.easymis.easysaas.portal.entitys.mybatis.dto.IdentityCardAddress;
import org.easymis.easysaas.portal.entitys.vo.CategoryThreeLevelVo;

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
    public static List<CategoryThreeLevelVo> getCategoryFirstList(){
    	List<CategoryThreeLevelVo> categoryFirstList = new ArrayList<CategoryThreeLevelVo>();
        JSONArray cateArray= JSON.parseArray(System.getProperty("categoryThreeLevelJson"));
    	for (int i = 0; i < cateArray.size(); i++) {    
   		//"cateName":"公共管理、社会保障和社会组织","cateCode":"","nickName":"社会组织"
    		CategoryThreeLevelVo vo = new CategoryThreeLevelVo();
    		vo.setName(cateArray.getJSONObject(i).getString("cateName"));
    		vo.setNickName(cateArray.getJSONObject(i).getString("nickName"));
    		categoryFirstList.add(vo);
    	}
    	return categoryFirstList;
    }
    public static List<CategoryThreeLevelVo> getCategorySecondList(String name){
    	List<CategoryThreeLevelVo> secondFirstList = new ArrayList<CategoryThreeLevelVo>();
        JSONArray cateArray= JSON.parseArray(System.getProperty("categoryThreeLevelJson"));
    	for (int i = 0; i < cateArray.size(); i++) {    
       		JSONArray secondArray=cateArray.getJSONObject(i).getJSONArray("categoryList");
    		if(secondArray!=null&&secondArray.size()>0&&cateArray.getJSONObject(i).getString("cateName").equals(name)) {
        		for(int j=0;j<secondArray.size();j++)
				{
					CategoryThreeLevelVo vo = new CategoryThreeLevelVo();
					vo.setName(secondArray.getJSONObject(j).getString("cateName"));
					vo.setNickName(secondArray.getJSONObject(j).getString("nickName"));
					secondFirstList.add(vo);

				}
            		
    		}

    	}
    	return secondFirstList;
    }
    public static List<CategoryThreeLevelVo> getCategoryThirdList(String name){
    	List<CategoryThreeLevelVo> thirdList = new ArrayList<CategoryThreeLevelVo>();
        JSONArray cateArray= JSON.parseArray(System.getProperty("categoryThreeLevelJson"));
    	for (int i = 0; i < cateArray.size(); i++) {    
       		JSONArray secondArray=cateArray.getJSONObject(i).getJSONArray("categoryList");
    		if(secondArray!=null&&secondArray.size()>0) {
        		for(int j=0;j<secondArray.size();j++)
				{
        	  		JSONArray thirdArray=cateArray.getJSONObject(i).getJSONArray("categoryList");
            		if(thirdArray!=null&&thirdArray.size()>0&&secondArray.getJSONObject(j).getString("cateName").equals(name)) {
            			for(int k=0;k<thirdArray.size();k++)
        				{
        					CategoryThreeLevelVo vo = new CategoryThreeLevelVo();
        					vo.setName(thirdArray.getJSONObject(k).getString("cateName"));
        					vo.setNickName(thirdArray.getJSONObject(k).getString("nickName"));
        					thirdList.add(vo);
        				}
            		}


				}
            		
    		}

    	}
    	return thirdList;
    }
    String convertCategorySecond(String name){
        JSONArray cateArray= JSON.parseArray(System.getProperty("categoryThreeLevelJson"));
        HashMap<String,String> cateSecondMap= new HashMap<String, String>();
        JSONArray cateSecondArray=new JSONArray();
    	for (int i = 0; i < cateArray.size(); i++) {    
   		JSONArray secondArray=cateArray.getJSONObject(i).getJSONArray("categoryList");
    		if(secondArray!=null&&secondArray.size()>0) {
        		for(int j=0;j<secondArray.size();j++)
        		{
            		cateSecondArray.add(secondArray.getJSONObject(j));
        		}
            		
    		}

    	}
		for (int j = 0; j < cateSecondArray.size(); j++) {
			cateSecondMap.put(cateSecondArray.getJSONObject(j).getString("cateName"),cateSecondArray.getJSONObject(j).getString("nickName"));
		}
		if (cateSecondMap.get(name) != null)
			return cateSecondMap.get(name);
		else
			return name;
    }
}
