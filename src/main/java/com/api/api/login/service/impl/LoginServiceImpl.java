package com.api.api.login.service.impl;

import com.api.api.login.mapper.LoginMapper;
import com.api.api.login.service.LoginService;
import com.api.api.login.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public List<LinkedHashMap> getLoginInfo(LoginVO vo) {
        return loginMapper.getLoginInfo(vo);
    }

    @Override
    public List<LinkedHashMap> getLoginIdchack(String loginId) {
        return loginMapper.getLoginIdchack(loginId);
    }
}
