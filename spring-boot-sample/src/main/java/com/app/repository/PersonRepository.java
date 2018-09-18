/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.repository;

import com.app.model.Person;
import java.util.List;

/**
 *
 * @author kerch
 */
public interface PersonRepository {
    
    public void save(Person person);
    
    public void saveAll(List<Person> persons);
    
    public int count();
    
    public Person get(int id);
    
    public List<Person> getAll();
    
    public void update(int id, Person cadidat);
    
    public void delete(int id);
    
    public void deleteAll();
}
