package com.linlin.controller;

import com.linlin.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestParamCountroller {

    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + ",password：" + password);
        return "success";
    }

    @RequestMapping("/param")
    public String getParam(
            @RequestParam(value = "name",required = true,defaultValue = "hello") String username ,
             String password,
            @RequestHeader("referer") String referer,
            @CookieValue("JSESSIONID") String jsessionId
    ){
        System.out.println("jsessionId：" + jsessionId );
        System.out.println("referer：" + referer );
        System.out.println("username：" + username + ",password：" + password);
        return "success";
    }

    @RequestMapping("/param/pojo")
    public String getParamBypojo(User user){
        System.out.println(user);
        return "success";
    }

}
