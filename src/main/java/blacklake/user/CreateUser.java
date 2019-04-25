package blacklake.user;

import config.Environment;
import io.restassured.response.ValidatableResponse;
import utils.common.JsonReader;
import utils.common.RequestObject;

import java.util.HashMap;

public class CreateUser {

    public static ValidatableResponse createUser(String name, String username){
        HashMap<String,Object> map = new HashMap<String,Object>();
        HashMap<String,Object> params = new HashMap<String,Object>();
        map.put("name",name);
        map.put("username",username);
        String body = JsonReader.getJson("/data/lakers/createOrg.json",map);
        ValidatableResponse response = RequestObject.testPost(Environment.server_user,"/v1/users",body,params);
        return response;

    }

}
