package com.luerdao.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  @Id
  private long id;
  private String username;
  private String password;
  private String stuNo;
  private String email;
  private String phoneNumber;
  private long collegeId;
  private String qq;
  private String vx;
  private String icon;
  private long gender;
  private long role;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getStuNo() {
    return stuNo;
  }

  public void setStuNo(String stuNo) {
    this.stuNo = stuNo;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }


  public long getCollegeId() {
    return collegeId;
  }

  public void setCollegeId(long collegeId) {
    this.collegeId = collegeId;
  }


  public String getQq() {
    return qq;
  }

  public void setQq(String qq) {
    this.qq = qq;
  }


  public String getVx() {
    return vx;
  }

  public void setVx(String vx) {
    this.vx = vx;
  }


  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }


  public long getGender() {
    return gender;
  }

  public void setGender(long gender) {
    this.gender = gender;
  }


  public long getRole() {
    return role;
  }

  public void setRole(long role) {
    this.role = role;
  }

}
