package com.example.live.controller;


import com.example.live.pojo.LandlordInformation;
import com.example.live.pojo.User;
import com.example.live.service.LandlordInformationService;
import com.example.live.service.UserService;
import com.example.live.utils.ImgToJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes(value = {"landlordInformations"})
public class LandlordInformationController {

    @Autowired
    private LandlordInformationService landlordInformationService;

    @Autowired
    private UserService userService;

    private String savePath = "D:\\live\\imgs\\LandlordInfomation";

    @RequestMapping(value = "findLandlordInformationList",method = RequestMethod.GET)
    public String findLandlordInformationList(LandlordInformation landlordInformation){
        List<LandlordInformation> landlordInformations = new ArrayList<>();
        landlordInformations = landlordInformationService.find(landlordInformation);
        for (LandlordInformation information : landlordInformations) {
            System.out.println(information.getUser_id()+"\t"+information.getUser().getName());
        }
        return "login";
    }

    public String findLandlordInfoDetail(LandlordInformation landlordInformation,Model model){
        List<LandlordInformation> landlordInformations = new ArrayList<>();
        landlordInformations = landlordInformationService.find(landlordInformation);
        //图片转换格式
        ImgToJson img = new ImgToJson();
        for (LandlordInformation information : landlordInformations) {
            img.base64StringToImage(information.getId_card_picture_f_url(),information.getId_card_picture_f());
            img.base64StringToImage(information.getId_card_picture_r_url(),information.getId_card_picture_r());
            model.addAttribute("landlordInfoDetail",information);
            model.addAttribute("id_card_picture_f_url",information.getId_card_picture_f_url());
            model.addAttribute("id_card_picture_r_url",information.getId_card_picture_r_url());
        }
        return "login";
    }

    @RequestMapping(value = "insertLandlordInformation",method = RequestMethod.POST)
    public String insertLandlordInformation(LandlordInformation landlordInformation, HttpSession session){
        //构造对象
        User user = (User) session.getAttribute("userLoginInfo");
        landlordInformation.setUser_id(user.getUser_id());
        //将图片转为二进制格式的数据
        ImgToJson img = new ImgToJson();
        File file = new File("D:\\live\\pictures");
        String idPicturefName = landlordInformation.getId_card_picture_f();
        File uploadidPicturef=new File(file+File.separator+idPicturefName);
        String idPicturerName = landlordInformation.getId_card_picture_r();
        File uploadidPicturer=new File(file+File.separator+idPicturerName);
        String idPicturefData = img.getImageBinary(uploadidPicturef.toString());//身份证正面照片图片数据
        String idPicturefDataUrl = savePath+"\\"+landlordInformation.getId_number().toString()+"f.jpg";//身份证正面照片图片数据保存路径
        String idPicturerData = img.getImageBinary(uploadidPicturer.toString());//身份证反面照片图片数据
        String idPicturerDataUrl = savePath+"\\"+landlordInformation.getId_number().toString()+"r.jpg";//身份证反面照片图片数据保存路径
        //只有没有成为房东的才可以注册成为房东,一个身份证只能绑定一个房东
        List<LandlordInformation> landlordInformations = new ArrayList<>();
        landlordInformations = landlordInformationService.find(landlordInformation);
        if(landlordInformations.size() == 0){
            landlordInformation.setId_card_picture_f(idPicturefData);
            landlordInformation.setId_card_picture_r(idPicturerData);
            landlordInformation.setStatus("待审批");
            landlordInformation.setId_card_picture_f_url(idPicturefDataUrl);
            landlordInformation.setId_card_picture_r_url(idPicturerDataUrl);
            landlordInformationService.insert(landlordInformation);
            return "login";//返回成功
        }
        return "login";//返回失败
    }

    @RequestMapping(value = "adminDeleteLandlordInformation",method = RequestMethod.GET)
    public String adminDeleteLandlordInformation(Integer user_id){
        landlordInformationService.deleteById(user_id);
        return "login";
    }

    @RequestMapping(value = "userDeleteLandlordInformation",method = RequestMethod.GET)
    public String userDeleteLandlordInformation(HttpSession session){
        User user = (User) session.getAttribute("userLoginInfo");
        landlordInformationService.deleteById(user.getUser_id());
        return "login";
    }

    @RequestMapping(value = "userUpdateLandlordInfomation",method = RequestMethod.POST)
    public String  userUpdateLandlordInfomation(LandlordInformation landlordInformation,HttpSession session){
        User user = (User) session.getAttribute("userLoginInfo");
        landlordInformation.setUser_id(user.getUser_id());
        //所有普通用户更新房东信息都要重新审批
        landlordInformation.setStatus("待审批");
        landlordInformationService.update(landlordInformation);
        User user1 = new User();
        user1.setRole_id(4);
        userService.updateUser(user1);
        return "login";
    }

    @RequestMapping(value = "adminUpdateLandlordInfomation",method = RequestMethod.POST)
    public String  adminUpdateLandlordInfomation(LandlordInformation landlordInformation){
        User user = new User();
        if (landlordInformation.getStatus() =="审批通过"){
            user.setRole_id(5);
            userService.updateUser(user);
            landlordInformationService.update(landlordInformation);
        }else {
            user.setRole_id(4);
            userService.updateUser(user);
            landlordInformationService.update(landlordInformation);
        }

        return "login";
    }
}
