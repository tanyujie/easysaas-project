package org.easymis.easyicc.domain.entity;

import java.util.Set;

import lombok.Data;
@Data
public class VisitorColSelf {
	  private Integer id;
	  private VisitorCol visitorCol;
	  private int companyId;
	  private String selfText = "";
	  private int colType;
	  private int hidden;
	  private int sortIndex;
	  private int editable = 1;
	  private String referTable;
	  private Set<VisitorColSelfItem> items;
	  private int required = 0;
	  private String formatter;
}
