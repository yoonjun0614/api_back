package com.api.api.signUp.controller;

import com.api.api.signUp.service.SignUpService;
import com.api.api.signUp.vo.SignUpVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Sign-Up")
@RequiredArgsConstructor
@Slf4j
public class SignUpController {


    @Qualifier("SignUpService")
    @Autowired
    private SignUpService signUpService;

    @PostMapping()
    @ResponseBody
    @CrossOrigin("*")
    public SignUpVO SignUp(SignUpVO vo) throws Exception {
        vo.setPassword(DigestUtils.sha256Hex(vo.getPassword()));
        signUpService.insertUser(vo);
        return vo;
    }

}
