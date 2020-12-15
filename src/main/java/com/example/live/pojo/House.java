package com.example.live.pojo;

public class House {
    private Integer house_id;
    private String  title;
    private String city;
    private String region;
    private String address;
    private String house_type;
    private String rent;
    private String rent_way;
    private String rent_type;
    private Integer number_of_people;
    private String elevator;
    private String toward;
    private String carport;
    private String energy_charge;
    private String water_charge;
    private String acreage;
    private String layout;
    private String introduction;
    private String status;
    private String picture;
    private String pictureUrl;
    private String time;

    private LandlordHouseRelation landlordHouseRelation;

    private Allocation allocation;

    private Feature feature;

    public House() {
    }

    public House(String title, String city, String region, String address, String house_type, String rent, String rent_way, String rent_type, Integer number_of_people, String elevator, String toward, String carport, String energy_charge, String water_charge, String acreage, String layout, String introduction, String status, String picture, String pictureUrl, LandlordHouseRelation landlordHouseRelation, Allocation allocation) {
        this.title = title;
        this.city = city;
        this.region = region;
        this.address = address;
        this.house_type = house_type;
        this.rent = rent;
        this.rent_way = rent_way;
        this.rent_type = rent_type;
        this.number_of_people = number_of_people;
        this.elevator = elevator;
        this.toward = toward;
        this.carport = carport;
        this.energy_charge = energy_charge;
        this.water_charge = water_charge;
        this.acreage = acreage;
        this.layout = layout;
        this.introduction = introduction;
        this.status = status;
        this.picture = picture;
        this.pictureUrl = pictureUrl;
        this.landlordHouseRelation = landlordHouseRelation;
        this.allocation = allocation;
    }

    public Integer getHouse_id() {
        return house_id;
    }

    public void setHouse_id(Integer house_id) {
        this.house_id = house_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHouse_type() {
        return house_type;
    }

    public void setHouse_type(String house_type) {
        this.house_type = house_type;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getRent_way() {
        return rent_way;
    }

    public void setRent_way(String rent_way) {
        this.rent_way = rent_way;
    }

    public String getRent_type() {
        return rent_type;
    }

    public void setRent_type(String rent_type) {
        this.rent_type = rent_type;
    }

    public Integer getNumber_of_people() {
        return number_of_people;
    }

    public void setNumber_of_people(Integer number_of_people) {
        this.number_of_people = number_of_people;
    }

    public String getElevator() {
        return elevator;
    }

    public void setElevator(String elevator) {
        this.elevator = elevator;
    }

    public String getToward() {
        return toward;
    }

    public void setToward(String toward) {
        this.toward = toward;
    }

    public String getCarport() {
        return carport;
    }

    public void setCarport(String carport) {
        this.carport = carport;
    }

    public String getEnergy_charge() {
        return energy_charge;
    }

    public void setEnergy_charge(String energy_charge) {
        this.energy_charge = energy_charge;
    }

    public String getWater_charge() {
        return water_charge;
    }

    public void setWater_charge(String water_charge) {
        this.water_charge = water_charge;
    }

    public String getAcreage() {
        return acreage;
    }

    public void setAcreage(String acreage) {
        this.acreage = acreage;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public LandlordHouseRelation getLandlordHouseRelation() {
        return landlordHouseRelation;
    }

    public void setLandlordHouseRelation(LandlordHouseRelation landlordHouseRelation) {
        this.landlordHouseRelation = landlordHouseRelation;
    }

    public Allocation getAllocation() {
        return allocation;
    }

    public void setAllocation(Allocation allocation) {
        this.allocation = allocation;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }
}
