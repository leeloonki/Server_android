package com.example.tools.service;

import com.example.tools.mapper.HostMapper;
import com.example.tools.mapper.UserMapper;
import com.example.tools.pojo.Host;
import com.example.tools.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostService {

    @Autowired
    private HostMapper hostMapper;

    //    增
    public int InsertHost(Host host){
        return hostMapper.InsertHost(host);
    }

    //    删
    public int DeleteHost(int id){
        return hostMapper.DeleteHost(id);
    }

    public List<Host> SelectHost(String host,int uid){
        return hostMapper.SelectHost(host,uid);
    }
    public List<Host> SelectAllHost(int uid){
        return hostMapper.SelectAllHost(uid);
    }
}
