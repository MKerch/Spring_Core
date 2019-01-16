package com.app.convector;

import com.app.model.Person;

import java.io.IOException;

public interface ConvectorService {


    public String convertToJSON(Person person) throws IOException;

    public Person convertToPerson(String jsonValue) throws IOException;
}
