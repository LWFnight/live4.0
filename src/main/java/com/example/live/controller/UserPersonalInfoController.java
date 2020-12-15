package com.example.live.controller;

import com.example.live.pojo.User;
import com.example.live.pojo.UserPersonalInfo;
import com.example.live.service.UserPersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserPersonalInfoController {

    @Autowired
    private UserPersonalInfoService userPersonalInfoService;

    @RequestMapping(value = "findUserPersonalInfo",method = RequestMethod.POST)
    public String findUserPersonalInfo(UserPersonalInfo userPersonalInfo,HttpSession session){
        User user = (User) session.getAttribute("userLoginInfo");
        userPersonalInfo.setUser_id(user.getUser_id());
        userPersonalInfoService.find(userPersonalInfo);
        return "login";
    }

    @RequestMapping(value = "insertUserPersonalInfo",method = RequestMethod.POST)
    public String insertUserPersonalInfo(UserPersonalInfo userPersonalInfo,HttpSession session){
        User user = (User) session.getAttribute("userLoginInfo");
        userPersonalInfo.setUser_id(user.getUser_id());
        userPersonalInfoService.insert(userPersonalInfo);
        return "login";
    }

    @RequestMapping(value = "updateUserPersonalInfo",method = RequestMethod.POST)
    public String updateUserPersonalInfo(UserPersonalInfo userPersonalInfo,HttpSession session){
        User user = (User) session.getAttribute("userLoginInfo");
        userPersonalInfo.setUser_id(user.getUser_id());
        userPersonalInfoService.update(userPersonalInfo);
        return "login";
    }

    @RequestMapping(value = "deleteUserPersonalInfo",method = RequestMethod.GET)
    public String deleteUserPersonalInfo(HttpSession session){
        User user = (User) session.getAttribute("userLoginInfo");
        userPersonalInfoService.deleteById(user.getUser_id());
        return "login";
    }

}
