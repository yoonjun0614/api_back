package com.api.api.signUp.service.impl;

import com.api.api.signUp.mapper.SignUpMapper;
import com.api.api.signUp.service.SignUpService;
import com.api.api.signUp.vo.SignUpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("SignUpService")
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private SignUpMapper signUpMapper;

    @Override
    public void insertUser(SignUpVO vo) {
        signUpMapper.insertUser(vo);
    }
}
