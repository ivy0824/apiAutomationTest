package blacklake.def;

import config.Environment;
import io.restassured.response.ValidatableResponse;
import utils.common.JsonReader;
import utils.common.RequestObject;


import java.util.HashMap;

public class Material {

    public static ValidatableResponse createMaterial(String code,String name){

        HashMap<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("name", name);
        map.put("unitId", Unit.unitId);
        String body = JsonReader.getJson("/data/def/material.json",map);
        ValidatableResponse response = RequestObject.postRequest(Environment.server_def,"/v1/material", body);
        return response;

    }
}
