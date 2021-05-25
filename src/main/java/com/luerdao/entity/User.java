package com.luerdao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import tk.mybatis.mapper.annotation.ColumnType;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private Integer id;
    private String username;
    private String password;
    @ColumnType(column = "stu_no")
    private String stuNo;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    private Integer collegeId;
    private String qq;
    private String vx;
    private String icon;
    private Integer gender;
    private Integer role;

}
