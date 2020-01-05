package org.easymis.easysaas.core.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.alibaba.fastjson.JSONObject;

/**
 * @author zh
 * @title: SysServletContextListener
 * @projectName companydata
 * @description: 加载全局数据
 * @date 2019/9/12 10:44
 */
public class SysServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.setProperty("districtJson",this.districtJson().toString());
		System.setProperty("categoryThreeLevelJson",this.categoryThreeLevelJson().toString());

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

	private Object districtJson() {
		Object obj = new Object();
		try {
			obj = readFile("paramDictJson/DistrictV2.json");

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
