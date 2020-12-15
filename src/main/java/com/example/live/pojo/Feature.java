package com.example.live.pojo;

public class Feature {
    private Integer house_id;
    private Integer independent_bathroom;
    private Integer independent_balcony;
    private Integer smart_sock;
    private Integer self_decorating;
    private Integer first_rent;
    private Integer fully_furnished;
    private Integer nearby_subway;
    private Integer any_time_to_see;
    private Integer check_in_at_once;

    public Feature() {
    }

    public Feature(Integer house_id, Integer independent_bathroom, Integer independent_balcony, Integer smart_sock, Integer self_decorating, Integer first_rent, Integer fully_furnished, Integer nearby_subway, Integer any_time_to_see, Integer check_in_at_once) {
        this.house_id = house_id;
        this.independent_bathroom = independent_bathroom;
        this.independent_balcony = independent_balcony;
        this.smart_sock = smart_sock;
        this.self_decorating = self_decorating;
        this.first_rent = first_rent;
        this.fully_furnished = fully_furnished;
        this.nearby_subway = nearby_subway;
        this.any_time_to_see = any_time_to_see;
        this.check_in_at_once = check_in_at_once;
    }

    public Feature(Integer independent_bathroom, Integer independent_balcony, Integer smart_sock, Integer self_decorating, Integer first_rent, Integer fully_furnished, Integer nearby_subway, Integer any_time_to_see, Integer check_in_at_once) {
        this.independent_bathroom = independent_bathroom;
        this.independent_balcony = independent_balcony;
        this.smart_sock = smart_sock;
        this.self_decorating = self_decorating;
        this.first_rent = first_rent;
        this.fully_furnished = fully_furnished;
        this.nearby_subway = nearby_subway;
        this.any_time_to_see = any_time_to_see;
        this.check_in_at_once = check_in_at_once;
    }

    public Integer getHouse_id() {
        return house_id;
    }

    public void setHouse_id(Integer house_id) {
        this.house_id = house_id;
    }

    public Integer getIndependent_bathroom() {
        return independent_bathroom;
    }

    public void setIndependent_bathroom(Integer independent_bathroom) {
        this.independent_bathroom = independent_bathroom;
    }

    public Integer getIndependent_balcony() {
        return independent_balcony;
    }

    public void setIndependent_balcony(Integer independent_balcony) {
        this.independent_balcony = independent_balcony;
    }

    public Integer getSmart_sock() {
        return smart_sock;
    }

    public void setSmart_sock(Integer smart_sock) {
        this.smart_sock = smart_sock;
    }

    public Integer getSelf_decorating() {
        return self_decorating;
    }

    public void setSelf_decorating(Integer self_decorating) {
        this.self_decorating = self_decorating;
    }

    public Integer getFirst_rent() {
        return first_rent;
    }

    public void setFirst_rent(Integer first_rent) {
        this.first_rent = first_rent;
    }

    public Integer getFully_furnished() {
        return fully_furnished;
    }

    public void setFully_furnished(Integer fully_furnished) {
        this.fully_furnished = fully_furnished;
    }

    public Integer getNearby_subway() {
        return nearby_subway;
    }

    public void setNearby_subway(Integer nearby_subway) {
        this.nearby_subway = nearby_subway;
    }

    public Integer getAny_time_to_see() {
        return any_time_to_see;
    }

    public void setAny_time_to_see(Integer any_time_to_see) {
        this.any_time_to_see = any_time_to_see;
    }

    public Integer getCheck_in_at_once() {
        return check_in_at_once;
    }

    public void setCheck_in_at_once(Integer check_in_at_once) {
        this.check_in_at_once = check_in_at_once;
    }
}
