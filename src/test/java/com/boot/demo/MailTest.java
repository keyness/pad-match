package com.boot.demo;

import com.boot.demo.service.MailService;
import com.sun.mail.util.MailSSLSocketFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Properties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Keyness on 2018/4/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {

    @Autowired
    private MailService mailService;



    @Test
    public void test() throws Exception {
        mailService.sendSimpleMail("251329952@qq.com", "test simple mail.", "hello this is simple mail");
    }

}
