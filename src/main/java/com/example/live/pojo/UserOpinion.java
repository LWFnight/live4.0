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

    private OpinionCount opinionCount;

    public UserOpinion() {
    }

    public UserOpinion(Integer opinion_id, Integer user_id, String opinion, String picture, Integer star, String pictureUrl, String picture_name, OpinionCount opinionCount) {
        this.opinion_id = opinion_id;
        this.user_id = user_id;
        this.opinion = opinion;
        this.picture = picture;
        this.star = star;
        this.pictureUrl = pictureUrl;
        this.picture_name = picture_name;
        this.opinionCount = opinionCount;
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
}
