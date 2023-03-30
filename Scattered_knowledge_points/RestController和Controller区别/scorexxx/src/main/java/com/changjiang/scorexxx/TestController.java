package com.changjiang.scorexxx;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class TestController {

    /**
     * java框架测试方法1
     * */
    @RequestMapping("hello1")
    @ResponseBody
    public String test01(){
        return "index";
    }


    /**
     * java框架测试方法2
     * */
    @RequestMapping("hello2")
    public String test02(){
//        model.addAttribute("message", "你好，世界！");
        return "hello2";
    }



}
