package org.easymis.easyicc.common.jackson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/***
 * 需引用fastjson-1.1.37.jar
 * json解析
 *
 */
public class JsonUtil {

	/***
	 * @param json 要解析的json串
	 * @param key 要取的key
	 * @return 数组
	 */
	public static List<String> getList(String json, String key){
		List<String> list=new ArrayList<String>();
		JSONArray jsonArray= JSONObject.parseObject(json).getJSONArray(key);
		for (Object object : jsonArray) {
			list.add(object.toString());
		}		
		return list;
	}


	/***
	 * @param json 要解析的json串
	 * @param key 要取的key
	 * @param separator key之间的分隔符
	 * @return 数组
	 */
	public static List<String> getList(String json, String key, String separator){
		List<String> list=new ArrayList<String>();
		json=getString(json, key,separator);

		JSONArray jsonArray= JSONObject.parseArray(json);
		for (Object object : jsonArray) {
			list.add(object.toString());
		}

		return list;
	}

	/***
	 * @param json 要解析的json串
	 * @param key 要取的key
	 * @return 返回一个String
	 */
	public static String getString(String json, String key){
		return JSONObject.parseObject(json).getString(key);
	}

	/***
	 * @param json 要解析的json串
	 * @param key 要取的key
	 * @param separator key之间的分隔符
	 * @return 返回一个String
	 */
	public static String getString(String json, String key, String separator){
		String keyArray[]=StringUtils.split(key,separator);

		if(keyArray==null) return null;

		for (String string : keyArray) {
			json=getString(json, string);
		}
		return json;
	}


	/***
	 * @param json 要解析的json串
	 * @param key 要取的key
	 * @return 返回一个Integer
	 */
	public static Integer getInteger(String json, String key){
		return JSONObject.parseObject(json).getInteger(key);
	}


	/***
	 * @param json 要解析的json串
	 * @param key 要取的key
	 * @param separator key之间的分隔符
	 * @return 返回一个Integer
	 */
	public static Integer getInteger(String json, String key, String separator){
		String keyArray[]=StringUtils.split(key,separator);

		if(keyArray==null) return null;

		for (String string : keyArray) {
			json=getString(json, string);
		}
		return Integer.valueOf(json);
	}


	/***
	 * @param json 要解析的json串
	 * @param key 要取的key
	 * @return 返回一个Long
	 */
	public static Long getLong(String json, String key){
		return JSONObject.parseObject(json).getLong(key);
	}

	/***
	 * @param json 要解析的json串
	 * @param key 要取的key
	 * @param separator key之间的分隔符
	 * @return 返回一个Long
	 */
	public static Long getLong(String json, String key, String separator){
		String keyArray[]= StringUtils.split(key,separator);

		if(keyArray==null) return null;

		for (String string : keyArray) {
			json=getString(json, string);
		}
		return Long.valueOf(json);
	}

	/***
	 * @param json 要解析的json串
	 * @param key 要取的key
	 * @return 返回一个Double
	 */
	public static Double getDouble(String json, String key){
		return JSONObject.parseObject(json).getDouble(key);
	}


	/***
	 * @param json 要解析的json串
	 * @param key 要取的key
	 * @param separator key之间的分隔符
	 * @return 返回一个Double
	 */
	public static Double getDouble(String json, String key, String separator){
		String keyArray[]=StringUtils.split(key,separator);

		if(keyArray==null) return null;

		for (String string : keyArray) {
			json=getString(json, string);
		}
		return Double.valueOf(json);
	}


}
