package com.example.live.controller;

import com.example.live.pojo.Agent;
import com.example.live.pojo.User;
import com.example.live.service.AgentService;
import com.example.live.service.UserService;
import com.example.live.utils.ImgToJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class AgentController {

    @Autowired
    private AgentService agentService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "insertAgent",method = RequestMethod.POST)
    public String insertAgent(Agent agent, MultipartFile mpf, HttpServletRequest request) throws Exception{
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
            String photoSavePath = "D:\\中软实训\\live\\src\\main\\resources\\static\\imgs\\"+agent.getAgent_id().toString()+agent.getReal_name()+".jpg";
            String photoName = agent.getAgent_id().toString()+agent.getReal_name()+".jpg";
            agent.setPhoto(imgData);
            agent.setPhoto_save_path(photoSavePath);
            agent.setPhoto_name(photoName);
        }
        agent.setStatus(0);
        agentService.insert(agent);
        return "login";
    }

    @RequestMapping(value = "deleteAgent",method = RequestMethod.GET)
    public String deleteAgent(Integer agent_id){
        agentService.deleteById(agent_id);
        return "login";
    }

    @RequestMapping(value = "findAgent",method = RequestMethod.GET)
    public String findAgent(Agent agent){
        List<Agent> agents = new ArrayList<>();
        agents = agentService.find(agent);
        ImgToJson img = new ImgToJson();
        for (Agent agent1 : agents) {
            if (agent.getPhoto()!=null){
                img.base64StringToImage(agent.getPhoto_save_path(),agent.getPhoto());
                agent.setPhoto(agent.getPhoto_save_path());
            }
        }
        return "login";
    }

    @RequestMapping(value = "updateAgent",method = RequestMethod.POST)
    public String updateAgent(Agent agent, MultipartFile mpf, HttpServletRequest request) throws Exception{
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
            String photoSavePath = "D:\\中软实训\\live\\src\\main\\resources\\static\\imgs\\"+agent.getAgent_id().toString()+agent.getReal_name()+".jpg";
            String photoName = agent.getAgent_id().toString()+agent.getReal_name()+".jpg";
            agent.setPhoto(imgData);
            agent.setPhoto_save_path(photoSavePath);
            agent.setPhoto_name(photoName);
        }
        agent.setStatus(0);
        agentService.update(agent);
        User user = new User();
        user.setUser_id(agent.getUser_id());
        user.setRole_id(4);
        userService.updateUser(user);
        return "login";
    }

    @RequestMapping(value = "adminUpdateAgent",method = RequestMethod.POST)
    public String  adminUpdateAgent(Agent agent){
        User user = new User();
        if (agent.getStatus() == 1){
            user.setUser_id(agent.getUser_id());
            user.setRole_id(5);
            userService.updateUser(user);
            agentService.update(agent);
        }else {
            user.setUser_id(agent.getUser_id());
            user.setRole_id(4);
            userService.updateUser(user);
            agentService.update(agent);
        }
        return "login";
    }

}
