package com.luerdao.service;

import com.luerdao.entity.User;

import java.util.List;


public interface UserService {
     public User getUser(String stuNo);

     public boolean getPassword(String stuNo,String password);

     public Integer getRoleByStuNo(String stuNo);

     public List<User> getAllUsers();

     public boolean deleteUser(String id);

     public boolean addUser(User user);

     public User updateUser();




}
