package com.boot.demo;

import com.boot.demo.dao.PeopleRepository;
import com.boot.demo.entity.People;
import com.boot.demo.mapper.PeopleMapper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Keyness on 2018/4/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PeopleRepositoryTest {

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private PeopleMapper peopleMapper;

    @Test
    public void test(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //peopleRepository.save(new People(1L, "keyness", "123456","11@qq.com","kk",sdf.format(new Date())));

        //People people = peopleRepository.findByUserName("keyness");

        People p = new People();
        p.setId(2L);
        p.setUserName("ll");
        p.setPassword("aa1234");
        p.setEmail("22@qq.com");
        p.setNickName("lisa");
        p.setRegTime(sdf.format(new Date()));

        peopleMapper.insert(p);

        List<People> list = peopleMapper.getAll();
        for (People people : list) {
            System.out.println(people.toString());
        }
    }

    @Test
    public void deleteTest(){
        peopleMapper.delete(1L);

        List<People> list = peopleMapper.getAll();
        for (People people : list) {
            System.out.println(people.toString());
        }
    }

}
