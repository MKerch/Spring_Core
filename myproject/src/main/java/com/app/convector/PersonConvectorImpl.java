package com.app.convector;

import com.app.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonConvectorImpl implements PersonConvector {

    @Override
    public Person transformObject(String text) {
        Person person1 = new Person();
        person1.setAge(12);
        person1.setName("Vasya");
        return person1;
    }
}
