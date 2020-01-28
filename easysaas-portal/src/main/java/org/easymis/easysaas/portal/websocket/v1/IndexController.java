package org.easymis.easysaas.portal.websocket.v1;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 */
@Controller
public class IndexController {

    @RequestMapping(value = "toIndex")
    public ModelAndView toIndex(){
        return new ModelAndView("index");
    }

    @RequestMapping(value = "test")
    public void test(HttpServletRequest request, HttpServletResponse response){

        System.out.println("kkk.....");
        try {
            response.getWriter().print("ok...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
