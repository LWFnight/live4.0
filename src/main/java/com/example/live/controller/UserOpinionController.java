package com.example.live.controller;

import com.example.live.pojo.User;
import com.example.live.pojo.UserOpinion;
import com.example.live.service.UserOpinionService;
import com.example.live.utils.ImgToJson;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes(value = {"userOpinions","testPictureUrl"})
public class UserOpinionController {

    @Autowired
    private UserOpinionService userOpinionService;

    public String uoloadPath="D:\\live\\pictures";

    @RequestMapping(value = "insertOpinion",method = RequestMethod.POST)
    public String insertOpinion(UserOpinion userOpinion, HttpSession session){
        //将图片转为二进制格式的数据
        ImgToJson img = new ImgToJson();
        File file = new File(uoloadPath);
        String fileName = userOpinion.getPicture();
        File uploadFile=new File(file+File.separator+fileName);
        System.out.println(userOpinion.getOpinion()+"\t"+userOpinion.getPicture()+"\t"+uploadFile.toString());
        String imgData = img.getImageBinary(uploadFile.toString());
        //将构造对象存储数据，并持久化
        Long time = System.currentTimeMillis();
        String pictureUrl = "D:\\live\\imgs\\UserOpinion\\"+time.toString()+".jpg";
        User user = (User) session.getAttribute("userLoginInfo");
        userOpinion.setUser_id(user.getUser_id());
        userOpinion.setPicture(imgData);
        userOpinion.setPictureUrl(pictureUrl);
//        System.out.println(pictureName);
        userOpinionService.insert(userOpinion);
        return "login";
    }

    @RequestMapping(value = "findOpinion",method = RequestMethod.GET)
    public String findOpinion(UserOpinion userOpinionDto,HttpSession session,Model model){
        User user = new User();
        user = (User) session.getAttribute("userLoginInfo");
        userOpinionDto.setUser_id(user.getUser_id());
        List<UserOpinion> userOpinions = new ArrayList<>();
        userOpinions = userOpinionService.find(userOpinionDto);
        //图片转换格式
        ImgToJson img = new ImgToJson();
        for (UserOpinion userOpinion : userOpinions) {
            String savePath = userOpinion.getPictureUrl();
            System.out.println(savePath);
            img.base64StringToImage(savePath,userOpinion.getPicture());
        }
        model.addAttribute("userOpinions",userOpinions);
        model.addAttribute("testPictureUrl",userOpinions.get(0).getPictureUrl());
        return "login";
    }

    @RequestMapping(value = "deleteUserOpinion",method = RequestMethod.GET)
    public String deleteUserOpinion(Integer opinion_id){
        opinion_id = 1;
        userOpinionService.deleteById(opinion_id);
        return "login";
    }

    @RequestMapping(value = "updateUserOpinion",method = RequestMethod.GET)
    public String updateUserOpinion(UserOpinion userOpinionDto){
        userOpinionDto = new UserOpinion(5,1,"update opinion","test update",5,"D:\\live\\imgs\\1607481426920.jpg");
        userOpinionService.update(userOpinionDto);
        return "login";
    }
}
