/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.config;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author kerch
 */
@SpringBootApplication
@EnableWebMvc
@ComponentScan(basePackages = {"com"})
@EnableJms
public class MySpringConfig {
    @Autowired
    @Qualifier("queueSpringBeanName")
    private Destination destination;
    
    
    @Bean(name = "defaultSpringBeanConnectionFactory")
    public ConnectionFactory getConnectionFactory(){
        return new ActiveMQConnectionFactory();
    }
    
    @Bean
    public JmsTemplate getJmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(getConnectionFactory());
        template.setDefaultDestination(destination);
        return template;
    }
    
}
