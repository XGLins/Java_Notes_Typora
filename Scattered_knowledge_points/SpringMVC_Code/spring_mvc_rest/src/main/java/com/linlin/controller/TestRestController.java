package com.linlin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 查询所有的用户信息-->/user-->get
 * 根据id查询用户信息-->/user/1-->get
 * 添加用户信息-->/user-->post
 * 修改用户信息-->/user-->update
 * 删除用户信息-->/user/1-->delete
 * */
@Controller
public class TestRestController {

    //<a th:href="@{/user}">查询所有的用户信息</a>
//    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping("/user")
    public String getAllUser(){
        System.out.println("查询所有的用户信息-->/user-->get");
        return "success";
    }

    //<a th:href="@{/user/1}">查询id为1的用户信息</a>
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    @GetMapping("/user/{id}")
    public String getUsrById(@PathVariable("id") Integer id) {
        System.out.println("根据id查询用户信息-->/user/" + id + "-->get");
        return "success";
    }

    /*<form th:href="@{/user}" method="post">
        <input type="submit" value="添加用户信息">
    </form>*/
//    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public String insertUser(){
        System.out.println("添加用户信息-->/user-->post");
        return "success";
    }

    /*<form th:action="@{/user}" method="post">
    <input type="hidden" name="_method" value="put">
    <input type="submit" value="修改用户信息">
    </form>*/
//    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    @PutMapping("/user")
    public String updatetUser(){
        System.out.println("修改用户信息-->/user-->update");
        return "success";
    }

//    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    @DeleteMapping("/user/{id}")
    public String deletetUser(@PathVariable("id") Integer id){
        System.out.println("删除用户信息-->/user/"+ id + "-->delete");
        return "success";
    }



}
