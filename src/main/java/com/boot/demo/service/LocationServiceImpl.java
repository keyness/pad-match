package com.boot.demo.service;

import com.boot.demo.entity.Location;
import com.boot.demo.mapper.LocationMapper;
import com.boot.demo.utils.DateUtil;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Keyness on 2018/10/16.
 */
@Component
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationMapper locationMapper;

    @Override
    public HashMap<String, String> create(String xLocation, String yLocation, String item, HashMap<String, String> map) {
        Location location = new Location();
        location.setxLocation(xLocation);
        location.setyLocation(yLocation);
        location.setItem(item);
        location.setCreateTime(DateUtil.getCurrentTimestamp());
        try{
            locationMapper.create(location);
            map.put("respMsg", "添加成功");
            return map;
        }catch(Exception e){
            map.put("respMsg", "添加失败");
            return map;
        }
    }
}
