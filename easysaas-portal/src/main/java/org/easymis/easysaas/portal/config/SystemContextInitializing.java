package org.easymis.easysaas.portal.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
@Service
public class SystemContextInitializing implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("provinceJson",this.provinceJson().toString());
		System.setProperty("categoryThreeLevelJson",this.categoryThreeLevelJson().toString());
	}
	private Object provinceJson() {
		Object obj = new Object();
		try {
			obj = readFile("paramDictJson/districtJson.json");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	private Object categoryThreeLevelJson() {
		Object obj = new Object();
		try {
			obj = readFile("paramDictJson/CategoryThreeLevel.json");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	private  Object readFile(String filePath) throws IOException {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filePath);
		String totalLine = "";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
			String line;
			while ((line = br.readLine()) != null) {
				totalLine += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Object parse = JSONObject.parse(totalLine);
		return parse;
	}
}
