package com.app.listener;


import com.app.processor.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.io.IOException;

@Component
public class ListenerService {

    @Autowired
    private ProcessorService processorService;

    @JmsListener(destination = "testQueue2")
    public void onMessage(Message msg) throws JMSException, IOException {
        System.out.println("message is consumed");
        if (msg instanceof TextMessage) {
            TextMessage message = (TextMessage) msg;
            String text = message.getText();
            processorService.process(text);
        }
    }
}
