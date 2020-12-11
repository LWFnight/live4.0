package com.example.live.pojo;

public class UserPersonalInfo {
    private Integer user_id;
    private String head_portrait;
    private Integer age;
    private String job;
    private String hobby;
    private String nick_name;

    public UserPersonalInfo() {
    }

    public UserPersonalInfo(Integer user_id, String head_portrait, Integer age, String job, String hobby, String nick_name) {
        this.user_id = user_id;
        this.head_portrait = head_portrait;
        this.age = age;
        this.job = job;
        this.hobby = hobby;
        this.nick_name = nick_name;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getHead_portrait() {
        return head_portrait;
    }

    public void setHead_portrait(String head_portrait) {
        this.head_portrait = head_portrait;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }
}
