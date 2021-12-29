package com.shop.RetailStore.core.dto;

import com.shop.RetailStore.core.UserType;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UserDto implements Serializable {

    private UserType type;
    private  String userName;
    private  LocalDateTime joiningDate;

    public UserDto(){}

    public UserDto(Integer type, String userName) {
        this.type = type==0? UserType.EMPLOYEE : (type==1? UserType.AFFILIATE:UserType.SIMPLE);
        this.userName = userName;
        joiningDate = LocalDateTime.now();
    }

    public UserDto(Integer type, String userName, LocalDateTime joiningDate) {
        this.type = type==0? UserType.EMPLOYEE : (type==1? UserType.AFFILIATE:UserType.SIMPLE);
        this.userName = userName;
        this.joiningDate = joiningDate;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDateTime joiningDate) {
        this.joiningDate = joiningDate;
    }
}
