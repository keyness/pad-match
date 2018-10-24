package com.boot.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Keyness on 2018/10/24.
 */
@Entity
public class Friend implements Serializable {

    private static final long serialVersionUID = 6125010303647550620L;

    //主键
    @Id
    @GeneratedValue
    private Long id;
    //常用对长
    @Column(nullable = false)
    private String leader;
    //id
    @Column(nullable = false)
    private String userId;
    //备注
    @Column(nullable = true)
    private String remark;
    //创建时间
    @Column(nullable = false)
    private Timestamp createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
