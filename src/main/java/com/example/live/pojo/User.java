package com.example.live.pojo;

public class User {
    //user_id不设置resultMap时获取的值为0，Integer默认把值置为null
    private Integer user_id;
    private String name;
    private String gender;
    private String email;
    private String password;
    private Integer role_id;
    private String phone;

    private UserRole userRole;

    private UserPersonalInfo userPersonalInfo;

    public User() {
    }

    public User(Integer user_id, String name, String gender, String email, String password, Integer role_id, String phone) {
        this.user_id = user_id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.role_id = role_id;
        this.phone = phone;
    }

    public User(String name, String gender, String email, String password, Integer role_id, String phone) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.role_id = role_id;
        this.phone = phone;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserPersonalInfo getUserPersonalInfo() {
        return userPersonalInfo;
    }

    public void setUserPersonalInfo(UserPersonalInfo userPersonalInfo) {
        this.userPersonalInfo = userPersonalInfo;
    }
}
