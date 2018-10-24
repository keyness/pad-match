package com.boot.demo.task;

import com.boot.demo.service.DungeonService;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Keyness on 2018/4/11.
 */
@Component
public class MyTask {

    @Autowired
    private DungeonService dungeonService;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//    @Scheduled(fixedRate = 6000)
//    public void reportCurrentTime() {
//        System.out.println("现在时间：" + dateFormat.format(new Date()));
//    }

    @Scheduled(fixedRate = 60000)
    public void cleanMatchRoom() {
        dungeonService.cleanMatchRoom();
        System.out.println("清理成功");
    }

}
