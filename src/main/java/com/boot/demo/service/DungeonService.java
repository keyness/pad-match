package com.boot.demo.service;

import com.boot.demo.entity.Dungeon;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * Created by Keyness on 2018/9/20.
 */
@Service
public interface DungeonService {
    List<Dungeon> findAll();

    void create(Dungeon dungeon);

    Map createMatchTwo(String dungeonName, String roomNum, String leader, String remark);

    Map findType();

    Map findDungeon(String typeNo);

    Map searchRoom(Long id) throws ParseException;

    void cleanMatchRoom();

    Map createFriend(String leader, String id, String remark);

    Map searchRooms() throws ParseException;
}
