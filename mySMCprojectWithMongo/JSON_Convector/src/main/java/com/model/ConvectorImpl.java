package com.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ConvectorImpl implements Convector {


    public Person convertToPerson(String jsonValue) {
        ObjectMapper mapper = new ObjectMapper();
        Person person = null;
        try {
            person = mapper.readValue(jsonValue.getBytes(), Person.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return person;
    }

    public String convertToJSON(Person person) {
        ObjectMapper mapper = new ObjectMapper();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            mapper.writeValue(outputStream, person);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] data = outputStream.toByteArray();
        return new String(data);
    }
}
