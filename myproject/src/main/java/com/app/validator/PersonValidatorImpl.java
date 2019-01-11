package com.app.validator;

import com.app.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonValidatorImpl implements PersonValidator {

    @Override
    public Boolean validate(Person p) {
        if(p.getAge()>20){
            return true;
        }
        return false;
    }
}
