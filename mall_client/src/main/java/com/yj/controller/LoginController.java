package com.yj.controller;

import com.yj.service.LoginService;
import com.yj.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("login")
@RestController
@Api(description = "登录注册")
public class LoginController extends BaseController {

    @Resource
    private LoginService loginService;

    @RequestMapping(value = "/login_WX", method = RequestMethod.GET)
    @ApiOperation(value = "商城登录", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "code", value = "微信小程序登录code码", required = false, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "name", value = "", required = false, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "type", value = "", required = false, dataType = "String"),
    })
    public ResultVo weiXinLogin(HttpServletRequest request, HttpServletResponse response) {
        return loginService.weiXinLogin(this.getRequestParams(request));
    }

}
