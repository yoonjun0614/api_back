package com.api.api.member.mapper;

import com.api.api.member.vo.MemberVO;

import java.util.LinkedHashMap;
import java.util.List;

public interface MemberMapper {
    List<LinkedHashMap> getMemberList();
}
