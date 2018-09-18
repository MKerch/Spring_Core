/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.config;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author kerch
 */

@SpringBootApplication
@EnableWebMvc
@ComponentScan(basePackages = {"com"})
@EnableJms
public class MyJMSDurableTopicConfig {
    
    @Bean(name = "durableTopicSpringBeanName")
    public Destination getQueueDestination(){
        return new ActiveMQTopic("myDurableTopicApp1");
    }

    @Bean(name = "myDurableTopicFactory1")
    public JmsListenerContainerFactory<?> queueFactory1(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();// lambda function        
        configurer.configure(factory, connectionFactory);
        factory.setPubSubDomain(true);
        factory.setSubscriptionDurable(true);
        factory.setClientId("topicDurable1");
        return factory;
    }
    
    @Bean(name = "myDurableTopicFactory2")
    public JmsListenerContainerFactory<?> queueFactory2(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();// lambda function        
        configurer.configure(factory, connectionFactory);
        factory.setPubSubDomain(true);
        factory.setSubscriptionDurable(true);
        factory.setClientId("topicDurable2");
        return factory;
    }
    
    @Bean(name = "myDurableTopicFactory3")
    public JmsListenerContainerFactory<?> queueFactory(ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();// lambda function        
        configurer.configure(factory, connectionFactory);
        factory.setPubSubDomain(true);
        factory.setSubscriptionDurable(true);
        factory.setClientId("topicDurable3");
        return factory;
    }
    
}
