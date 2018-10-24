package com.boot.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Keyness on 2018/10/16.
 */
@Entity
public class Location implements Serializable {

    private static final long serialVersionUID = -388689117947322104L;

    //主键
    @Id
    @GeneratedValue
    private Long id;
    //x轴
    @Column(nullable = false)
    private String xLocation;
    //y轴
    @Column(nullable = false)
    private String yLocation;
    //item
    @Column(nullable = false)
    private String item;
    //创建时间
    @Column(nullable = false)
    private Timestamp createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getxLocation() {
        return xLocation;
    }

    public void setxLocation(String xLocation) {
        this.xLocation = xLocation;
    }

    public String getyLocation() {
        return yLocation;
    }

    public void setyLocation(String yLocation) {
        this.yLocation = yLocation;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
