package com.boot.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Keyness on 2018/9/20.
 */
@Entity
public class Dungeon implements Serializable {

    private static final long serialVersionUID = 1776859616163146723L;

    //主键
    @Id
    @GeneratedValue
    private Long id;
    //名字
    @Column(nullable = false, unique = true)
    private String name;
    //种类
    @Column(nullable = false)
    private String type;
    //创建时间
    @Column(nullable = false)
    private Timestamp createTime;
    //状态
    @Column(nullable = false)
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
