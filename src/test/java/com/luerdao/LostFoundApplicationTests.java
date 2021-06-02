package com.luerdao;

import com.luerdao.dao.CommentMapper;
import com.luerdao.dao.UserMapper;
import com.luerdao.entity.Comment;
import com.luerdao.entity.User;
import com.luerdao.service.CommentService;
import com.luerdao.service.impl.CommentServiceImpl;
import com.luerdao.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.transform.Source;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class LostFoundApplicationTests {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private CommentServiceImpl commentService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Test
    void contextLoads() {

        List<Comment> comments = commentService.listComment();
        System.out.println(comments);
    }

}
