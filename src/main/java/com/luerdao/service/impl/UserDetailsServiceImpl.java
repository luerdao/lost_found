package com.luerdao.service.impl;

import com.luerdao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserServiceImpl userService;
    @Override
    public UserDetails loadUserByUsername(String stu_No) throws UsernameNotFoundException {
        if (stu_No==null){
            throw new RuntimeException("学号不能为空");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        User user = userService.getUser(stu_No);
        System.out.println(user);
        switch ((int) user.getRole()){
            case 0:
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
                grantedAuthorities.add(grantedAuthority);
                break;
            case 1:
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                break;
            case 2:
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_S_ADMIN"));
                break;
            default:
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        System.out.println(grantedAuthorities);
        System.out.println("用户注入成功");


        return new org.springframework.security.core.userdetails.User(user.getStuNo(),user.getPassword(),grantedAuthorities);
    }
}
