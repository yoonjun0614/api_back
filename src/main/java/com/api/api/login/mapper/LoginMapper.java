package com.api.api.login.mapper;


import com.api.api.login.vo.LoginVO;

import java.util.HashMap;

public interface LoginMapper {

    LoginVO getLoginInfo(LoginVO vo);

    LoginVO getLoginIdchack(LoginVO vo);

    LoginVO getFindId(LoginVO vo);

    LoginVO getFindPasswordPhone(LoginVO vo);

    void putPasswordUpdate(LoginVO vo);
}
