/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.producer.MyJMSProducer;
import com.app.producer.MyJMSTopicDurableProducer;
import com.app.producer.MySpringTemplateJMS;
import com.app.producer.MyTopicProducer;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kerch
 */
@RestController
public class MyController {

    @Autowired
    private MyJMSProducer myJMSProducer;
    @Autowired
    private MySpringTemplateJMS templateJMS;
    @Autowired
    private MyTopicProducer topicProducer; 
    @Autowired
    private MyJMSTopicDurableProducer durableProducer;

    @GetMapping(value = "/sendtoqueue/{msg}")
    public void sendToQueue(@PathVariable(name = "msg") String message) {
        myJMSProducer.sendToQueue(message);
    }
    
    @GetMapping(value = "/sendtoqueuetemplate/{msg}")
    public void sendToQueueWithTemplate(@PathVariable(name = "msg") String message) {
        templateJMS.sendToQueue(message);
    }
    
    @GetMapping(value = "/sendtotopic/{msg}")
    public void sendToTopic(@PathVariable(name = "msg") String message) {
       topicProducer.sendToQueue(message);
    }
    
    @GetMapping(value = "/sendtodurabletopic/{msg}")
    public void sendToDurableTopic(@PathVariable(name = "msg") String message) {
       durableProducer.sendToQueue(message);
    }

}
