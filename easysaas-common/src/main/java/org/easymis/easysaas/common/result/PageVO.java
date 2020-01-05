package org.easymis.easysaas.common.result;


import lombok.Data;

import java.io.Serializable;

@Data
public class PageVO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 总条数
     */
    private long total = 0;

    /**
     * 总页数
     */
    private int pages = 0;

    /**
     * 每页条数
     */
    private int pageSize = 0;

    /**
     * 当前页数
     */
    private int pageNum = 0;

    public PageVO() {
    }

    public PageVO(long total, int pages, int pageSize, int pageNum) {
        this.total = total;
        this.pages = pages;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }
}
