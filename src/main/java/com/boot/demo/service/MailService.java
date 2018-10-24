package com.boot.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Keyness on 2018/4/11.
 */
public interface MailService {

    void sendSimpleMail(String to, String subject, String content) throws Exception;

}
