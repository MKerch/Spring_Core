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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kerch
 */
//@RestController
@Controller
@ResponseBody
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping(value = "/save")
    public void save(@RequestBody Person person) {
        personService.save(person);
    }

    @PostMapping(value = "/saveall")
    public void saveAll(@RequestBody List<Person> persons) {
        personService.saveAll(persons);
    }

    @GetMapping(value = "/count")
    public int count() {
        return personService.count();
    }

    @GetMapping("/get/{id}")
    public Person get(@PathVariable("id") int id) {
        return personService.get(id);
    }

    @GetMapping("/getall")
    public List<Person> getAll() {
        return personService.getAll();
    }

    @PutMapping(value = "/update/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Person person) {
        personService.update(id, person);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        personService.delete(id);
    }

    @DeleteMapping("/deleteall")
    public void deleteAll() {
        personService.deleteAll();
    }

}
