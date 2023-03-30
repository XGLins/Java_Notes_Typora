package com.linlin.ssm.controller;

import com.linlin.ssm.pojo.User;
import com.linlin.ssm.service.UserInfoService;
import com.linlin.ssm.service.UserService;
import com.linlin.ssm.util.Email;
import com.linlin.ssm.util.ModelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Controller 控制层组件
 * 对用户表的操作
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 登录判断
     * */
    @RequestMapping("/user/golog")
    @ResponseBody
    public ModelView log(User user) {
        ModelView modelView = new ModelView();
        User u = userService.findOne(user);
        if (u != null) {
            modelView.setCode(200);
            modelView.setMsg("登录成功");
        } else {
            modelView.setCode(500);
            modelView.setMsg("登录失败");
        }
        return modelView;
    }

    /**
     * 注册判断
     * */
    @PostMapping("/user/goreg")
    @ResponseBody
    public ModelView reg(User user) {
        ModelView modelView = new ModelView();
        User u = userService.checkReg(user.getUserName());
        if (u==null) {
            user.setCreateTime(new Date());
            int i = userService.addOne(user);
            if (i > 0){
                modelView.setCode(200);
                modelView.setMsg("添加成功");
            }else {
                modelView.setCode(500);
                modelView.setMsg("添加失败");
            }
        }else {
            modelView.setCode(500);
            modelView.setMsg("当前数据口中已经存在该账号");
        }
        return modelView;
    }

    /**
     * 通过邮箱发送验证码
     * */
    @RequestMapping("/user/goEmail")
    @ResponseBody
    public ModelView email(String email)  {
        Email emailone = new Email();
        String emil = null;
        try {
            emil = emailone.emil(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelView(200,"邮件发送成功",emil);
    }

}
