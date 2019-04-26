package blacklake.def;

import config.Environment;
import io.restassured.response.ValidatableResponse;
import utils.common.RequestObject;

import java.util.HashMap;

public class Workstation {

    public static int workstationId;

    public static ValidatableResponse createWorkstation(String code, String name,int productionLineId) {
        HashMap<String, String> body = new HashMap<String, String>();
        body.put("code", code);
        body.put("name", name);
        body.put("productionLineId",productionLineId+"");
        body.put("toManyTask","1");
        body.put("groupId","");
        ValidatableResponse response = new RequestObject(orgId = 123).postRequest(Environment.server_def, "/v1/workstationAreas", body);
        workstationId = response.extract().path("data.id");
        return response;
    }

    public static void updateWorkstationStatus(int id){
        HashMap<String, String> body = new HashMap<String, String>();
        RequestObject.putRequest(Environment.server_def, "/v1/workstationAreas/"+id+"/enabled", body);
    }
}
