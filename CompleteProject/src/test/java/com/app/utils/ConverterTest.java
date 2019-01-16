package com.app.utils;

import com.app.convector.ConvectorService;
import com.app.convector.ConvectorServiceImpl;
import com.app.model.Person;
import org.junit.Test;

import java.io.IOException;

public class ConverterTest {

    private final String FILE_PATH = "src\\test\\resorces\\person.json";

    @Test
    public void personToJSONConvectorTest() throws IOException {
        ConvectorService convector = new ConvectorServiceImpl();
        Person defoltePerson = Utils.getDefoltePerson();
        String afterConvectorJSON = convector.convertToJSON(defoltePerson);
        System.out.println(afterConvectorJSON);

        String expectedString = Utils.readeResource(FILE_PATH);
        //Assert.assertEquals(expectedString.replaceAll("/n", ""), afterConvectorJSON.replaceAll("/n", ""));
    }

}
