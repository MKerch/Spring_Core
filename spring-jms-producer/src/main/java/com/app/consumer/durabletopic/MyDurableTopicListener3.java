/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.consumer.durabletopic;

import javax.jms.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author kerch
 */
@Component
public class MyDurableTopicListener3 {
    
    @JmsListener(destination = "myDurableTopicApp1", containerFactory = "myDurableTopicFactory3")
    public void onMessasge(Message msg) {
        System.out.println("@MyDurableTopicListener3: " + msg);
    }
    
}
