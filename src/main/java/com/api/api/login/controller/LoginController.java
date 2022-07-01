package com.api.api.login.controller;

import com.api.api.login.service.LoginService;
import com.api.api.login.vo.LoginVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("login")
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    @Qualifier("LoginService")
    @Autowired
    private LoginService loginService;

    @GetMapping
    @ResponseBody
    @CrossOrigin("*")
    public String LoginCheck(LoginVO vo) throws Exception {
        vo.setPassword(DigestUtils.sha256Hex(vo.getPassword()));
        List<LinkedHashMap> id = new ArrayList<>();
        List<LinkedHashMap> login = new ArrayList<>();
        id = loginService.getLoginIdchack(vo.getLoginId());
        String messag="로그인성공";
        if(id.isEmpty()){
            messag="해당 아이디가 존재하지 않습니다";
            return messag;
        }
        login = loginService.getLoginInfo(vo);
        if(login.isEmpty()){
            messag="비밀번호가 틀렸습니다";
            return messag;
        }
        return messag;
    }

    @GetMapping("SignUpIdCheck")
    @ResponseBody
    @CrossOrigin("*")
    public String SignUpCheck(LoginVO vo) throws Exception {
        List<LinkedHashMap> id = new ArrayList<>();
        id = loginService.getLoginIdchack(vo.getLoginId());
        String messag="해당 아이디는 사용중입니다";
        if(id.isEmpty()){
            messag="사용가능한 아이디 입니다";
            return messag;
        }
        return messag;
    }
    
    
}
