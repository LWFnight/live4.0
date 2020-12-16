package com.example.live.pojo;

public class Agent {
    private Integer agent_id;
    private Integer user_id;
    private Integer work_time;
    private Integer star;
    private String real_name;
    private String photo;
    private Integer status;//0:待审批,1:审批通过,2:审批不通过
    private String photo_save_path;
    private String photo_name;

    private User user;

    public Agent() {
    }

    public Agent(Integer user_id, Integer work_time, Integer star, String real_name, String photo, Integer status, String photo_save_path, String photo_name) {
        this.user_id = user_id;
        this.work_time = work_time;
        this.star = star;
        this.real_name = real_name;
        this.photo = photo;
        this.status = status;
        this.photo_save_path = photo_save_path;
        this.photo_name = photo_name;
    }

    public Integer getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(Integer agent_id) {
        this.agent_id = agent_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getWork_time() {
        return work_time;
    }

    public void setWork_time(Integer work_time) {
        this.work_time = work_time;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public String getPhoto_save_path() {
        return photo_save_path;
    }

    public void setPhoto_save_path(String photo_save_path) {
        this.photo_save_path = photo_save_path;
    }

    public String getPhoto_name() {
        return photo_name;
    }

    public void setPhoto_name(String photo_name) {
        this.photo_name = photo_name;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
