package com.api.api.member.service;

import com.api.api.member.vo.MemberVO;

import java.util.LinkedHashMap;
import java.util.List;

public interface MemberService{

    List<LinkedHashMap> getMemberList();
}
