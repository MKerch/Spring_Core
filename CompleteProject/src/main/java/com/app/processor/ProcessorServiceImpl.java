package com.app.processor;

import com.app.DAO.DAO;
import com.app.convector.ConvectorService;
import com.app.model.Person;
import com.app.validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import java.io.IOException;
import java.util.Set;
@Component
public class ProcessorServiceImpl implements ProcessorService {

    @Autowired
    private ConvectorService convector;
    @Autowired
    private ValidationService validation;
    @Autowired
    @Qualifier("DAOImpl")
    private DAO daoCorrect;
    @Autowired
    @Qualifier("DAOImpl2")
    private DAO daoIncorrect;

    public void process(String text) throws IOException {
        Person person = convector.convertToPerson(text);
        Set<ConstraintViolation<Person>> validate = validation.validate(person);
        System.out.println(validate.size());
        if(validate.size()==0){
            daoCorrect.savePerson(person);
        }else{
            daoIncorrect.savePerson(person);
        }
    }
}
