package com.luerdao.service;

import com.luerdao.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {
    //查询出所有的评论
    List<Comment> listComment();
    //保存评论
    boolean saveComment(Comment comment);

}
