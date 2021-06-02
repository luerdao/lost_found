package com.luerdao.service.impl;

import com.luerdao.dao.CommentMapper;
import com.luerdao.entity.Comment;
import com.luerdao.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    private List<Comment> tmpList = new ArrayList();
    @Override
    //根据id为“0”查询出所有父评论
    //根据父评论的id查询出一级子回复
    //根据子回复的id循环迭代查询出所有子集回复
    //将查询出来的子回复放到一个集合中
    //要注意将父评论的姓名给set进去，代码如下
    public List<Comment> listComment() {
//        Example example = new Example(Comment.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("parentCommentId",0);
//        List<Comment> comments = commentMapper.selectByExample(example);
        List<Comment> comments = commentMapper.findByParentId(Long.parseLong("0"));
        for (Comment comment:
             comments) {
            long parentID = comment.getId();
            String parentUsername = comment.getUsername();
            findChildComment(parentID,parentUsername);
            comment.setReplyComment(tmpList);
            tmpList = new ArrayList<>();
        }
        return comments;
    }

//    private void findChildComment(List<Comment>childComments,String parentUsername ){
//        if (childComments.size()>0){
//            for (Comment comment :
//                    childComments) {
//                comment.setParentUsername(parentUsername);
//                tmpList.add(comment);
//                long childId = comment.getId();
//                String childUsername = comment.getUsername();
//                findChildComment(childId,childUsername);
//            }
//        }
//    }

    private void findChildComment(Long id,String parentUsername ){
        List<Comment> comments = commentMapper.findByParentId(id);
        if (comments.size()>0){
            for (Comment comment :
                    comments) {
                comment.setParentUsername(parentUsername);
                tmpList.add(comment);
                long childId = comment.getId();
                String childUsername = comment.getUsername();
                findChildComment(childId,childUsername);
            }
        }
    }

    @Override
    public boolean saveComment(Comment comment) {
        comment.setCreateTime((Timestamp) new Date());
        int i = commentMapper.insert(comment);
        if (i==0)return false;
        return true;
    }
}
