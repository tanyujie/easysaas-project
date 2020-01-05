package org.easymis.easycrm.common.utils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 抽象分页类
 * 
 * @author tanyujie
 *
 * @date
 * @version v1.0
 */
public class Page implements Serializable {
    
    private static final long serialVersionUID = 1L;
    /** 默认每一页的分页大小，如果需要自己定义 使用page.setpageSize(分页大小)即可 **/
    public static Integer DEFAULT_PAGE_SIZE = 10;
    /** 对象获取的开始位置，应该总是从1开始 */
    private Integer startIndex;
    /** 每页获取的页大小，默认是15 **/
    private Integer pageSize = DEFAULT_PAGE_SIZE;
    /** 总记录数 记录一共有多少数据 **/
    private Integer totals;
    /** 应该总是从1开始 */
    private Integer currentPage = 1;
    /** 查询的结果 查询后的每一页的分页结果 */
    private List<?> result;
    /** 分页代码 */
    private String paginate;
    /** 总页数 ，总页数等于 总数 除以分页大小 **/
    private Integer totalpages;
    /** layerUi 前段辅助 */
    private int code = 200;
    /** layerUi 错误提示 **/
    private String msg;
    
    public int getCode(){
        return code;
    }
    
    public void setCode(int code){
        this.code = code;
    }
    
    public String getMsg(){
        return msg;
    }
    
    public void setMsg(String msg){
        this.msg = msg;
    }
    
    /** 分页插件初始化,请写在最后一步 要获取数据和数据总数目之后使用 **/
    public void init(){
        setTotalpages(getTotalPages());
    }
    
    

    
    /** 构造方法，只构造空页. */
    public Page(){
        this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList<Object>());
    }
    
    /**
     * 默认构造方法.
     * 
     * @param startIndex
     *            本页数据在数据库中的起始位置
     * @param totals
     *            数据库中总记录条数
     * @param pageSize
     *            本页容量
     * @param result
     *            本页包含的数据 by zhangdan
     */
    public Page(Integer startIndex,Integer totals,Integer pageSize,List<?> result){
        this.pageSize = pageSize;
        this.startIndex = startIndex;
        this.totals = totals;
        this.result = result;
    }
    
    /**
     * 获取任一页第一条数据在数据集的位置.
     * 
     * @param pageNo
     *            从1开始的页号
     * @param pageSize
     *            每页记录条数
     * @return 该页第一条数据
     */
    public static Integer getStartOfPage(Integer pageNo,Integer pageSize){
        return (pageNo - 1) * pageSize;
    }
    
    public Integer getTotalpages(){
        return totalpages;
    }
    
    public void setTotalpages(Integer totalpages){
        this.totalpages = totalpages;
    }
    
    @Override
    public String toString(){
        return "Page [getCurrentPage()=" + getCurrentPage() + ", getPageSize()=" + getPageSize() + ", getTotalPages()=" + getTotalPages() + ", getResult()=" + getResult() + ", getStartIndex()=" + getStartIndex() + ", getTotals()=" + getTotals() + "]";
    }
    
    public Integer getCurrentPage(){
        return currentPage;
    }
    
    public void setCurrentPage(Integer currentPage){
        if (currentPage == null || currentPage < 1) {
            this.currentPage = 1;
            return;
        }
        this.currentPage = currentPage;
        Integer start = getPageSize() * (currentPage - 1) + 1;
        setStartIndex(start);
    }
    
    public String getPaginate(){
        return paginate;
    }
    
    public void setPaginate(String paginate){
        this.paginate = StringUtils.trimToEmpty(paginate);
    }
    
    public Integer getPageSize(){
        return pageSize;
    }
    
    public void setPageSize(Integer pageSize){
        this.pageSize = pageSize;
    }
    
    /** 返回分页数 **/
    public Integer getTotalPages(){
        if (totals / this.pageSize < 1) {
            return 1;
        }
        else {
            Integer totalPages = this.totals / this.pageSize;
            if (this.totals % this.pageSize != 0) {
                totalPages += 1;
            }
            return totalPages;
        }
    }
    
    public List<?> getResult(){
        return result;
    }
    
    public void setResult(List<?> result){
        this.result = result;
    }
    
    public Integer getStartIndex(){
        return startIndex;
    }
    
    /**
     * 查询的开始位置总是从1开始.
     * 
     * @param startIndex
     */
    public void setStartIndex(Integer startIndex){
        this.startIndex = startIndex;
        if (this.startIndex <= 0) {
            this.startIndex = 1;
        }
    }
    
    public Integer getTotals(){
        return totals;
    }
    
    public void setTotals(Integer totals){
        this.totals = totals;
    }
}
