package com.boot.demo.controller;

import com.boot.demo.entity.Dungeon;
import com.boot.demo.service.DungeonService;
import com.boot.demo.utils.PropertyUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.Buffer;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Keyness on 2018/9/20.
 */
@RestController
@RequestMapping("/dungeon")
public class DungeonController {

    @Autowired
    private DungeonService dungeonService;

    @RequestMapping(value = "/find.do")
    @ResponseBody
    public String find(){
        List<Dungeon> lists = dungeonService.findAll();
        for(Dungeon dungeon :lists){
            System.out.println(dungeon.getName());
        }
        return null;
    }

    @RequestMapping(value = "/upload.do")
    @ResponseBody
    public String upload(){
        try{
            File file = new File(PropertyUtil.AuthorizePropertyUtil.getProperty("upload.path"));
//            File file = new File("e:\\pad.txt");
            InputStream inputStream = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String line = null;
            while((line = reader.readLine()) != null){
                String[] arr = line.split("\\|");
                String name = arr[0];
                String type = arr[1];
                System.out.println(name+"------"+type);
                Dungeon dungeon = new Dungeon();
                dungeon.setName(name);
                dungeon.setType(type);
                dungeonService.create(dungeon);
            }
            return "success";
        }catch (Exception e){
            System.out.println("error:"+e.getMessage());
        }
        return "failure";
    }

    @RequestMapping(value = "/match-two")
    @ResponseBody
    public String createMatchTwo(String dungeonName, String roomNum, String leader, String remark, HttpServletResponse response) throws IOException {
        Map map = dungeonService.createMatchTwo(dungeonName, roomNum, leader, remark);
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(JSONObject.fromObject(map).toString());
        return null;
    }

    @RequestMapping(value = "/create-friend")
    @ResponseBody
    public String createFriend(String leader, String id, String remark, HttpServletResponse response) throws IOException {
        Map map = dungeonService.createFriend(leader, id, remark);
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(JSONObject.fromObject(map).toString());
        return null;
    }

    @RequestMapping(value = "/findType")
    @ResponseBody
    public String findType(HttpServletResponse response) throws IOException {
        Map map = dungeonService.findType();
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(JSONObject.fromObject(map).toString());
        return null;
    }

    @RequestMapping(value = "/findDungeon")
    @ResponseBody
    public String findDungeon(int index, HttpServletResponse response) throws IOException {
        String typeNo = (index+1)+"";
        Map map = dungeonService.findDungeon(typeNo);
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(JSONObject.fromObject(map).toString());
        return null;
    }

    @RequestMapping(value = "/searchRoom")
    @ResponseBody
    public String searchRoom(Long id, HttpServletResponse response) throws IOException, ParseException {
        Map map = dungeonService.searchRoom(id);
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(JSONObject.fromObject(map).toString());
        return null;
    }

    @RequestMapping(value = "/searchRooms")
    @ResponseBody
    public String searchRooms(HttpServletResponse response) throws IOException, ParseException {
        Map map = dungeonService.searchRooms();
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(JSONObject.fromObject(map).toString());
        return null;
    }

}
