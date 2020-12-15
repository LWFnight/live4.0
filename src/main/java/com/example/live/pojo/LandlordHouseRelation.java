package com.example.live.pojo;

import java.util.Date;

public class LandlordHouseRelation {
    private Integer user_id;
    private Integer house_id;
    private Integer relation_id;
    private Date publish_time;

    public LandlordHouseRelation() {
    }

    public LandlordHouseRelation(Integer user_id, Integer house_id, Integer relation_id, Date publish_time) {
        this.user_id = user_id;
        this.house_id = house_id;
        this.relation_id = relation_id;
        this.publish_time = publish_time;
    }

    public LandlordHouseRelation(Integer user_id, Integer house_id) {
        this.user_id = user_id;
        this.house_id = house_id;
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

    public Integer getRelation_id() {
        return relation_id;
    }

    public void setRelation_id(Integer relation_id) {
        this.relation_id = relation_id;
    }

    public Date getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(Date publish_time) {
        this.publish_time = publish_time;
    }
}
