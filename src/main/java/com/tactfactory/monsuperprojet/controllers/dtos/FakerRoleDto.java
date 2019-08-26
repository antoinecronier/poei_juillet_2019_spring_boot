package com.tactfactory.monsuperprojet.controllers.dtos;

import com.tactfactory.monsuperprojet.entities.Role;

public class FakerRoleDto {

  private Role role;
  private Integer selector;
  private Integer minDatas;
  private Integer maxDatas;
  private Integer fixedDatas;

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public Integer getSelector() {
    return selector;
  }

  public void setSelector(Integer selector) {
    this.selector = selector;
  }

  public Integer getMinDatas() {
    return minDatas;
  }

  public void setMinDatas(Integer minDatas) {
    this.minDatas = minDatas;
  }

  public Integer getMaxDatas() {
    return maxDatas;
  }

  public void setMaxDatas(Integer maxDatas) {
    this.maxDatas = maxDatas;
  }

  public Integer getFixedDatas() {
    return fixedDatas;
  }

  public void setFixedDatas(Integer fixedDatas) {
    this.fixedDatas = fixedDatas;
  }

}
