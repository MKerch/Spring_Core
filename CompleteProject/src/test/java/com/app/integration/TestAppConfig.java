package com.app.integration;


import com.app.AppConfig;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
public class TestAppConfig {

//    @Autowired
//    private ConnectionFactory connectionFactory;

    @Bean
    public ConnectionFactory getConnectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL("tcp://localhost:61616");
        return connectionFactory;
    }
    @Bean
    public JmsTemplate getTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate(getConnectionFactory());
        jmsTemplate.setDefaultDestinationName("testQueue2");
        return jmsTemplate;
    }


}
