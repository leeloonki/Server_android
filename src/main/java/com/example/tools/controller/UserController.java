package com.example.tools.controller;

import com.example.tools.pojo.User;
import com.example.tools.service.UserService;

import com.example.tools.utils.LoginData;
import com.example.tools.utils.RespCode;
import com.example.tools.vo.voUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/user/signin")
    public LoginData getName(@RequestBody voUser vouser) {

        System.out.println("password: "+ vouser.getPassword());
        User user = userService.SelectUser(vouser.getUsername());
        LoginData loginData = new LoginData();
        RespCode respCode = new RespCode();
        if(user==null){
            user = new User();
            loginData.setUser(user);
            respCode.setRespCode_code(400);
            respCode.setRespCode_msg("用户不存在");
        }else{
            if(user.getPassword() == vouser.getPassword()){
                loginData.setUser(user);
                respCode.setRespCode_code(200);
                respCode.setRespCode_msg("登陆成功");
            }else{
                loginData.setUser(user);
                respCode.setRespCode_code(300);
                respCode.setRespCode_msg("密码错误");
            }
        }
        System.out.println("password2: "+ user.getPassword());
        loginData.setRespCode(respCode);
        System.out.println(loginData);
        return loginData;
    }
}
