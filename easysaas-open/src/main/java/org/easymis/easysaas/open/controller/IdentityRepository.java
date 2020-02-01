package org.easymis.easysaas.open.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

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
}
