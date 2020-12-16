package com.example.live.controller;

import com.example.live.pojo.OpinionCount;
import com.example.live.pojo.User;
import com.example.live.pojo.UserOpinion;
import com.example.live.service.OpinionCountService;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@SessionAttributes(value = {"userOpinions","testPictureUrl"})
public class UserOpinionController {

    @Autowired
    private UserOpinionService userOpinionService;

    @Autowired
    private OpinionCountService opinionCountService;

    @RequestMapping(value = "insertOpinion",method = RequestMethod.POST)
    public String insertOpinion(UserOpinion userOpinion, MultipartFile mpf, HttpServletRequest request) throws Exception{
        if (!mpf.isEmpty()){
            //临时文件夹下创建图片
            String saveFileName = UUID.randomUUID().toString().replaceAll("-", "")+"_"+mpf.getOriginalFilename();
            String filePath = request.getServletContext().getRealPath("")+"\\"+saveFileName;
            File f = new File(filePath);
            f.createNewFile();
            mpf.transferTo(f);
            //将图片转为二进制格式的数据
            ImgToJson img = new ImgToJson();
            String imgData = img.getImageBinary(filePath);
            //将构造对象存储数据，并持久化
            Long time = System.currentTimeMillis();
            String pictureUrl = "D:\\中软实训\\live\\src\\main\\resources\\static\\imgs\\"+time.toString()+".jpg";
            String pictureName = time.toString()+".jpg";
            userOpinion.setPicture(imgData);
            userOpinion.setPictureUrl(pictureUrl);
            userOpinion.setPicture_name(pictureName);
        }
        userOpinionService.insert(userOpinion);
        OpinionCount opinionCount = new OpinionCount(userOpinion.getOpinion_id(),0);
        opinionCountService.insert(opinionCount);
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
            if (userOpinion.getPicture() !=null){
                String savePath = userOpinion.getPictureUrl();
                System.out.println(savePath);
                img.base64StringToImage(savePath,userOpinion.getPicture());
                userOpinion.setPath("/imgs/"+userOpinion.getPicture_name());
                userOpinion.setPicture(userOpinion.getPictureUrl());
                System.out.println(userOpinion.getPath());
            }else {
                userOpinion.setPicture_name("default.jpg");
            }
        }
        model.addAttribute("userOpinions",userOpinions);
        return "login";
    }

    @RequestMapping(value = "deleteUserOpinion",method = RequestMethod.GET)
    public String deleteUserOpinion(Integer opinion_id){
        userOpinionService.deleteById(opinion_id);
        return "login";
    }

    @RequestMapping(value = "updateUserOpinion",method = RequestMethod.GET)
    public String updateUserOpinion(UserOpinion userOpinionDto, MultipartFile mpf, HttpServletRequest request) throws Exception{
        if (!mpf.isEmpty()) {
            //临时文件夹下创建图片
            String saveFileName = UUID.randomUUID().toString().replaceAll("-", "") + "_" + mpf.getOriginalFilename();
            String filePath = request.getServletContext().getRealPath("") + "\\" + saveFileName;
            File f = new File(filePath);
            f.createNewFile();
            mpf.transferTo(f);
            //将图片转为二进制格式的数据
            ImgToJson img = new ImgToJson();
            String imgData = img.getImageBinary(filePath);
            userOpinionDto.setPicture(imgData);
        }
        userOpinionService.update(userOpinionDto);
        return "login";
    }
}
