package com.boot.demo.mapper;

import com.boot.demo.entity.People;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface PeopleMapper {

    @Select("SELECT * FROM people")
    @Results({
        @Result(property = "userSex",  column = "user_sex"),
        @Result(property = "nickName", column = "nick_name")
    })
    List<People> getAll();

    @Insert("INSERT INTO PEOPLE (id, email, user_name, password, reg_time, nick_name) VALUES (#{id}, #{email}, #{userName}, #{password}, #{regTime}, #{nickName})")
    void insert(People people);

    void delete(Long id);

}
