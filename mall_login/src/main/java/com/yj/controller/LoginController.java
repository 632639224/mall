package com.yj.controller;

import com.yj.service.LoginService;
import com.yj.vo.ResultVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @RequestMapping(value = "/login_WX", method = RequestMethod.POST)
    public ResultVo weiXinLogin(@RequestBody Map<String, String> map) {
        return loginService.weiXinLogin(map);
    }

}
