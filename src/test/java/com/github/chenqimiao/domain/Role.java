package com.github.chenqimiao.domain;

import java.io.Serializable;

/**
 * @Auther: chenqimiao
 * @Date: 2020/3/18 17:13
 * @Description:
 */
public class Role implements Serializable {

  private static final long serialVersionUID = -3081300947672286908L;
  
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

  @Override
  public String toString() {
    return "Role{" +
      "id=" + id +
      ", roleName='" + roleName + '\'' +
      ", note='" + note + '\'' +
      '}';
  }
}
