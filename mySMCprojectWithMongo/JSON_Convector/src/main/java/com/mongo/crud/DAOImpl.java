package com.mongo.crud;

import com.model.Person;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class DAOImpl implements DAO {

    private MongoDatabase mongoDB;

    public DAOImpl() {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017/person_db"));
        mongoDB = mongoClient.getDatabase("person_db");

    }

    public void savePerson(Person person) {
        Document document = personToDocumentConvertor(person);
        MongoCollection<Document> personDocuments = mongoDB.getCollection("person");
        personDocuments.insertOne(document);
    }

    public void deletePerson(Person person) {
        Document document = personToDocumentConvertor(person);
        MongoCollection<Document> personDocuments = mongoDB.getCollection("person");
        personDocuments.deleteOne(document);
    }

    public void updatePerson(Person old, Person newPerson) {
        Document filter = personToDocumentConvertor(old);
        Document updateData = personToDocumentConvertor(newPerson);
        Document documentUpdate = new Document();
        documentUpdate.put("$set", documentUpdate);

        UpdateOptions options = new UpdateOptions();
        options.upsert(true);

        MongoCollection<Document> personDocuments = mongoDB.getCollection("person");
        personDocuments.updateMany(filter, documentUpdate,options);
    }

    public void deleteAll() {
        MongoCollection<Document> personDocuments = mongoDB.getCollection("person");
        personDocuments.drop();
    }

    public List<Person> getPerson(String name) {
        Document document = new Document();
        document.put("name", name);
        MongoCollection<Document> personDocuments = mongoDB.getCollection("person");
        FindIterable<Document> documents = personDocuments.find(document);
        List<Person> personList = new ArrayList<Person>();
        for (Document doc : documents) {
            Person person = new Person();
            person.setName(doc.getString("name"));
            person.setWeight(doc.getDouble("weight"));
            person.setSalary(doc.getInteger("salary"));
            person.setPosition(doc.getString("position"));
            person.setHeight(doc.getDouble("height"));
            person.setFirstDayOfWork(doc.getString("firstDayOfWork"));
            person.setAge(doc.getInteger("age"));
            personList.add(person);
        }
        return personList;
    }

    public long countPerson() {
        MongoCollection<Document> personDocuments = mongoDB.getCollection("person");
        return personDocuments.count();
    }

    private Document personToDocumentConvertor(Person p) {
        Document document = new Document();
        document.put("age", p.getAge());
        document.put("firstDayOfWork", p.getFirstDayOfWork());
        document.put("height", p.getHeight());
        document.put("name", p.getName());
        document.put("position", p.getPosition());
        document.put("salary", p.getSalary());
        document.put("weight", p.getWeight());
        return document;
    }
}
