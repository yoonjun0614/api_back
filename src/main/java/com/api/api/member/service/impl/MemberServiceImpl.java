package com.api.api.member.service.impl;

import com.api.api.member.mapper.MemberMapper;
import com.api.api.member.service.MemberService;
import com.api.api.member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service("MemberService")
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public List<LinkedHashMap> getMemberList() {
        return memberMapper.getMemberList();
    }
}
