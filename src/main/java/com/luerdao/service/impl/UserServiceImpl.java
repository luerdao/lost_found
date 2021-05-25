package com.luerdao.service.impl;

import com.luerdao.dao.UserMapper;
import com.luerdao.entity.User;
import com.luerdao.service.UserService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUser(String stuNo) {
        return userMapper.getUserBystuNo(stuNo);
    }

    @Override

    public boolean getPassword(String stuNo,String password) {
        String password1 = userMapper.getPassword(stuNo);
        System.out.println(password1);
        if (password.equals(password1)) {

            return true;
        }
        return false;
    }

    @Override
    public Integer getRoleByStuNo(String stuNo) {
        return userMapper.getRoleByStuNo(stuNo);
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.selectAll();
    }

    @Override
    public boolean deleteUser(String id) {
        int i = userMapper.deleteByPrimaryKey(id);
        if (i==1)
        return true;
        else return false;
    }

    @Override
    public boolean addUser(User user) {
        int i = userMapper.insert(user);
        if (i==1) return true;
        else return false;
    }

    @Override
    public User updateUser() {
        return null;
    }
}
