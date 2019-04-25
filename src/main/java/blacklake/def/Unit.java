package blacklake.def;

import config.Environment;
import io.restassured.response.ValidatableResponse;
import utils.common.RequestObject;

import java.util.HashMap;

public class Unit {

    public static int unitId;

    public static ValidatableResponse createUnit(String name,String des){
        HashMap<String,String> body=new HashMap<String, String>();
        body.put("name",name);
        body.put("desc",des);
        ValidatableResponse response = RequestObject.postRequest(Environment.server_def,"/v1/unit",body);
        unitId = response.extract().path("data.id");
        System.out.println(unitId);
        return response;

    }
}
