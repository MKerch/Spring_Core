/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.consumer.topic;

import javax.jms.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author kerch
 */
@Component
public class MyTopicListener3 {
    
    @JmsListener(destination = "myTopicApp1", containerFactory = "myTopicFactory")
    public void onMessasge(Message msg) {
        System.out.println("@MyTopicListener3: " + msg);
    }
    
}
