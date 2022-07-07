package com.api.api.login.service;


import com.api.api.login.vo.LoginVO;

public interface LoginService {

    LoginVO getLoginIdchack(LoginVO vo);

    LoginVO getLoginInfo(LoginVO vo);

    LoginVO getFindId(LoginVO vo);

    LoginVO getFindPasswordPhone(LoginVO vo);

    void putPasswordUpdate(LoginVO vo);
}
