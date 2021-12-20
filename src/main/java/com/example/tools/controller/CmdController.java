package com.example.tools.controller;

import com.example.tools.pojo.Cmds;
import com.example.tools.pojo.Host;
import com.example.tools.service.CmdsService;
import com.example.tools.utils.RespCode;
import com.example.tools.utils.Result;
import com.example.tools.vo.Uid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping("/cmd/querycmds")
    public Result<List<Cmds>> QueryCmds(@RequestBody Uid uid) {
        System.out.println("用户id为："+ uid.uid);
        List<Cmds> cmdsList = cmdsService.SelectAllCmd(uid.uid);
        Result<List<Cmds>> listResult = new Result<>();
        respCode.setRespCode_msg("查询成功");
        respCode.setRespCode_code(200);
        listResult.setRespCode(respCode);
        listResult.setData(cmdsList);
        System.out.println("------------------请求路径："+"/cmd/querycmds");
        System.out.println(listResult.toString());
        return listResult;
    }


}
