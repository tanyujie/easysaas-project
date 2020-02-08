package org.easymis.easysaas.portal.entitys.vo;

import java.io.Serializable;
import java.util.List;

import org.easymis.easysaas.common.result.PageVO;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class DishonestPageData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object info;
	private PageVO pageInfo;
	private Long totalPerson;
	private Long totalCompany;// 公司数量
	private String totalPersonDepict;
	private String totalCompanyDepict;// 公司数量

	public String getTotalPersonDepict() {
		if (totalPerson ==null)
			return "0";
		else if (totalPerson > 999)
			return "999+";
		else
			return totalPerson.toString();
	}

	public String getTotalCompanyDepict() {
		if (totalCompany ==null)
			return "0";
		else if (totalCompany > 999)
			return "999+";
		else
			return totalCompany.toString();
	}


}
