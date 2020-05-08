package com.yj.service;

import com.yj.vo.ResultVo;

import java.util.Map;

public interface LoginService {
    ResultVo weiXinLogin(Map<String, String> params);
}
