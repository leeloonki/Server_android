package com.example.tools.controller;

import com.example.tools.pojo.User;
import com.example.tools.service.UserService;

import com.example.tools.utils.RespCode;
import com.example.tools.utils.Result;
import com.example.tools.vo.voUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    RespCode respCode = new RespCode();
    @Autowired
    private UserService userService;
    private Result<User> userResult = new Result<User>();
    @RequestMapping("/user/signin")
    public Result<User> SignIn(@RequestBody voUser vouser) {

        System.out.println("vouser: "+ vouser.toString());
        User user = userService.SelectUser(vouser.getUsername());

        if(user==null){
            respCode.setRespCode_code(400);
            respCode.setRespCode_msg("用户不存在");
        }else{
            if(user.getPassword() == vouser.getPassword()){
                userResult.setData(user);
                respCode.setRespCode_code(200);
                respCode.setRespCode_msg("登陆成功");
            }else{
                userResult.setData(user);
                respCode.setRespCode_code(300);
                respCode.setRespCode_msg("密码错误");
            }
        }
        userResult.setRespCode(respCode);
        System.out.println("------------------请求路径："+"/user/signin");
        System.out.println(userResult.toString());
        return userResult;
    }

    @RequestMapping("/user/signup")
    public Result<User> SignUp(@RequestBody User user) {
        System.out.println(user);
        if(userService.SelectUser(user.getUsername())==null){
            int res = userService.InsertUser(user);
            if(res==1){
                respCode.setRespCode_code(200);
                respCode.setRespCode_msg("注册成功");
                userResult.setRespCode(respCode);
                userResult.setData(user);
            }
        }else{
            respCode.setRespCode_msg("用户名已存在");
            respCode.setRespCode_code(400);
        }
        System.out.println("------------------请求路径："+"/user/signup");
        System.out.println(userResult.toString());
        return userResult;
    }
}
