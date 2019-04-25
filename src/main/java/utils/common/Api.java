package utils.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.specification.RequestSpecification;
import java.io.IOException;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

public class Api {

    HashMap<String, Object> query = new HashMap<String, Object>();


    public Api(){
        useRelaxedHTTPSValidation();
    }

    public RequestSpecification getDefaultRequestSpecification() {
        return given().log().all();
    }

    //读取json、yaml文件
    public static String template(String path, HashMap<String, Object> map) {
        DocumentContext documentContext = JsonPath.parse(Api.class
                .getResourceAsStream(path));
        map.entrySet().forEach(entry -> {
            documentContext.set(entry.getKey(), entry.getValue());
        });
        return documentContext.jsonString();
    }

    //读取yaml文件
    public Restful getApiFromYaml(String path) {

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            return mapper.readValue(Api.class.getResourceAsStream(path), Restful.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    //修改获取的请求内容
    public Restful updateApiFromMap(Restful restful, HashMap<String, Object> map) {
        if(map==null){
            return  restful;
        }
        if (restful.method.toLowerCase().contains("get")) {
            map.entrySet().forEach(entry -> {
                restful.query.replace(entry.getKey(), entry.getValue().toString());
                System.out.println(restful.query);
            });
        }

        if (restful.method.toLowerCase().contains("post")) {
            if (map.containsKey("_body")) {
                restful.body = map.get("_body").toString();
            }
            if (map.containsKey("_file")) {
                String filePath = map.get("_file").toString();
                map.remove("_file");
                restful.body = template(filePath, map);
            }
        }
        return restful;

    }




}
