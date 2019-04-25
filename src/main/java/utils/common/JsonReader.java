package utils.common;

import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;



public class JsonReader {

    public static String getJson(String path, HashMap<String,Object> map){
        System.out.println(JsonReader.class.getResourceAsStream(path));
        DocumentContext documentContext= JsonPath.parse(JsonReader.class
                .getResourceAsStream(path));
        map.entrySet().forEach(entry->{
            documentContext.set(entry.getKey(), entry.getValue());
        });
        System.out.println(documentContext.jsonString());
        return documentContext.jsonString();
    }



}
