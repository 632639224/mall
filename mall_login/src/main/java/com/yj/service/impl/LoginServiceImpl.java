package com.yj.service.impl;

import com.yj.service.LoginService;
import com.yj.vo.ResultVo;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public ResultVo weiXinLogin(Map<String, String> params) {
        System.out.println("成功进入");
        System.out.println(params.toString());
        return ResultVo.buildSuccessResult();
    }
}
