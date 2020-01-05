package org.easymis.easycrm.mobile.utils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.ModelMap;

/** 验证码工具 @author tanyujie **/
public class VrifyCodeUtil {
    
    public static final String PARAMETERNAME = "vrifyCode";
    
    private VrifyCodeUtil(){
    }
    
    /**
     * 验证码校验逻辑，传入的验证码参数名必须叫 vrifyCode
     * 
     * @param httpServletRequest
     * @param model
     * @return
     */
    public static boolean checkvrifyCode(HttpServletRequest httpServletRequest,ModelMap model){
        HttpSession session = httpServletRequest.getSession();
        String captchaId = (String) httpServletRequest.getSession().getAttribute(PARAMETERNAME);
        String parameter = httpServletRequest.getParameter(PARAMETERNAME);
        if (parameter == null) {
            // cleanSession(session);
            return false;
        }
        if (captchaId == null) {
            model.addAttribute("error", "验证码已过期！");
            return false;
        }
        if (!captchaId.toUpperCase().equals(parameter.toUpperCase())) {
            model.addAttribute("error", "验证码不正确！");
            cleanSession(session);
            return false;
        }
        cleanSession(session);
        return true;
    }
    
    /**
     * @param vrifyCode
     *            验证码
     * @param httpServletRequest
     * @return
     */
    public static boolean checkvrifyCode(String vrifyCode,HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        String captchaId = (String) httpServletRequest.getSession().getAttribute(PARAMETERNAME);
        if (vrifyCode == null) {
            // cleanSession(session);
            return false;
        }
        if (captchaId == null) {
            return false;
        }
        if (!captchaId.toUpperCase().equals(vrifyCode)) {
            cleanSession(session);
            return false;
        }
        cleanSession(session);
        return true;
    }
    
    /**
     * @param vrifyCode
     *            验证码
     * @param session
     * @return
     */
    public static boolean checkvrifyCode(String vrifyCode,HttpSession session){
        String captchaId = (String) session.getAttribute(PARAMETERNAME);
        if (vrifyCode == null) {
            // cleanSession(session);
            return false;
        }
        if (captchaId == null) {
            return false;
        }
        if (!captchaId.equals(vrifyCode)) {
            cleanSession(session);
            return false;
        }
        cleanSession(session);
        return true;
    }
    
    /**
     * 验证是验证码 否正确后清除 验证码会话 防止重复利用攻击API
     * 
     * @param session
     */
    private static void cleanSession(HttpSession session){
        session.removeAttribute(PARAMETERNAME);
    }
}
