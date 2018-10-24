package com.boot.demo.service;

import com.boot.demo.mapper.FriendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Keyness on 2018/10/24.
 */
@Component
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendMapper friendMapper;

}
