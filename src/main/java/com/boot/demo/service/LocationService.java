package com.boot.demo.service;

import java.util.HashMap;
import org.springframework.stereotype.Service;

/**
 * Created by Keyness on 2018/10/16.
 */
@Service
public interface LocationService {
    HashMap<String, String> create(String xLocation, String yLocation, String item, HashMap<String, String> map);
}
