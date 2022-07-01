package com.api.api.member.controller;

import com.api.api.member.service.MemberService;
import com.api.api.member.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {


    @Qualifier("MemberService")
    @Autowired
    private MemberService memberService;

    @GetMapping
    @ResponseBody
    @CrossOrigin("*")
    public List<LinkedHashMap> MemberList() throws Exception {
        List<LinkedHashMap> dataList = new ArrayList<>();
        dataList = memberService.getMemberList();
        return dataList;
    }

}
