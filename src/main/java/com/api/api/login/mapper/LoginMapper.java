package com.api.api.login.mapper;

import com.api.api.login.vo.LoginVO;

import java.util.LinkedHashMap;
import java.util.List;

public interface LoginMapper {

    List<LinkedHashMap> getLoginInfo(LoginVO vo);

    List<LinkedHashMap> getLoginIdchack(String loginId);
}
