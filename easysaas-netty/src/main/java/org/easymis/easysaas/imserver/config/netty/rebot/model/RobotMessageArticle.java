package org.easymis.easysaas.imserver.config.netty.rebot.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class RobotMessageArticle {
 private String article;//标题
     
     private String source;//来源
     
     private String icon;//新闻图片
     
     private String detailurl;//新闻详情链接
     
     private String name;  //针对菜谱
     
     private String info;//菜谱详情

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDetailurl() {
		return detailurl;
	}

	public void setDetailurl(String detailurl) {
		this.detailurl = detailurl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
     
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	} 
}
