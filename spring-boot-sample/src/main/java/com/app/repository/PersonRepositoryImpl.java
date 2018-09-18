/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.repository;

import com.app.model.Person;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 *
 * @author kerch
 */
@Repository
public class PersonRepositoryImpl implements PersonRepository {
    private List<Person> persons;
    
    @PostConstruct
    public void init(){
        persons = new ArrayList();
        Person p = new Person();
        p.setAge(1);
        p.setName("Name1");
        persons.add(p);
    }
    
    @Override
    public void save(Person person) {
        persons.add(person);
    }

    @Override
    public void saveAll(List<Person> persons) {
        this.persons.addAll(persons);
    }

    @Override
    public int count() {
        return persons.size();
    }

    @Override
    public Person get(int id) {
        return persons.get(id);
    }

    @Override
    public List<Person> getAll() {
        return persons;
    }

    @Override
    public void update(int id, Person cadidat) {
        persons.set(id, cadidat);
    }

    @Override
    public void delete(int id) {
        persons.remove(id);
    }

    @Override
    public void deleteAll() {
       persons.clear();
    }
    
}
