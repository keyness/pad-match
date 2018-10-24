package com.boot.demo.service;

import com.boot.demo.dao.DungeonRepository;
import com.boot.demo.entity.Dungeon;
import com.boot.demo.entity.DungeonType;
import com.boot.demo.entity.Friend;
import com.boot.demo.entity.MatchTwo;
import com.boot.demo.mapper.DungeonMapper;
import com.boot.demo.mapper.DungeonTypeMapper;
import com.boot.demo.mapper.FriendMapper;
import com.boot.demo.mapper.MatchTwoMapper;
import com.boot.demo.utils.DateUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Keyness on 2018/9/20.
 */
@Component
public class DungeonServiceImpl implements DungeonService {

    @Autowired
    private DungeonMapper dungeonMapper;
    @Autowired
    private MatchTwoMapper matchTwoMapper;
    @Autowired
    private DungeonTypeMapper dungeonTypeMapper;
    @Autowired
    private FriendMapper friendMapper;

    @Override
    public List<Dungeon> findAll() {
        return dungeonMapper.findAll();
    }

    @Override
    public void create(Dungeon dungeon) {
        dungeon.setCreateTime(DateUtil.getCurrentTimestamp());
        dungeon.setStatus("1");
        dungeonMapper.create(dungeon);
    }

    @Override
    public Map createMatchTwo(String dungeonName, String roomNum, String leader, String remark) {
        Map result = new HashMap();
        MatchTwo matchTwo = new MatchTwo();
        matchTwo.setRoomNum(roomNum);
        matchTwo.setLeader(leader);
        matchTwo.setCreateTime(DateUtil.getCurrentTimestamp());
        matchTwo.setRemark(remark);
        matchTwo.setStatus("1");
        matchTwo.setDungeonName(dungeonName);
        try{
            matchTwoMapper.create(matchTwo);
            result.put("result","success");
        } catch (Exception e) {
            result.put("result","failure");
        }
        return result;
    }

    @Override
    public Map findType() {
        Map result = new HashMap();
        List<DungeonType> types = dungeonTypeMapper.findType();
        result.put("types", types);
        return result;
    }

    @Override
    public Map findDungeon(String typeNo) {
        Map result = new HashMap();
        List<Dungeon> dungeons = dungeonMapper.findByType(typeNo);
        result.put("dungeons", dungeons);
        return result;
    }

    @Override
    public Map searchRoom(Long id) throws ParseException {
        Map result = new HashMap();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<MatchTwo> roomList = matchTwoMapper.findByDungeonId(id);
        for(MatchTwo matchTwo : roomList){
            Date createDate = sdf.parse(DateUtil.parseTimestampToString(matchTwo.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
            Long current = new Date().getTime();
            Long craete = createDate.getTime();
            int minutes = (int) ((current - craete) / (1000 * 60));
            matchTwo.setCreateTimeStr(minutes+"分钟前");
//            matchTwo.setCreateTimeStr(DateUtil.parseTimestampToString(matchTwo.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        result.put("roomList", roomList);
        return result;
    }

    @Override
    public void cleanMatchRoom() {
        matchTwoMapper.cleanMatchRoom();
    }

    @Override
    public Map createFriend(String leader, String id, String remark) {
        Map result = new HashMap();
        Friend friend = new Friend();
        friend.setLeader(leader);
        friend.setUserId(id);
        friend.setRemark(remark);
        friend.setCreateTime(DateUtil.getCurrentTimestamp());
        try{
            friendMapper.create(friend);
            result.put("result","success");
        } catch (Exception e) {
            result.put("result","failure");
        }
        return result;
    }

    @Override
    public Map searchRooms() throws ParseException {
        Map result = new HashMap();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<MatchTwo> roomList = matchTwoMapper.findAll();
        for(MatchTwo matchTwo : roomList){
            Date createDate = sdf.parse(DateUtil.parseTimestampToString(matchTwo.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
            Long current = new Date().getTime();
            Long craete = createDate.getTime();
            int minutes = (int) ((current - craete) / (1000 * 60));
            matchTwo.setCreateTimeStr(minutes+"分钟前");
//            matchTwo.setCreateTimeStr(DateUtil.parseTimestampToString(matchTwo.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        result.put("roomList", roomList);
        return result;
    }
}
