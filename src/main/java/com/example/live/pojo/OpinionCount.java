package com.example.live.pojo;

public class OpinionCount {
    private Integer opinion_id;
    private Integer count;

    public OpinionCount() {
    }

    public OpinionCount(Integer opinion_id, Integer count) {
        this.opinion_id = opinion_id;
        this.count = count;
    }

    public Integer getOpinion_id() {
        return opinion_id;
    }

    public void setOpinion_id(Integer opinion_id) {
        this.opinion_id = opinion_id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
