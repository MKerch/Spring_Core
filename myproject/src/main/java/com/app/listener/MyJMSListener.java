package com.app.listener;

import com.app.processor.AuditProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class MyJMSListener {

    @Autowired
    private AuditProcessor auditProcessor;

    @JmsListener(destination = "personDestination")
    public void onMassage(Message msg)  {

        if (msg instanceof TextMessage) {
            try {
                TextMessage textMessage = (TextMessage) msg;
                String text = textMessage.getText();
                auditProcessor.process(text);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

    }

}
