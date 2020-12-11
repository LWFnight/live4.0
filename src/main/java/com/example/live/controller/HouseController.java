package com.example.live.controller;

import com.example.live.pojo.House;
import com.example.live.pojo.User;
import com.example.live.service.HouseService;
import com.example.live.utils.ImgToJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HouseController {

    @Autowired
    private HouseService houseService;

    private String savePath = "D:\\live\\imgs\\House";

    @RequestMapping(value = "insertHouse",method = RequestMethod.POST)
    public String insertHouse(House house){
        ImgToJson img = new ImgToJson();
        String uploadPath = "D:\\live\\pictures\\";
        File file = new File(uploadPath);
        String fileName = house.getPicture();
        File uploadFile=new File(file+File.separator+fileName);
        String imgData = img.getImageBinary(uploadFile.toString());
        house.setPicture(imgData);
        String pictureUrl = savePath+"\\"+house.getHouse_id().toString()+".jpg";
        house.setPictureUrl(pictureUrl);
        houseService.insert(house);
        return "login";
    }

    @RequestMapping(value = "findHouses",method = RequestMethod.GET)
    public String findHouses(House house){
        List<House> houses = new ArrayList<>();
        houses = houseService.find(house);
        ImgToJson img = new ImgToJson();
        for (House house1 : houses) {
            String savePath = house1.getPictureUrl();
            String imgData = house1.getPicture();
            img.base64StringToImage(savePath,imgData);
        }
        //返回集合，遍历集合获取图片路径
        return "login";
    }

    @RequestMapping(value = "findHouseByUserId",method = RequestMethod.GET)
    public String findHouseByUserId(HttpSession session){
        User user = (User) session.getAttribute("userLoginInfo");
        Integer user_id = user.getUser_id();
        List<House> houses = new ArrayList<>();
        houses = houseService.findHouseByUserId(user_id);
        System.out.println(user_id);
        Integer i = 512;
        for (House house : houses) {
            System.out.println(house.getHouse_id());
        }
        return "login";
    }

    public String deleteHouseById(Integer house_id){
        houseService.deleteById(house_id);
        return "login";
    }

    public String updateHouse(House house){
        houseService.update(house);
        return "login";
    }

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String insert(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        simpleDateFormat.format(new Date());
        System.out.println(simpleDateFormat.format(now));
        return "login";
    }
}
