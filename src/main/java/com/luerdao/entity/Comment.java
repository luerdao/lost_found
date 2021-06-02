package com.luerdao.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
  @Id
  private long id;
  private String username;
  private String email;
  private String content;
  private String icon;
  private java.sql.Timestamp createTime;
  private long parentCommentId;
  //非数据库字段
  @Transient
  private List<Comment> replyComment;
  @Transient
  private Comment parentComment;
  @Transient
  private String parentUsername;

}
