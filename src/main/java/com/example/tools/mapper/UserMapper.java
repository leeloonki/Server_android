package com.example.tools.mapper;

import com.example.tools.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface UserMapper{
//    增
    int InsertUser(User user);
//    删
    int DeleteUser(@Param("id") int id);
//    改
    int UpdateUser(User user);
//    查
    User SelectUser(@Param("username") String username);
    List<User> SelectAllUser();


}
    /*
        insert：   插入n条记录，返回影响行数n。（n>=1，n为0时实际为插入失败）

        update：更新n条记录，返回影响行数n。（n>=0）

        delete： 删除n条记录，返回影响行数n。（n>=0）
     */

