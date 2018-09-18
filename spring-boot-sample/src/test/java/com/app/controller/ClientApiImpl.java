/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.Person;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author kerch
 */
public class ClientApiImpl implements ClientApi {
    private String url;

    public ClientApiImpl(String url) {
        this.url = url;
    }

    public ClientApiImpl() {
        this("http://localhost:8080");
    }
    

    @Override
    public int count() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url+"/count", Integer.class);
    }

    @Override
    public void save(Person person) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForLocation(url+"/save", person);
    }

    @Override
    public void saveAll(List<Person> persons) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForLocation(url+"/saveall", persons);
    }

    @Override
    public void update(int id, Person candidat) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(url+"/update/"+id, candidat);        
    }

    @Override
    public Person get(int id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url+"/get/"+id, Person.class);
    }

    @Override
    public List<Person> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url+"/getall", ArrayList.class);
    }

    @Override
    public void delete(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url+"/delete/"+id);
    }

    @Override
    public void deleteAll() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url+"/deleteall");
    }
    
}
