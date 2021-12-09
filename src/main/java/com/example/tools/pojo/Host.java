package com.example.tools.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Host {
    private int id;
    private int uid;
    private String host;
    private int port;
    private String username;
    private String password;
}
