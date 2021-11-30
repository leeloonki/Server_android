package com.example.tools.service;

import com.example.tools.mapper.UserMapper;
import com.example.tools.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int InsertUser(User user){
        return userMapper.InsertUser(user);
    }

    public int DeleteUser(int id){
        return userMapper.DeleteUser(id);
    }

    public int UpdateUser(User user){
        return userMapper.UpdateUser(user);
    }

    public User SelectUser(String username){
        return userMapper.SelectUser(username);
    }
    public List<User> SelectAllUser(){
        return userMapper.SelectAllUser();
    }
}
