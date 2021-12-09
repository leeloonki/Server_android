package com.example.tools.service;

import com.example.tools.mapper.CmdsMapper;
import com.example.tools.pojo.Cmds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmdsService {

    @Autowired
    private CmdsMapper cmdsMapper;

    public int InsertCmd(Cmds cmds){
        return cmdsMapper.InsertCmd(cmds);
    }

    public int DeleteCmd(int id){
        return cmdsMapper.DeleteCmd(id);
    }

    public List<Cmds> SelectAllCmd(String uid){
        return cmdsMapper.SelectCmd(uid);
    }
}


