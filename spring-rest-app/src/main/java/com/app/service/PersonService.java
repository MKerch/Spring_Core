/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;

import com.app.model.Person;
import java.util.List;

/**
 *
 * @author kerch
 */
public interface PersonService {

    public int count();

    public void save(Person person);

    public void saveAll(List<Person> persons);

    public Person get(int id);

    public void update(int id, Person candidat);

    public void delete(int id);

    public void deleteAll();

}
