package com.example.live.controller;

import com.example.live.pojo.User;
import com.example.live.service.UserService;
import com.example.live.utils.ImgToJson;
import com.example.live.utils.SendEmail;
import com.example.live.utils.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes(value = {"users","userLoginInfo"})
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String main(User userdto,Model model){
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(User userdto,Model model){
        List<User> users = new ArrayList<>();
//        System.out.println(userdto.getUser_id()+"\t"+userdto.getEmail()+"\t"+userdto.getPhone()+"\t"+userdto.getPassword());
        users = userService.findUsers(userdto);
        if (users.size()!=0 && users.get(0).getPassword().equals(userdto.getPassword())){
            System.out.println(users.get(0).getUser_id());
            model.addAttribute("userLoginInfo",users.get(0));
            return "hello";
        }
        return "login";//返回登录页面
    }

    @RequestMapping(value = "findUsers",method = RequestMethod.GET)
    public String findUsers(User userdto,Model model){
        List<User> users = new ArrayList<>();
        users = userService.findUsers(userdto);
        model.addAttribute("users",users);
        for (User user : users) {
            System.out.println(user.getUser_id()+"\t"+user.getName()+"\t"+user.getGender()+"\t"+user.getEmail()+"\t"+user.getPassword());
        }
        return "hello";
    }

    @RequestMapping(value = "findUserPersonalInfo",method = RequestMethod.GET)
    public String findUserPersonalInfo(User userdto){
        userdto.setUser_id(1);
        User user = new User();
        user = userService.findUserPersonalInfo(userdto);
        System.out.println(user.getUser_id()+"\t"+user.getName()+"\t"+user.getGender()+"\t"+user.getEmail()+"\t"+user.getPhone()+"\t"+
                user.getUserPersonalInfo().getAge()+"\t"+user.getUserPersonalInfo().getHead_portrait()+"\t"+user.getUserPersonalInfo().getHobby()+"\t"+user.getUserPersonalInfo().getJob());
        return "hello";
    }

    @RequestMapping(value = "insertUser",method = RequestMethod.GET)
    public String insertUser(User userdto){
        userdto = new User("test","男","123233@qq.com","123",4,"123423");
        userService.insertUser(userdto);
        return "redirect:/findUsers";
    }

    @RequestMapping(value = "deleteUserByUserId",method = RequestMethod.GET)
    public String deleteUserByUserId(User userdto){
        userService.deleteUserByUserId(3);
        return "redirect:/findUsers";
    }

    @RequestMapping(value = "updateUser",method = RequestMethod.GET)
    public String updateUser(User userdto){
        userdto = new User(3,"testUpdate2","女","test2@163.com","321",4,"111");
        userService.updateUser(userdto);
        return "redirect:/findUsers";
    }

    @RequestMapping(value = "send",method = RequestMethod.GET)
    public String sendEmail(String email){
        try {
            //生成验证码
            VerificationCode code = new VerificationCode();
            StringBuffer randomCode = new StringBuffer();
            randomCode = code.VerificationCodeGenerator();
            //发送验证邮件
            System.out.println(email);
            SendEmail emailCode = new SendEmail();
            emailCode.sendEmail("wo319039695@163.com",randomCode);//sendEmail(收件人邮箱，验证码)
            return "login";
        }catch (Exception e){
            return "login";
        }
    }

}
