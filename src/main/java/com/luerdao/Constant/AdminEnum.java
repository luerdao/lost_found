package com.luerdao.Constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum  AdminEnum {
    USER(0,"普通用户"),
    ADMIN(1,"管理员"),
    S_ADMIN(2,"超级管理员");

    private Integer code;
    private String desc;
}
