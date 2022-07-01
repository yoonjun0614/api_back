package com.api.api.login.service;

import com.api.api.login.vo.LoginVO;

import java.util.LinkedHashMap;
import java.util.List;

public interface LoginService {

    List<LinkedHashMap> getLoginInfo(LoginVO vo);

    List<LinkedHashMap> getLoginIdchack(String loginId);
}
