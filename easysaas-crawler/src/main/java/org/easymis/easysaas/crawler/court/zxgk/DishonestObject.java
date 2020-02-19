package org.easymis.easysaas.crawler.court.zxgk;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.alibaba.fastjson.JSONObject;

public class DishonestObject {
	 public static void main(String args[]){     
		    
         //这个就是博客中的java反射的url     
		 for(int i=705000000;i<705190506;i++) {
			   String url=  "http://zxgk.court.gov.cn/disDetail?id="+i;
		         
		        try {
		        //先获得的是整个页面的html标签页面
		         Document doc = Jsoup.connect(url).get();
		         Element body = doc.body();
		         JSONObject json = JSONObject.parseObject(body.text());
		         System.out.println(json);
		       
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		 }
  
 }
}
