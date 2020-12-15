package com.example.live.pojo;

public class Allocation {
    private Integer house_id;
    //以下属性0表示没有，1表示有
    private Integer tv;
    private Integer refrigerator;
    private Integer washing_machine;
    private Integer air_condition;
    private Integer wifi;
    private Integer beds;
    private Integer water_heater;
    private Integer chest;
    private Integer desk;
    private Integer cooking;

    public Allocation() {
    }

    public Allocation(Integer house_id, Integer tv, Integer refrigerator, Integer washing_machine, Integer air_condition, Integer wifi, Integer beds, Integer water_heater, Integer chest, Integer desk, Integer cooking) {
        this.house_id = house_id;
        this.tv = tv;
        this.refrigerator = refrigerator;
        this.washing_machine = washing_machine;
        this.air_condition = air_condition;
        this.wifi = wifi;
        this.beds = beds;
        this.water_heater = water_heater;
        this.chest = chest;
        this.desk = desk;
        this.cooking = cooking;
    }

    public Allocation(Integer tv, Integer refrigerator, Integer washing_machine, Integer air_condition, Integer wifi, Integer beds, Integer water_heater, Integer chest, Integer desk, Integer cooking) {
        this.tv = tv;
        this.refrigerator = refrigerator;
        this.washing_machine = washing_machine;
        this.air_condition = air_condition;
        this.wifi = wifi;
        this.beds = beds;
        this.water_heater = water_heater;
        this.chest = chest;
        this.desk = desk;
        this.cooking = cooking;
    }

    public Integer getHouse_id() {
        return house_id;
    }

    public void setHouse_id(Integer house_id) {
        this.house_id = house_id;
    }

    public Integer getTv() {
        return tv;
    }

    public void setTv(Integer tv) {
        this.tv = tv;
    }

    public Integer getRefrigerator() {
        return refrigerator;
    }

    public void setRefrigerator(Integer refrigerator) {
        this.refrigerator = refrigerator;
    }

    public Integer getWashing_machine() {
        return washing_machine;
    }

    public void setWashing_machine(Integer washing_machine) {
        this.washing_machine = washing_machine;
    }

    public Integer getAir_condition() {
        return air_condition;
    }

    public void setAir_condition(Integer air_condition) {
        this.air_condition = air_condition;
    }

    public Integer getWifi() {
        return wifi;
    }

    public void setWifi(Integer wifi) {
        this.wifi = wifi;
    }

    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public Integer getWater_heater() {
        return water_heater;
    }

    public void setWater_heater(Integer water_heater) {
        this.water_heater = water_heater;
    }

    public Integer getChest() {
        return chest;
    }

    public void setChest(Integer chest) {
        this.chest = chest;
    }

    public Integer getDesk() {
        return desk;
    }

    public void setDesk(Integer desk) {
        this.desk = desk;
    }

    public Integer getCooking() {
        return cooking;
    }

    public void setCooking(Integer cooking) {
        this.cooking = cooking;
    }
}
