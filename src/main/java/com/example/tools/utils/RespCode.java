package com.example.tools.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespCode {
    private int respCode_code;
    private String respCode_msg;
}
