package org.easymis.easysaas.portal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

public class IdentityRepository {
	@Autowired
	private HttpServletRequest request;
    /**
     * 获取 主要的身份特征;
     *
     * @return
     */

    public String getIdentityFeature() {
        return request.getAttribute("memberId").toString();
    }

    public Object districtJson() {
        String districtJson = System.getProperty("districtJson");
        return JSON.parse(districtJson);
    }
    public Object provinceJson() {
        String provinceJson = System.getProperty("provinceJson");
        return JSON.parse(provinceJson);
    }
}
