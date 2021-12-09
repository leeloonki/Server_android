package com.example.tools.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cmds {
    private int id;
    private int uid;
    private String host;
    private String command;
    private String cmdtime;
}
