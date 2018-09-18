/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.producer;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author kerch
 */
@Component
public class MyJMSProducer {
    
    @Autowired
    @Qualifier("defaultSpringBeanConnectionFactory")
    private ConnectionFactory cf;
    @Autowired
    @Qualifier("queueSpringBeanName")
    private Destination destination;

    public void sendToQueue(String message) {
        try {
            Connection c = cf.createConnection();
            Session session = c.createSession(false, Session.AUTO_ACKNOWLEDGE);
            TextMessage msg = session.createTextMessage();
            msg.setText(message);
            MessageProducer producer = session.createProducer(destination);
            producer.send(msg);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    
}
