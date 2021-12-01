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

    LoginData loginData = new LoginData();
    RespCode respCode = new RespCode();
    @Autowired
    private UserService userService;
    @RequestMapping("/user/signin")

    public LoginData SignIn(@RequestBody voUser vouser) {

        System.out.println("password: "+ vouser.getPassword());
        User user = userService.SelectUser(vouser.getUsername());
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

    @RequestMapping("/user/signup")
    public LoginData SignUp(@RequestBody User user) {
        System.out.println(user);
        if(userService.SelectUser(user.getUsername())==null){
            int res = userService.InsertUser(user);
            if(res==1){
                respCode.setRespCode_code(200);
                respCode.setRespCode_msg("注册成功");
                loginData.setRespCode(respCode);
                loginData.setUser(user);
            }
        }else{
            respCode.setRespCode_msg("用户名已存在");
            respCode.setRespCode_code(400);
            loginData.setUser(user);
            loginData.setRespCode(respCode);
        }
        return loginData;
    }
}
