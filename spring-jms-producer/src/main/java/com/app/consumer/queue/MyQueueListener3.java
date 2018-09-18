/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.consumer.queue;

import javax.jms.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author kerch
 */
@Component
public class MyQueueListener3 {

    @JmsListener(destination = "myQueue1", containerFactory = "myQueueFactory")
    public void onMessasge(Message msg) {
        System.out.println("@MyQueueListener3: " + msg);
    }

}
