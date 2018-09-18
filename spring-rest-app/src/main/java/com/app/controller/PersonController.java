/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.Person;
import com.app.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kerch
 */
@Controller
@ResponseBody
public class PersonController {
    @Autowired
    private PersonService personService;
    
    @RequestMapping(value="/count", method = RequestMethod.GET)
    public int count(){
        return personService.count();
    }

    @RequestMapping(value="/save", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void save(@RequestBody Person person){
        System.out.println(person);
        personService.save(person);
    }

   /*
   @RequestMapping(value="/saveall",method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void saveAll(@RequestBody List<Person> persons){
        System.out.println(persons);
        personService.saveAll(persons);
    }*/

    @RequestMapping(value="/get/{id}", method = RequestMethod.GET)
    public Person get(@PathVariable("id") int id){
        return personService.get(id);
    }

    @RequestMapping(value="/update/{id}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void update(@PathVariable("id") int id, @RequestBody Person candidat){
        personService.update(id, candidat);
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id){
        personService.delete(id);
    }

    @RequestMapping(value="/deleteall", method = RequestMethod.DELETE)
    public void deleteAll(){
        System.out.println("######### DELETE ALL");
        personService.deleteAll();
    }
    
}
