/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;

import com.app.model.Person;
import com.app.repository.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kerch
 */
@Service
public class PersonServiceImpl implements PersonService {
    
    @Autowired
    private PersonRepository personRepository;

    @Override
    public int count() {
        return personRepository.count();
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public void saveAll(List<Person> persons) {
        personRepository.saveAll(persons);
    }

    @Override
    public Person get(int id) {
        return personRepository.get(id);
    }

    @Override
    public void update(int id, Person candidat) {
        personRepository.update(id, candidat);
    }

    @Override
    public void delete(int id) {
        personRepository.delete(id);
    }

    @Override
    public void deleteAll() {
        personRepository.deleteAll();
    }
    
}
