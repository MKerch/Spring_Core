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

/**
 *
 * @author kerch
 */
@Repository
public class DefaultPersonRepositoryImpl implements PersonRepository {
    private List<Person> persons = new ArrayList();
    
    @PostConstruct
    public void init(){
        Person p = new Person();
        p.setAge(0);
        p.setName("Name0");
        persons.add(p);
    }
    
    @Override
    public int count() {
        return persons.size();
    }

    @Override
    public void save(Person person) {
        persons.add(person);
    }

    @Override
    public void saveAll(List<Person> persons) {
        persons.addAll(persons);
    }

    @Override
    public Person get(int id) {
        return persons.get(id);
    }

    @Override
    public void update(int id, Person candidat) {
        persons.set(id, candidat);
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
