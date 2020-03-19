package org.easymis.easyicc.common.result;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class PageData implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object info;
    private PageVO pageInfo;
    private Object group;
    private double totalCompanyCount;//公司数量
}
