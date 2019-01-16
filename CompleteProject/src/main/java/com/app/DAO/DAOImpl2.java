package com.app.DAO;

import com.app.model.Person;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("DAOImpl2")
public class DAOImpl2 implements DAO {

    @Autowired
    private MongoDatabase mongoDatabase;

    public DAOImpl2() {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017/person_db"));
        mongoDatabase = mongoClient.getDatabase("person_db");
    }

    public void savePerson(Person person) {
        Document document = personToDocument(person);
        MongoCollection<Document> collection = mongoDatabase.getCollection("invalidPerson");
        collection.insertOne(document);

    }

    public void deletePerson(Person person) {
        Document document = personToDocument(person);
        MongoCollection<Document> collection = mongoDatabase.getCollection("invalidPerson");
        collection.deleteOne(document);
    }

    public void updatePerson(Person old, Person newPerson) {
        Document documentOld = personToDocument(old);
        Document documentNewPerson = personToDocument(newPerson);
        Document documentUpdate = new Document();
        documentUpdate.put("$set", documentNewPerson);

        UpdateOptions options = new UpdateOptions();
        options.upsert(true);
        MongoCollection<Document> collection = mongoDatabase.getCollection("invalidPerson");
        collection.updateMany(documentOld, documentUpdate, options);
    }

    public List<Person> getPerson(String name) {
        Document document = new Document();
        document.put("$set", name);
        MongoCollection<Document> collection = mongoDatabase.getCollection("invalidPerson");
        FindIterable<Document> documents = collection.find(document);
        List<Person> list = new ArrayList<Person>();
        for (Document doc : documents) {
            Person person = new Person();
            person.setName(doc.getString("name"));
            person.setAge(doc.getInteger("age"));
            person.setHeight(doc.getDouble("height"));
            person.setPosition(doc.getString("position"));
            person.setSalary(doc.getInteger("salary"));
            person.setWeight(doc.getDouble("weight"));
            list.add(person);
        }
        return list;
    }

    public long countPerson() {
        MongoCollection<Document> collection = mongoDatabase.getCollection("invalidPerson");
        return collection.count();
    }

    public void deleteAll() {
        MongoCollection<Document> collection = mongoDatabase.getCollection("invalidPerson");
        collection.drop();
    }

    private Document personToDocument(Person person) {
        Document document = new Document();
        document.put("age", person.getAge());
        document.put("height", person.getHeight());
        document.put("name", person.getName());
        document.put("position", person.getPosition());
        document.put("salary", person.getSalary());
        document.put("weight", person.getWeight());
        return document;
    }
}
