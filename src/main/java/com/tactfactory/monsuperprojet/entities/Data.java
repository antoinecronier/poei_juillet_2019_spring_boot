package com.tactfactory.monsuperprojet.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Data extends EntityDb {

  private String name;
  @Column(name="description")
  private String desc;
  private LocalDateTime createdAt;

  @ManyToMany
  private List<Data> datas;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public List<Data> getDatas() {
    return datas;
  }

  public void setDatas(List<Data> datas) {
    this.datas = datas;
  }

  public Data() {
  }

  public Data(String name, String desc, LocalDateTime createdAt, List<Data> datas) {
    super();
    this.name = name;
    this.desc = desc;
    this.createdAt = createdAt;
    this.datas = datas;
  }

  public Data(String name, String desc, LocalDateTime createdAt) {
    super();
    this.name = name;
    this.desc = desc;
    this.createdAt = createdAt;
    this.datas = new ArrayList<Data>();
  }
}
