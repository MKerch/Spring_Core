/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.starter;

import com.app.config.MyJMSDurableTopicConfig;
import com.app.config.MyJMSQueueConfig;
import com.app.config.MyJMSTopicConfig;
import com.app.config.MySpringConfig;
import org.springframework.boot.SpringApplication;

/**
 *
 * @author kerch
 */
public class Main {
    
    public static void main(String[] args) {
        SpringApplication.run(new Object[]{MySpringConfig.class, MyJMSQueueConfig.class, MyJMSTopicConfig.class, MyJMSDurableTopicConfig.class}, args);
    }
    
}
