package org.easymis.easysaas.common.result;

import java.io.Serializable;
import java.util.Map;

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
    private PageVO page;
    private Object group;
    private Map<String, Object> screenGroupData; //2019-10-23号 wyy新增可视化大屏分组统计数据
    private GaodeAoiBean gaodeBean;
    private double totalCompanyCount;//公司数量
    private Map<String, Object> typeGroupData;
    private Map<String, Object> buildGroupData;//楼栋公司分组
}
