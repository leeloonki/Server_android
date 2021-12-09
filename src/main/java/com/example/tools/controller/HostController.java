package com.example.tools.controller;

import com.example.tools.pojo.Host;
import com.example.tools.pojo.User;
import com.example.tools.service.HostService;
import com.example.tools.utils.RespCode;
import com.example.tools.utils.Result;
import com.example.tools.vo.Hid;
import com.example.tools.vo.Uid;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HostController {

    @Autowired
    private HostService hostService;

    RespCode respCode = new RespCode();
    @RequestMapping("/host/addhost")
    public RespCode AddHost(@RequestBody Host host) {
        System.out.println(host.toString());
        if(hostService.InsertHost(host)==1){
            respCode.setRespCode_msg("host添加成功");
            respCode.setRespCode_code(200);
        }else{
            respCode.setRespCode_msg("host添加失败");
            respCode.setRespCode_code(400);
        }
        System.out.println("------------------请求路径："+"/host/addhost");
        System.out.println(respCode.toString());
        return respCode;
    }

    @RequestMapping("/host/queryhost")
    public Result<List<Host>> QueryHost(@RequestBody Uid uid) {
        System.out.println(uid.uid);
        List<Host> hostList = hostService.SelectAllHost(uid.uid);
        Result<List<Host>> hostlist = new Result<>();

        respCode.setRespCode_msg("查询成功");
        respCode.setRespCode_code(200);
        hostlist.respCode = respCode;
        for (Host host : hostList) {
            System.out.println(host);
        }
        hostlist.data=hostList;
        System.out.println("------------------请求路径："+"/host/queryhost");
        System.out.println(respCode.toString());
        return hostlist;
    }

    @RequestMapping("/host/deletehost")
    public RespCode DeleteHost(@RequestBody Hid hid) {
        System.out.println(hid.toString());
        if (hostService.DeleteHost(hid.id) == 1) {
            respCode.setRespCode_msg("删除成功");
            respCode.setRespCode_code(200);
        } else {
            respCode.setRespCode_msg("删除失败");
            respCode.setRespCode_code(400);
        }
        System.out.println("------------------请求路径："+"/host/deletehost");
        System.out.println(respCode.toString());
        return respCode;
    }
}
