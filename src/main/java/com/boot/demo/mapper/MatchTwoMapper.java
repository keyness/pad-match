package com.boot.demo.mapper;

import com.boot.demo.entity.MatchTwo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Keyness on 2018/9/20.
 */
public interface MatchTwoMapper {

    void create(MatchTwo matchTwo);

    List<MatchTwo> findByDungeonId(@Param("id") Long id);

    void cleanMatchRoom();

    List<MatchTwo> findAll();
}
