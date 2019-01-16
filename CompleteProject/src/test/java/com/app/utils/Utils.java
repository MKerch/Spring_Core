package com.app.utils;

import com.app.model.Person;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Utils {

    public static String readeResource(String filePath) throws IOException {
        InputStream inputStream = new FileInputStream(new File(filePath));
        byte[] array = new byte[inputStream.available()];
        inputStream.read(array);
        return new String(array);
    }

    public static Person getDefoltePerson() {
        Person person = new Person();
        person.setWeight(23);
        person.setSalary(2333);
        person.setPosition("boss");
        person.setHeight(23);
        person.setAge(33);
        person.setName("Bobo");
        return person;
    }
}
