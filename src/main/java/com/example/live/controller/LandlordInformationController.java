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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@SessionAttributes(value = {"landlordInformations"})
public class LandlordInformationController {

    @Autowired
    private LandlordInformationService landlordInformationService;

    @Autowired
    private UserService userService;

    private String savePath = "D:\\中软实训\\live\\src\\main\\resources\\static\\imgs\\";

    @RequestMapping(value = "findLandlordInformationList",method = RequestMethod.GET)
    public String findLandlordInformationList(LandlordInformation landlordInformation){
        List<LandlordInformation> landlordInformations = new ArrayList<>();
        landlordInformations = landlordInformationService.find(landlordInformation);
        for (LandlordInformation information : landlordInformations) {
            System.out.println(information.getUser_id()+"\t"+information.getUser().getName());
        }
        return "login";
    }

    @RequestMapping(value = "findLandlordInfoDetail",method = RequestMethod.GET)
    public String findLandlordInfoDetail(LandlordInformation landlordInformation,Model model){
        List<LandlordInformation> landlordInformations = new ArrayList<>();
        landlordInformations = landlordInformationService.find(landlordInformation);
        //图片转换格式
        ImgToJson img = new ImgToJson();
        for (LandlordInformation information : landlordInformations) {
            img.base64StringToImage(information.getId_card_picture_f_url(),information.getId_card_picture_f());
            img.base64StringToImage(information.getId_card_picture_r_url(),information.getId_card_picture_r());
            information.setId_card_picture_f_path("/imgs/"+information.getId_card_picture_f_name());
            information.setId_card_picture_r_path("/imgs/"+information.getId_card_picture_r_name());
            information.setId_card_picture_f(information.getId_card_picture_f_url());
            information.setId_card_picture_r(information.getId_card_picture_r_url());
        }
        return "login";
    }

    @RequestMapping(value = "insertLandlordInformation",method = RequestMethod.POST)
    public String insertLandlordInformation(LandlordInformation landlordInformation, MultipartFile ipf,MultipartFile ipr, HttpServletRequest request) throws Exception{
        //构造对象
//        User user = (User) session.getAttribute("userLoginInfo");
//        landlordInformation.setUser_id(user.getUser_id());
        //创建两张图片
        //身份证正面
        String saveFileNamef = UUID.randomUUID().toString().replaceAll("-", "") + "_" + ipf.getOriginalFilename();
        String filePathf = request.getServletContext().getRealPath("") + "\\" + saveFileNamef;
        File f = new File(filePathf);
        f.createNewFile();
        ipf.transferTo(f);
        //身份证反面
        String saveFileNamer = UUID.randomUUID().toString().replaceAll("-", "") + "_" + ipr.getOriginalFilename();
        String filePathr = request.getServletContext().getRealPath("") + "\\" + saveFileNamer;
        File r = new File(filePathf);
        f.createNewFile();
        ipr.transferTo(r);
        //将图片转为二进制格式的数据
        ImgToJson img = new ImgToJson();
        String idPicturefName = landlordInformation.getId_card_picture_f();
        String idPicturerName = landlordInformation.getId_card_picture_r();
        String idPicturefData = img.getImageBinary(filePathf);//身份证正面照片图片数据
        String idPicturefDataUrl = savePath+"\\"+landlordInformation.getId_number().toString()+"f.jpg";//身份证正面照片图片数据保存路径
        String idPicturefSaveName = landlordInformation.getId_number().toString()+"f.jpg";
        String idPicturerData = img.getImageBinary(filePathr);//身份证反面照片图片数据
        String idPicturerDataUrl = savePath+"\\"+landlordInformation.getId_number().toString()+"r.jpg";//身份证反面照片图片数据保存路径
        String idPicturerSaveName = landlordInformation.getId_number().toString()+"r.jpg";
        //只有没有成为房东的才可以注册成为房东,一个身份证只能绑定一个房东
        List<LandlordInformation> landlordInformations = new ArrayList<>();
        landlordInformations = landlordInformationService.find(landlordInformation);
        if(landlordInformations.size() == 0){
            landlordInformation.setId_card_picture_f(idPicturefData);
            landlordInformation.setId_card_picture_r(idPicturerData);
            landlordInformation.setStatus("待审批");
            landlordInformation.setId_card_picture_f_url(idPicturefDataUrl);
            landlordInformation.setId_card_picture_r_url(idPicturerDataUrl);
            landlordInformation.setId_card_picture_f_name(idPicturefSaveName);
            landlordInformation.setId_card_picture_r_name(idPicturerSaveName);
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
    public String  userUpdateLandlordInfomation(LandlordInformation landlordInformation, MultipartFile ipf,MultipartFile ipr, HttpServletRequest request) throws Exception{
//        User user = (User) session.getAttribute("userLoginInfo");
//        landlordInformation.setUser_id(user.getUser_id());
        //创建两张图片
        //身份证正面
        String saveFileNamef = UUID.randomUUID().toString().replaceAll("-", "") + "_" + ipf.getOriginalFilename();
        String filePathf = request.getServletContext().getRealPath("") + "\\" + saveFileNamef;
        File f = new File(filePathf);
        f.createNewFile();
        ipf.transferTo(f);
        //身份证反面
        String saveFileNamer = UUID.randomUUID().toString().replaceAll("-", "") + "_" + ipr.getOriginalFilename();
        String filePathr = request.getServletContext().getRealPath("") + "\\" + saveFileNamer;
        File r = new File(filePathf);
        f.createNewFile();
        ipr.transferTo(r);
        //将图片转为二进制格式的数据
        ImgToJson img = new ImgToJson();
        String idPicturefData = img.getImageBinary(filePathf);//身份证正面照片图片数据
        String idPicturerData = img.getImageBinary(filePathr);//身份证反面照片图片数据
        landlordInformation.setId_card_picture_f(idPicturefData);
        landlordInformation.setId_card_picture_r(idPicturerData);
        //所有普通用户更新房东信息都要重新审批
        landlordInformation.setStatus("待审批");
        landlordInformationService.update(landlordInformation);
        User user = new User();
        user.setUser_id(landlordInformation.getUser_id());
        user.setRole_id(4);
        userService.updateUser(user);
        return "login";
    }

    @RequestMapping(value = "adminUpdateLandlordInfomation",method = RequestMethod.POST)
    public String  adminUpdateLandlordInfomation(LandlordInformation landlordInformation){
        User user = new User();
        if (landlordInformation.getStatus() =="审批通过"){
            user.setUser_id(landlordInformation.getUser_id());
            user.setRole_id(5);
            userService.updateUser(user);
            landlordInformationService.update(landlordInformation);
        }else {
            user.setUser_id(landlordInformation.getUser_id());
            user.setRole_id(4);
            userService.updateUser(user);
            landlordInformationService.update(landlordInformation);
        }

        return "login";
    }
}
