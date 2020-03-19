package org.easymis.easyicc.common.parameter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;

/**
 * 
　 * <p>Title: 通用分页插件</p>
　 * <p>Description: </p>
　 * @author 谭宇杰
　 * @date 2020年2月21日
 */
public class BasePageRequest<T> {
    /**
     * 页数 默认1
     */
    private int pageNum=1;
    /**
     * 每页条数 默认10
     */
    private int pageSize=10;
    /**
     * 数据对象
     */
    private T data;
    /**
     * 分页类型
     */
    private Integer pageType;

    private JSONObject jsonObject;


    public BasePageRequest() {
		super();
	}

	@Deprecated
    public BasePageRequest(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public BasePageRequest(Kv kv,Class<T> clazz) {
        this(kv.toJson(),clazz);
    }

    public BasePageRequest(String rowData,Class<T> clazz) {
        JSONObject jsonObject = JSON.parseObject(rowData);
        this.setJsonObject(jsonObject);
        this.setPageNum(getIntAndRemove("pageNum", 1));
        this.setPageSize(getIntAndRemove("pageSize", 10));
        this.setPageType(getIntAndRemove("pageType", 1));
        if(clazz!=null){
            this.setData(jsonObject.toJavaObject(clazz));
        }
    }

    public int getPageNum() {
        return pageNum;
    }

    private void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    private void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public BasePageRequest<T> setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getPageType() {
        return pageType;
    }

    public BasePageRequest<T> setPageType(Integer pageType) {
        this.pageType = pageType;
        return this;
    }

    private Integer getIntAndRemove(String key, Object defaultValue) {
        if (this.getJsonObject() == null) {
            throw new RuntimeException("jsonObject cannot be null");
        }
        Object obj = jsonObject.getOrDefault(key, defaultValue);
        jsonObject.remove(key);
        return TypeUtils.castToInt(obj);
    }
}

