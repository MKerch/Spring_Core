package com.mongo.crud;

import com.Utils;
import com.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DAOImplTest {

    private DAO dao;

    @Before
    public void init() {
        dao = new DAOImpl();
    }

    @Test
    public void saveToDbTest() {
        long countBefore = dao.countPerson();
        dao.savePerson(Utils.getDefoltePerson());
        long countAfter = dao.countPerson();
        Assert.assertTrue(countBefore + 1 == countAfter);
    }

    @Test
    public void deleteFromDbTest() {
        long countBefore = dao.countPerson();
        dao.deletePerson(Utils.getDefoltePerson());
        long countAfter = dao.countPerson();
        Assert.assertTrue(countBefore - 1 == countAfter);
    }

    @Test
    public void getPersonByNameDbTest() {
        dao.deleteAll();
        dao.savePerson(Utils.getDefoltePerson());
        Person defoltePerson2 = Utils.getDefoltePerson();
        defoltePerson2.setName("test");
        dao.savePerson(defoltePerson2);
        List<Person> list = dao.getPerson("test");
        Assert.assertTrue(list.size() == 1);
    }

    @Test
    public void updatePersonByNameDbTest() {
        dao.deleteAll();
        Person old = Utils.getDefoltePerson();
        dao.savePerson(old);

        Person newPerson = Utils.getDefoltePerson();
        newPerson.setName("test");
        newPerson.setAge(100);

        dao.updatePerson(old, newPerson);
        List<Person> list = dao.getPerson("test");
        Assert.assertTrue(list.size() == 1);
        Assert.assertTrue(100 == list.get(0).getAge());
    }
}
