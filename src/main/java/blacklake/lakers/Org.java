package blacklake.lakers;

import config.Environment;
import io.restassured.response.ValidatableResponse;
import utils.common.JsonReader;
import utils.common.RequestObject;

import java.util.HashMap;

public class Org {

    public static int orgId;
    public static int userId;
    public static String userName;

    public static ValidatableResponse createOrg(String code, String name){
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("code",code);
        map.put("name",name);
        String body = JsonReader.getJson("/data/lakers/createOrg.json",map);
        ValidatableResponse response = RequestObject.post(Environment.server_lakers,"/v1/orgs",body);
        orgId = response.extract().path("data.id");
        System.out.println(orgId);
        return response;

    }

    public static ValidatableResponse createAdmin(int OrgId){
        HashMap<String,Object> map = new HashMap<String,Object>();
        ValidatableResponse response = RequestObject.post(Environment.server_lakers,"/v1/orgs/"+OrgId+"/admins",map);
        userId = response.extract().path("data.id");
        userName = response.extract().path("data.username");
        System.out.println(userId);
        System.out.println(userName);
        return response;
    }



}
