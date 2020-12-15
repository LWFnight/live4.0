package com.example.live.controller;

import com.example.live.pojo.*;
import com.example.live.service.AllocationService;
import com.example.live.service.FeatureService;
import com.example.live.service.HouseService;
import com.example.live.service.LandlordHouseRelationService;
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

    @Autowired
    private AllocationService allocationService;

    @Autowired
    private FeatureService featureService;

    @Autowired
    private LandlordHouseRelationService landlordHouseRelationService;

    private String savePath = "D:\\中软实训\\live\\src\\main\\resources\\static\\imgs\\";

    @RequestMapping(value = "insertHouse",method = RequestMethod.POST)
    public String insertHouse(House house,HttpSession session){
        if (house.getPicture() !=null){
            ImgToJson img = new ImgToJson();
            String uploadPath = "D:\\live\\pictures\\";
            File file = new File(uploadPath);
            String fileName = house.getPicture();
            File uploadFile=new File(file+File.separator+fileName);
            String imgData = img.getImageBinary(uploadFile.toString());
            house.setPicture(imgData);
            String pictureUrl = savePath+house.getHouse_id().toString()+".jpg";
            house.setPictureUrl(pictureUrl);
        }
        houseService.insert(house);
        Allocation allocation = new Allocation(house.getHouse_id(),0,0,0,0,0,0,0,0,0,0);
        allocationService.insert(allocation);
        Feature feature = new Feature(house.getHouse_id(),0,0,0,0,0,0,0,0,0);
        featureService.insert(feature);
        User user = (User) session.getAttribute("userLoginInfo");
        LandlordHouseRelation landlordHouseRelation = new LandlordHouseRelation(user.getUser_id(),house.getHouse_id());
        landlordHouseRelationService.insert(landlordHouseRelation);
        return "login";
    }

    @RequestMapping(value = "findHouses",method = RequestMethod.GET)
    public String findHouses(House house){
        List<House> houses = new ArrayList<>();
        houses = houseService.find(house);
        ImgToJson img = new ImgToJson();
        for (House house1 : houses) {
            if (house1.getPicture()!=null){
                String savePath = house1.getPictureUrl();
                String imgData = house1.getPicture();
                img.base64StringToImage(savePath,imgData);
                house1.setPicture(house1.getPictureUrl());
            }
        }
        return "login";//返回集合
    }

    @RequestMapping(value = "findHousesDetail",method = RequestMethod.GET)
    public String findHousesDetail(House house){
        List<House> houses = new ArrayList<>();
        houses = houseService.findHouseDetail(house);
        ImgToJson img = new ImgToJson();
        for (House house1 : houses) {
            if (house1.getPicture()!=null){
                String savePath = house1.getPictureUrl();
                String imgData = house1.getPicture();
                img.base64StringToImage(savePath,imgData);
                house1.setPicture(house1.getPictureUrl());
            }
        }
        return "login";//返回集合
    }

    @RequestMapping(value = "findHouseByUserId",method = RequestMethod.GET)
    public String findHouseByUserId(HttpSession session){
        User user = (User) session.getAttribute("userLoginInfo");
        Integer user_id = user.getUser_id();
        List<House> houses = new ArrayList<>();
        houses = houseService.findHouseByUserId(user_id);
        for (House house : houses) {
            System.out.println(house.getHouse_id());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String time = simpleDateFormat.format(house.getLandlordHouseRelation().getPublish_time());
            house.setTime(time);
        }
        return "login";
    }

    @RequestMapping(value = "deleteHouseById",method = RequestMethod.GET)
    public String deleteHouseById(Integer house_id){
        houseService.deleteById(house_id);
        return "login";
    }

    @RequestMapping(value = "updateHouse",method = RequestMethod.GET)
    public String updateHouse(House house){
        if (house.getPicture() !=null){
            ImgToJson img = new ImgToJson();
            String uploadPath = house.getPicture();
            String imgData = img.getImageBinary(uploadPath);
            house.setPicture(imgData);
            String pictureUrl = savePath+house.getHouse_id().toString()+".jpg";
            house.setPictureUrl(pictureUrl);
        }
        houseService.update(house);
        return "login";
    }
}
