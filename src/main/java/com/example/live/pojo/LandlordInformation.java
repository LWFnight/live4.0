package com.example.live.pojo;

public class LandlordInformation {
    private Integer user_id;
    private String id_number;
    private String id_card_picture_f;
    private String id_card_picture_r;
    private String alipay_name;
    private String alipay_account;
    private String status;//status：待审批，审批通过，审批不通过
    private String id_card_picture_f_url;
    private String id_card_picture_r_url;

    private User user;

    public LandlordInformation() {
    }

    public LandlordInformation(Integer user_id, String id_number, String id_card_picture_f, String id_card_picture_r, String alipay_name, String alipay_account, String status, String id_card_picture_f_url, String id_card_picture_r_url) {
        this.user_id = user_id;
        this.id_number = id_number;
        this.id_card_picture_f = id_card_picture_f;
        this.id_card_picture_r = id_card_picture_r;
        this.alipay_name = alipay_name;
        this.alipay_account = alipay_account;
        this.status = status;
        this.id_card_picture_f_url = id_card_picture_f_url;
        this.id_card_picture_r_url = id_card_picture_r_url;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getId_card_picture_f() {
        return id_card_picture_f;
    }

    public void setId_card_picture_f(String id_card_picture_f) {
        this.id_card_picture_f = id_card_picture_f;
    }

    public String getId_card_picture_r() {
        return id_card_picture_r;
    }

    public void setId_card_picture_r(String id_card_picture_r) {
        this.id_card_picture_r = id_card_picture_r;
    }

    public String getAlipay_name() {
        return alipay_name;
    }

    public void setAlipay_name(String alipay_name) {
        this.alipay_name = alipay_name;
    }

    public String getAlipay_account() {
        return alipay_account;
    }

    public void setAlipay_account(String alipay_account) {
        this.alipay_account = alipay_account;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId_card_picture_f_url() {
        return id_card_picture_f_url;
    }

    public void setId_card_picture_f_url(String id_card_picture_f_url) {
        this.id_card_picture_f_url = id_card_picture_f_url;
    }

    public String getId_card_picture_r_url() {
        return id_card_picture_r_url;
    }

    public void setId_card_picture_r_url(String id_card_picture_r_url) {
        this.id_card_picture_r_url = id_card_picture_r_url;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
