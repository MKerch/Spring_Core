/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 *
 * @author kerch
 */
@Component
public class MySpringTemplateJMS {
    @Autowired
    private JmsTemplate jmsTemplate;
    
    public void sendToQueue(String message) {
        jmsTemplate.send(new MessageCreator(){
            
            @Override
            public Message createMessage(Session sn) throws JMSException {
                TextMessage msg = sn.createTextMessage();
                msg.setText(message);
                return msg;
            }
            
        });
    }
    
    
    
}
