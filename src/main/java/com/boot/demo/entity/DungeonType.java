package com.boot.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Keyness on 2018/9/26.
 */
public class DungeonType implements Serializable {

    private static final long serialVersionUID = 452811314556518385L;

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = true, unique = true)
    private String typeNo;
    @Column(nullable = true)
    private String typeName;
    @Column(nullable = true)
    private Timestamp createTime;
    @Column(nullable = true)
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(String typeNo) {
        this.typeNo = typeNo;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
