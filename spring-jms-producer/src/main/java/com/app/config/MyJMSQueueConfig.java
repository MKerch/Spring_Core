/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.config;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

/**
 *
 * @author kerch
 */
@Configuration
@EnableJms
public class MyJMSQueueConfig {
    
    @Bean(name = "queueSpringBeanName")
    public Destination getQueueDestination(){
        return new ActiveMQQueue("appQueue1");
    }

    @Bean(name = "myQueueFactory")
    public JmsListenerContainerFactory<?> queueFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();// lambda function
        //factory.setErrorHandler(t -> System.err.println("An error has occurred in the transaction"));
        configurer.configure(factory, connectionFactory);
        return factory;
    }
    
}
