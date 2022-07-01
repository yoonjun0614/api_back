package com.api.api.login.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LoginVO {

    private String uid;
    private String loginId;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String company;
    private String department;
    private String regDt;
    private String uptDt;

}
