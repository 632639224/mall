package com.yj.service;
import com.yj.exception.LoginFeignClientFallback;
import com.yj.vo.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;


@FeignClient(name = "compute-service-login",
        url = "http://127.0.0.1:6666",
        fallback = LoginFeignClientFallback.class,
        configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface LoginService {
    @RequestMapping(value = "/compute-service-login/login/login_WX", method = RequestMethod.POST)
    ResultVo weiXinLogin(Map<String, String> params);
}
