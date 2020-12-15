package com.example.live.controller;

import com.example.live.pojo.Looking;
import com.example.live.pojo.User;
import com.example.live.service.LookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LookingController {

    @Autowired
    private LookingService lookingService;

    @RequestMapping(value = "findLookings",method = RequestMethod.GET)
    public List<Looking> findLookings (Looking looking){
        return lookingService.find(looking);
    }

    @RequestMapping(value = "findHIstoryLookings",method = RequestMethod.GET)
    public List<Looking> findHIstoryLookings (Looking looking){
        return lookingService.findHistoryLooking(looking);
    }

    @RequestMapping(value = "insertLooking",method = RequestMethod.POST)
    public boolean insertLooking (Looking looking,HttpSession session){
        User user = (User) session.getAttribute("userLoginInfo");
        looking.setUser_id(user.getUser_id());
        looking.setStatus(0);
        lookingService.insert(looking);
        return true;
    }

    @RequestMapping(value = "deleteLooking",method = RequestMethod.GET)
    public boolean deleteLooking (Integer looking_id){
        lookingService.deleteById(looking_id);
        return true;
    }

    @RequestMapping(value = "agentOrderReceiving",method = RequestMethod.POST)
    public String agentOrderReceiving(Looking looking,HttpSession session){
        User user = (User) session.getAttribute("userLoginInfo");
        looking.setAgent_id(user.getUser_id());
        looking.setStatus(1);
        lookingService.update(looking);
        return "login";
    }

    @RequestMapping(value = "userOrderFinish",method = RequestMethod.POST)
    public String userOrderFinish(Looking looking){
        looking.setStatus(2);
        lookingService.update(looking);
        return "login";
    }
}
