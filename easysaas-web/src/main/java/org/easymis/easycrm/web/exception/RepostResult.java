package org.easymis.easycrm.web.exception;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;

/**
 * 返回数据
 * 
 * @author tanyujie
 * @email 13551259347@139.com
 * @date 2016年10月27日 下午9:59:27
 */
public class RepostResult extends HashMap<String, Object> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public RepostResult(){
        put("success", false);
        put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
    
    public static RepostResult error(){
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常，请联系管理员");
    }
    
    public static RepostResult error(String msg){
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }
    
    public static RepostResult error(int code,String msg){
        RepostResult r = new RepostResult();
        r.put("code", code);
        r.put("msg", msg);
        r.put("success", false);
        return r;
    }
    
    public static RepostResult ok(String msg){
        RepostResult r = new RepostResult();
        r.put("success", true);
        r.put("msg", msg);
        return r;
    }
    
    public static RepostResult ok(Map<String, Object> map){
        RepostResult r = new RepostResult();
        r.put("success", true);
        r.putAll(map);
        return r;
    }
    
    public static RepostResult ok(){
        return new RepostResult();
    }
    
    @Override
    public RepostResult put(String key,Object value){
        super.put(key, value);
        return this;
    }
}
