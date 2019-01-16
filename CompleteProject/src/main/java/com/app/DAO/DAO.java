package com.app.DAO;

import com.app.model.Person;

import java.util.List;

public interface DAO {

    public void savePerson(Person person);

    public void deletePerson(Person person);

    public void updatePerson(Person old, Person newPerson);

    public List<Person> getPerson(String name);

    public long countPerson();

    public void deleteAll();



}
