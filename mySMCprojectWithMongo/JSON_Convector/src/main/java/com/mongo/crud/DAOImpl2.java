package com.mongo.crud;

import com.model.Person;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.List;

public class DAOImpl2 implements DAO {

    private MongoDatabase mongoDB;

    public DAOImpl2() {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017/person_db"));
        mongoDB = mongoClient.getDatabase("person_db");
    }

    public void savePerson(Person person) {
        MongoCollection<Person> persons = mongoDB.getCollection("person", Person.class);
        persons.insertOne(person);
    }

    public void deletePerson(Person person) {
        MongoCollection<Person> persons = mongoDB.getCollection("person", Person.class);
        //persons.deleteOne((Bson) person);
    }

    public void updatePerson(Person old, Person newPerson) {

    }

    public List<Person> getPerson(String name) {
        MongoCollection<Person> persons = mongoDB.getCollection("person", Person.class);
        return null;
    }

    public long countPerson() {
        return 0;
    }

    public void deleteAll() {

    }
}
