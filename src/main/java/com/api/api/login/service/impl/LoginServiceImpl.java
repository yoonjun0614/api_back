package com.api.api.login.service.impl;

import com.api.api.login.mapper.LoginMapper;
import com.api.api.login.service.LoginService;
import com.api.api.login.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public LoginVO getLoginIdchack(LoginVO vo) {
        return loginMapper.getLoginIdchack(vo);
    }

    @Override
    public LoginVO getLoginInfo(LoginVO vo) {
        return loginMapper.getLoginInfo(vo);
    }

    @Override
    public LoginVO getFindId(LoginVO vo) {
        return loginMapper.getFindId(vo);
    }

    @Override
    public LoginVO getFindPasswordPhone(LoginVO vo) {
        return loginMapper.getFindPasswordPhone(vo);
    }

    @Override
    public void putPasswordUpdate(LoginVO vo) {
        loginMapper.putPasswordUpdate(vo);
    }
}
