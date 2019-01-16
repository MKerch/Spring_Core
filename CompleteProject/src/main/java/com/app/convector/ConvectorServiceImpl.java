package com.app.convector;

import com.app.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Component
public class ConvectorServiceImpl implements ConvectorService {

    @Autowired
    private ObjectMapper mapper;

    public Person convertToPerson(String jsonValue) throws IOException {
        return mapper.readValue(jsonValue.getBytes(), Person.class);
    }

    public String convertToJSON(Person person) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        mapper.writeValue(outputStream, person);
        byte[] array = outputStream.toByteArray();
        return new String(array);
    }
}
