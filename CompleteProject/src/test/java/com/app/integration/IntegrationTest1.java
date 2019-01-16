package com.app.integration;


import com.app.AppConfig;
import com.app.DAO.DAO;
import com.app.utils.Utils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, TestAppConfig.class})
public class IntegrationTest1 {

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    @Qualifier("DAOImpl")
    private DAO correctDao;

    private final String FILE_PATH = "src\\test\\resorces\\person.json";

    @Test
    public void auditTest() throws IOException, InterruptedException {
        long amountBefore = correctDao.countPerson();
        final String s = Utils.readeResource(FILE_PATH);
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(s);
            }
        });
        Thread.sleep(3000);
        long amountAfter = correctDao.countPerson();
        Assert.assertTrue(amountBefore+1==amountAfter);
    }


}
