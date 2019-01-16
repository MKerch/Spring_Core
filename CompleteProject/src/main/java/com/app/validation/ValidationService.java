package com.app.validation;


import com.app.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;


@Component
public class ValidationService {

    @Autowired
    private Validator validator;

    public Set<ConstraintViolation<Person>> validate(Person person) {
        return validator.validate(person);
    }
}
