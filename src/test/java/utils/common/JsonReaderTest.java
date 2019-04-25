package utils.common;

import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.*;

public class JsonReaderTest {

    @Test
    void jsonReader(){
        HashMap<String, Object> body = new HashMap<String, Object>();
        System.out.println(JsonReader.getJson("/data/def/material.json",body));
    }

}