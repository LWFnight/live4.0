package com.example.live.pojo;

public class UserOpinion {
    private Integer opinion_id;
    private Integer user_id;
    private String opinion;
    private String picture;
    private Integer star;
    private String pictureUrl;
    private String picture_name;
    private String path;
    private Integer house_id;

    private OpinionCount opinionCount;

    private House house;

    private User user;

    public UserOpinion() {
    }

    public UserOpinion(Integer user_id, String opinion, String picture, Integer star, String pictureUrl, String picture_name, String path, Integer house_id) {
        this.user_id = user_id;
        this.opinion = opinion;
        this.picture = picture;
        this.star = star;
        this.pictureUrl = pictureUrl;
        this.picture_name = picture_name;
        this.path = path;
        this.house_id = house_id;
    }

    public UserOpinion(Integer user_id, String opinion, String picture, Integer star, String pictureUrl) {
        this.user_id = user_id;
        this.opinion = opinion;
        this.picture = picture;
        this.star = star;
        this.pictureUrl = pictureUrl;
    }

    public Integer getOpinion_id() {
        return opinion_id;
    }

    public void setOpinion_id(Integer opinion_id) {
        this.opinion_id = opinion_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public OpinionCount getOpinionCount() {
        return opinionCount;
    }

    public void setOpinionCount(OpinionCount opinionCount) {
        this.opinionCount = opinionCount;
    }

    public String getPicture_name() {
        return picture_name;
    }

    public void setPicture_name(String picture_name) {
        this.picture_name = picture_name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getHouse_id() {
        return house_id;
    }

    public void setHouse_id(Integer house_id) {
        this.house_id = house_id;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
