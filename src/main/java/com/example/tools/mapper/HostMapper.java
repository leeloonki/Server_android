package com.example.tools.mapper;


import com.example.tools.pojo.Host;
import com.example.tools.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HostMapper {
    //    添加一条host
    int InsertHost(Host host);
    //    删除host记录
    int DeleteHost(@Param("id") int id);
    //    修改host记录
    int UpdateHost(Host host);
//    查询特定主机的host记录
    List<Host> SelectHost(@Param("host") String host,@Param("uid") int uid);
    //    查寻某用户所有host记录
    List<Host> SelectAllHost(@Param("uid") int uid);
}
