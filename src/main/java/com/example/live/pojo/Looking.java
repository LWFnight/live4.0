package com.example.live.pojo;

import java.util.Date;

public class Looking {
    private Integer looking_id;
    private Integer user_id;
    private Integer house_id;
    private Date date;
    private String site;
    private Integer agent_id;
    private Integer status;//状态：0（已申请，待经纪人接收），1（待处理，经济人已接收），2（已完成）

    private User user;

    private House house;

    private Agent agent;

    public Looking() {
    }

    public Looking(Integer looking_id, Integer user_id, Integer house_id, Date date, String site, Integer agent_id, Integer status) {
        this.looking_id = looking_id;
        this.user_id = user_id;
        this.house_id = house_id;
        this.date = date;
        this.site = site;
        this.agent_id = agent_id;
        this.status = status;
    }

    public Integer getLooking_id() {
        return looking_id;
    }

    public void setLooking_id(Integer looking_id) {
        this.looking_id = looking_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getHouse_id() {
        return house_id;
    }

    public void setHouse_id(Integer house_id) {
        this.house_id = house_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Integer getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(Integer agent_id) {
        this.agent_id = agent_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}
