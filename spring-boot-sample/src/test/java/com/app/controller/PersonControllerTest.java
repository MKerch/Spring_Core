/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.Person;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author kerch
 */
public class PersonControllerTest {
    
    @Test
    public void test(){
        ClientApi clientApi = new ClientApiImpl();
        int count = clientApi.count();
        assertTrue(count==1);
        
        Person p1 = new Person();
        p1.setAge(1);
        p1.setName("Name1");
        clientApi.save(p1);
        count = clientApi.count();
        assertTrue(count==2);
        Person p1Result=clientApi.get(1);
        assertTrue(1==p1Result.getAge());
        assertTrue("Name1".equals(p1Result.getName()));
        
        Person p2 = new Person();
        p2.setAge(2);
        p2.setName("Name2");
        Person p3 = new Person();
        p3.setAge(3);
        p3.setName("Name3");
        List<Person> persons = new ArrayList();
        persons.add(p2);
        persons.add(p3);
        clientApi.saveAll(persons);
        count = clientApi.count();
        assertTrue(count==4);
        Person p3Result=clientApi.get(3);
        assertTrue(3==p3Result.getAge());
        assertTrue("Name3".equals(p3Result.getName()));
        
        Person p3Candidat = new Person();
        p3Candidat.setAge(100);
        p3Candidat.setName("Person100");
        clientApi.update(3, p3Candidat);
        count = clientApi.count();
        assertTrue(count==4);
        Person p100Result=clientApi.get(3);
        assertTrue(100==p100Result.getAge());
        assertTrue("Person100".equals(p100Result.getName()));
        
        clientApi.delete(0);
        count = clientApi.count();
        assertTrue(count==3);
        
        clientApi.deleteAll();
        count = clientApi.count();
        assertTrue(count==0);
        
    }
    
    @After
    public void afterTest(){
        ClientApi clientApi = new ClientApiImpl();
        Person p0 = new Person();
        p0.setAge(0);
        p0.setName("Name0");
        clientApi.save(p0);
    }
    
}
