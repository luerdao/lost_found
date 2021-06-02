package com.luerdao.dao;

import com.luerdao.entity.Comment;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface CommentMapper extends Mapper<Comment> {
    @Select("select* from comment where parent_comment_id=#{id}")
    List<Comment> findByParentId(long id);
}
