package com.luerdao.dao;

import com.luerdao.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {
    @Select("select password from user where stu_no=#{stuNo}")
    public String getPassword(String stuNo);
    @Select("select role from user where stu_no=#{stuNo} ")
    public Integer getRoleByStuNo(String stuNo);
    @Select("select * from user where stu_no = #{stuNo}")
    public User getUserBystuNo(String stuNo);
    @Select("select stu_no from user where username=#{username}")
    public String getStuByName(String username);
}
