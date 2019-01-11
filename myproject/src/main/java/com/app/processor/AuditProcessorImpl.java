package com.app.processor;

import com.app.convector.PersonConvector;
import com.app.dao.DAO;
import com.app.model.Person;
import com.app.processor.AuditProcessor;
import com.app.validator.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuditProcessorImpl implements AuditProcessor {

    @Autowired
    private PersonConvector convector;
    @Autowired
    private PersonValidator validator;
    @Autowired
    private DAO dao;

    @Override
    public void process(String text) {
        Person person = convector.transformObject(text);
        Boolean isValid = validator.validate(person);
        if (isValid) {
            dao.saveCorrect(person);
        } else {
            dao.saveIncorrect(person);
        }


        
    }
}
