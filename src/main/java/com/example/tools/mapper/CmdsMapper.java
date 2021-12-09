package com.example.tools.mapper;

import com.example.tools.pojo.Cmds;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CmdsMapper {
    //    增
    int InsertCmd(Cmds cmds);
    //    删
    int DeleteCmd(@Param("id") int id);
    //    改
//    int UpdateCmd(Cmds cmds);
    //    查寻某个用户执行的所有操作
    List<Cmds> SelectCmd(@Param("uid") String uid);
}
