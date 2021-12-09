package com.example.tools.controller;

import com.example.tools.pojo.Cmds;
import com.example.tools.service.CmdsService;
import com.example.tools.utils.RespCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CmdController {

    @Autowired
    CmdsService cmdsService;

    RespCode respCode=new RespCode();

    @RequestMapping("/cmd/addcmds")
    public RespCode AddHost(@RequestBody Cmds cmds) {
        System.out.println(cmds.toString());
        if(cmdsService.InsertCmd(cmds)==1){
            respCode.setRespCode_code(200);
            respCode.setRespCode_msg("添加成功");
        }else{
            respCode.setRespCode_code(400);
            respCode.setRespCode_msg("添加失败");
        }
        System.out.println("------------------请求路径："+"/cmd/addcmds");
        System.out.println(respCode.toString());
        return respCode;
    }
}
