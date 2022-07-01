package com.api.api.member.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberVO {

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
