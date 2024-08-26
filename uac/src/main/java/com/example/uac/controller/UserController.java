package com.example.uac.controller;

import com.example.common.result.ResultBody;
import com.example.uac.model.vo.RegisterUserVo;
import com.example.uac.service.SystemUserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Resource
    private SystemUserService systemUserService;

    public ResultBody<String> registerUser(@RequestBody @Valid RegisterUserVo param){
        Boolean flag = systemUserService.registerUser(param);
        if(flag){
            return ResultBody.success("用户注册成功!");
        }
        return ResultBody.error("用户注册失败!");
    }
}
