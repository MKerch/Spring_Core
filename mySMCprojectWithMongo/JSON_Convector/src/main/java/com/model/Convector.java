package com.model;

public interface Convector {

    public Person convertToPerson(String jsonValue);

    public String convertToJSON(Person person) ;

}
