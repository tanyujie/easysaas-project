package org.easymis.easyicc.common.result;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import lombok.Data;

@Data
@SuppressWarnings({"rawtypes", "unchecked"})
public class PageVO<T> implements Serializable {

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
    /**
     * 当前页的数量
     */
    private int size;
    /**
     * 当前页面第一个元素在数据库中的行号
     */
    private int startRow;
    /**
     * 当前页面最后一个元素在数据库中的行号
     */
    private int endRow;
    /**
     * 前一页
     */
    private int prePage;
    /**
     * 下一页
     */
    private int nextPage;
    /**
     * 是否为第一页
     */
    private boolean isFirstPage = false;
    /**
     * 是否为最后一页
     */
    private boolean isLastPage = false;
    /**
     * 是否有前一页
     */
    private boolean hasPreviousPage = false;
    /**
     * 是否有下一页
     */
    private boolean hasNextPage = false;
    /**
     * 导航页码数
     */
    private int navigatePages;
    /**
     * 所有导航页号
     */
    private int[] navigatepageNums;
    /**
     * 导航条上的第一页
     */
    private int navigateFirstPage;
    /**
     * 导航条上的最后一页
     */
    private int navigateLastPage;
    private List<T> list;
    /**
     * 分页合理化
     */
    private Boolean reasonable;

/*    public PageVO() {
    }*/
	/**
	 * 
	 * <p>
	 * Title: 包装PageVO对象
	 * Description: 包装PageVO对象
	 * </p>
	 * @param list 当前页数据
	 * @param pageNum 当前页数 
	 * @param pageSize 每页条数
	 * @param total 总条数
	 */
    public PageVO(List<T> list,int pageNum,int pageSize,long total) {
        this(list,pageNum,pageSize,total, 8);
    }
    public PageVO(List<T> list, int pageNum,int pageSize,long total,int navigatePages) {
             this.pageNum = pageNum;
             this.pageSize = pageSize;

             calcPages(total);
             this.list = list;
             this.size = list.size();
             this.total = total;
           //由于结果是>startRow的，所以实际的需要+1
             if (this.size == 0) {
                 this.startRow = 0;
                 this.endRow = 0;
             } else {
            	 calculateStartAndEndRow();
                 //this.startRow = page.getStartRow() + 1;
               //计算实际的endRow（最后一页的时候特殊）
                // this.endRow = this.startRow - 1 + this.size;
             }
/*        if (list instanceof Collection) {
            this.pageNum = 1;
            this.pageSize = list.size();

            this.pages = 1;
            this.list = list;
            this.size = list.size();
            this.total = total;
            this.startRow = 0;
            this.endRow = list.size() > 0 ? list.size() - 1 : 0;
        }*/
		if (list instanceof Collection) {
			this.navigatePages = navigatePages;
			// 计算导航页
			calcNavigatepageNums();
			// 计算前后页，第一页，最后一页
			calcPage();
			// 判断页面边界
			judgePageBoudary();
		}
    	
    }

	/**
	 * 计算导航页
	 */
    private void calcNavigatepageNums() {
    	//当总页数小于或等于导航页码数时
        if (pages <= navigatePages) {
            navigatepageNums = new int[pages];
            for (int i = 0; i < pages; i++) {
                navigatepageNums[i] = i + 1;
            }
        } else {//当总页数大于导航页码数时
            navigatepageNums = new int[navigatePages];
            int startNum = pageNum - navigatePages / 2;
            int endNum = pageNum + navigatePages / 2;

            if (startNum < 1) {
                startNum = 1;
              //(最前navigatePages页
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            } else if (endNum > pages) {
                endNum = pages;
              //最后navigatePages页
                for (int i = navigatePages - 1; i >= 0; i--) {
                    navigatepageNums[i] = endNum--;
                }
            } else {
            	//所有中间页
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            }
        }
    }
    /**
     * 计算前后页，第一页，最后一页
     */
    private void calcPage() {
        if (navigatepageNums != null && navigatepageNums.length > 0) {
            navigateFirstPage = navigatepageNums[0];
            navigateLastPage = navigatepageNums[navigatepageNums.length - 1];
            if (pageNum > 1) {
                prePage = pageNum - 1;
            }
            if (pageNum < pages) {
                nextPage = pageNum + 1;
            }
        }
    }

	/**
	 * 计算前后页 pages
	 */
	private void calcPages(long total) {
		this.total = total;
        if (total == -1) {
            pages = 1;
            return;
        }
        if (pageSize > 0) {
            pages = (int) (total / pageSize + ((total % pageSize == 0) ? 0 : 1));
        } else {
            pages = 0;
        }
        //分页合理化，针对不合理的页码自动处理
        if ((reasonable != null && reasonable) && pageNum > pages) {
            pageNum = pages;
            calculateStartAndEndRow();
        }
	}
	/**
     * 计算起止行号
     */
    private void calculateStartAndEndRow() {
        this.startRow = this.pageNum > 0 ? (this.pageNum - 1) * this.pageSize : 0;
        this.endRow = this.startRow + this.pageSize * (this.pageNum > 0 ? 1 : 0);
    }
    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        isFirstPage = pageNum == 1;
        isLastPage = pageNum == pages;
        hasPreviousPage = pageNum > 1;
        hasNextPage = pageNum < pages;
    }
    public boolean isIsLastPage() {
        return isLastPage;
    }

    public void setIsLastPage(boolean isLastPage) {
        this.isLastPage = isLastPage;
    }
/*    public PageVO(long total, int pages, int pageSize, int pageNum) {
        this.total = total;
        this.pages = pages;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }*/
    public String toString() {
        final StringBuilder sb = new StringBuilder("PageInfo{");
        sb.append("pageNum=").append(pageNum);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", size=").append(size);
        sb.append(", startRow=").append(startRow);
        sb.append(", endRow=").append(endRow);
        sb.append(", total=").append(total);
        sb.append(", pages=").append(pages);
        sb.append(", list=").append(list);
        sb.append(", prePage=").append(prePage);
        sb.append(", nextPage=").append(nextPage);
        sb.append(", isFirstPage=").append(isFirstPage);
        sb.append(", isLastPage=").append(isLastPage);
        sb.append(", hasPreviousPage=").append(hasPreviousPage);
        sb.append(", hasNextPage=").append(hasNextPage);
        sb.append(", navigatePages=").append(navigatePages);
        sb.append(", navigateFirstPage=").append(navigateFirstPage);
        sb.append(", navigateLastPage=").append(navigateLastPage);
        sb.append(", navigatepageNums=");
        if (navigatepageNums == null) {
            sb.append("null");
        } else {
            sb.append('[');
            for (int i = 0; i < navigatepageNums.length; ++i) {
                sb.append(i == 0 ? "" : ", ").append(navigatepageNums[i]);
            }
            sb.append(']');
        }
        sb.append('}');
        return sb.toString();
    }
}
