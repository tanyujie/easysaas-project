package org.easymis.easyicc.domain.entity;

import java.util.Date;

import lombok.Data;

@Data
public class VisitorInfo {
	  private String id;
	  private String visitorStaticId;
	  private String globalStaticId = "";
	  private Integer companyId;
	  private String name;
	  private String tel;
	  private String email;
	  private String note;
	  private String reseveKey;
	  private String sex;
	  private String repName;
	  private String mobile;
	  private String qq;
	  private String msn;
	  private String url;
	  private String area;
	  private String companyName;
	  private String userId;
	  private Date createTime;
	  private String extColumn1;
	  private String extColumn2;
	  private String extColumn3;
	  private String extColumn4;
	  private String extColumn5;
	  private String extColumn6;
	  private String extColumn7;
	  private String extColumn8;
	  private String extColumn9;
	  private String extColumn10;
	  private String searchEngine;
	  private String refer;
	  private String keyWord;
	  private String chatURL;
	  private String searchHost;
	  private String spreadFlag;
	  private String firstURL;
	  private int promotionId = 0;
	  private String type;
	  private String createUserId;
	  private String editUserId;
	  private Date editTime;
	  private int auto = 0;
	  private Integer chatId;
	  private String country;
	  private String province;
	  private String city;
	  private Integer siteId;
	  private String deviceType;
	  private String clickText;
	  private String userAgent;
	  private String bdUserId;
	  private String bdCampaiginId;
	  private String bdAdgroundId;
	  private String bdKeywordId;
	  private String bdCreativeId;
	  private Integer ntagId;
}
