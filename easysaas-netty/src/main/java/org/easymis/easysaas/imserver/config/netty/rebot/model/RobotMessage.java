package org.easymis.easysaas.imserver.config.netty.rebot.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class RobotMessage {
	private Integer code; // 100000 文本 200000 链接 302000 新闻 308000 菜谱

	private String text;

	private String url;

	private String list;

	private RobotMessageArticle subList;

	public RobotMessageArticle getSubList() {
		return subList;
	}

	public void setSubList(RobotMessageArticle subList) {
		this.subList = subList;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
