package com.yj.exception;

import com.yj.service.LoginService;
import com.yj.vo.ResultVo;

import java.util.Map;

public class LoginFeignClientFallback implements LoginService {
    @Override
    public ResultVo weiXinLogin(Map<String, String> params) {
        return ResultVo.buildFailureResult("RPC调用失败");
    }
}
