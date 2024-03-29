package com.example.tools.utils;

import com.example.tools.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespMessage {
    RespCode respCode;
    RespData respData;
}
