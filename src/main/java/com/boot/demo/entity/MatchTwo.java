package com.boot.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Keyness on 2018/9/21.
 */
public class MatchTwo implements Serializable {

    private static final long serialVersionUID = 3062993090827002277L;

    //主键
    @Id
    @GeneratedValue
    private Long id;
    //房间号
    @Column(nullable = false, unique = true)
    private String roomNum;
    //队长
    @Column(nullable = true)
    private String leader;
    //创建时间
    @Column(nullable = false)
    private Timestamp createTime;
    //备注
    @Column(nullable = true)
    private String remark;
    //状态
    @Column(nullable = false)
    private String status;
    //副本名
    @Column(nullable = false)
    private String dungeonName;

    private String createTimeStr;

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDungeonName() {
        return dungeonName;
    }

    public void setDungeonName(String dungeonName) {
        this.dungeonName = dungeonName;
    }
}
