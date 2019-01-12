package com.model;

import com.Utils;
import com.model.Convector;
import com.model.ConvectorImpl;
import com.model.Person;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyTest {

    private final String FILE_PATH = "C:\\Users\\maksim.kerch\\IdeaProjects\\JSON_Convector\\src\\test\\resourses\\person.json";

    @Test
    public void personToJSONConvectorTest() throws IOException {
        Convector convector = new ConvectorImpl();
        Person person = Utils.getDefoltePerson();
        String afterConvectorJSON = convector.convertToJSON(person);

        String expectedString = Utils.readeResource(FILE_PATH);
        //Assert.assertEquals(expectedString.replaceAll("/n", ""), afterConvectorJSON.replaceAll("/n", ""));
    }

    @Test
    public void JSONConvectorToPersonTest() throws IOException {
        Convector convector = new ConvectorImpl();
        Person defoltePerson = Utils.getDefoltePerson();
        String json = Utils.readeResource(FILE_PATH);
        Person actualPerson = convector.convertToPerson(json);
        Assert.assertEquals(actualPerson,defoltePerson);
    }


}
