package com.app.integration;

import com.app.utils.Utils;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.command.ActiveMQQueue;
import org.bson.Document;
import org.junit.Assert;
import org.junit.Test;

import javax.jms.*;
import java.io.IOException;

import static com.app.utils.Utils.readeResource;

public class IntegrationTest2 {

    private final String FILE_PATH = "src\\test\\resorces\\person.json";

    private long countCorrect() {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017/person_db"));
        MongoDatabase person_db = mongoClient.getDatabase("person_db");
        MongoCollection<Document> collection = person_db.getCollection("person");
        long count = collection.count();
        return count;
    }

    private long countIncorrect() {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017/person_db"));
        MongoDatabase person_db = mongoClient.getDatabase("person_db");
        MongoCollection<Document> collection = person_db.getCollection("personIncorrect");
        long count = collection.count();
        return count;
    }

    @Test
    public void jmsTester() throws Exception {
        long before = countCorrect();
        sentCorrect();
        long after = countCorrect();
        Assert.assertTrue("before="+before + "after="+after,before+1==after);

    }

    private void sentCorrect() throws JMSException, IOException, InterruptedException {
        ConnectionFactory factory = new ActiveMQConnectionFactory();
        ((ActiveMQConnectionFactory) factory).setBrokerURL("tcp://localhost:61616");
        Connection connection = factory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        String s = readeResource(FILE_PATH);
        TextMessage textMessage = session.createTextMessage(s);
        Destination destination = new ActiveMQQueue("testQueue");
        MessageProducer producer = session.createProducer(destination);
        producer.send(textMessage);
        Thread.sleep(3000);

    }


}
