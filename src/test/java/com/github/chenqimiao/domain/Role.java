package com.github.chenqimiao.domain;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/18 17:13
 * @Description:
 */
public class Role {
  private long id;
  private String roleName;
  private String note;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }
}
