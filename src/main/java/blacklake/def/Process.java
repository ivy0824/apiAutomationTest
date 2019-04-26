package blacklake.def;

import config.Environment;
import io.restassured.response.ValidatableResponse;
import utils.common.RequestObject;

import java.util.HashMap;

public class Process {

    public static ValidatableResponse createProcess(String code,String name){
        HashMap<String,String> body=new HashMap<String, String>();
        body.put("code",code);
        body.put("name",name);
        ValidatableResponse response = RequestObject.postRequest(Environment.server_def,"/v1/process",body);
        return response;
    }
}
