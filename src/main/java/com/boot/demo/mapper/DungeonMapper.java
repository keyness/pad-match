package com.boot.demo.mapper;

import com.boot.demo.entity.Dungeon;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Keyness on 2018/9/20.
 */
public interface DungeonMapper {

    List<Dungeon> findAll();

    void create(Dungeon dungeon);

    List<Dungeon> findByType(@Param("typeNo") String typeNo);
}
