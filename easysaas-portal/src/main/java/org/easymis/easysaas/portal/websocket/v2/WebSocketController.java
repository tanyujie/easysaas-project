package org.easymis.easysaas.portal.websocket.v2;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;  
  
/** 
 * WebSocket服务器端推送消息示例Controller 
 *  
 * @author wallimn，http://wallimn.iteye.com 
 * 
 */  
@RestController  
@RequestMapping("/api/ws")  
public class WebSocketController {  
    @RequestMapping(value = "toIndexV2")
    public ModelAndView toIndex(){
        return new ModelAndView("toIndexV2");
    }
    @RequestMapping(value="/sendAll", method=RequestMethod.GET)  
    /** 
     * 群发消息内容 
     * @param message 
     * @return 
     */  
    String sendAllMessage(@RequestParam(required=true) String message){  
        try {  
            WebSocketServer.BroadCastInfo(message);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return "ok";  
    }  
    @RequestMapping(value="/sendOne", method=RequestMethod.GET)  
    /** 
     * 指定会话ID发消息 
     * @param message 消息内容 
     * @param id 连接会话ID 
     * @return 
     */  
    String sendOneMessage(@RequestParam(required=true) String message,@RequestParam(required=true) String id){  
        try {  
            WebSocketServer.SendMessage(id,message);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return "ok";  
    }  
}  