package com.luerdao.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LostArticle {
  @Id
  private long id;
  private String kind;
  private String about;
  private String image;
  private long creatorStuNo;
  private java.sql.Timestamp createTime;
  private String location;
  private long status;

}
