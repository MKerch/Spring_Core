package com;

import com.model.Person;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Utils {

    public static String readeResource(String filePath) throws IOException {
        InputStream inputStream = new FileInputStream(new File(filePath));
//        this.getClass().getResourceAsStream("/person.json");
        byte[] array = new byte[inputStream.available()];
        inputStream.read(array);
        return new String(array);
    }

    public static Person getDefoltePerson() {
        Person person = new Person();
        person.setAge(12);
        person.setFirstDayOfWork("20.11.2019");
        person.setHeight(180);
        person.setName("Vasya");
        person.setPosition("Senior jeday");
        person.setSalary(1000000);
        person.setWeight(100);
        return person;
    }
}
