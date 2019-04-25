package blacklake.def;

import config.Environment;
import io.restassured.response.ValidatableResponse;
import utils.common.JsonReader;
import utils.common.RequestObject;

import java.util.HashMap;

public class EBOM {

    public static ValidatableResponse createEbom(){
        Material.createMaterial("material242301","material242301");
        Material.createMaterial("material242302","material242302");
        Material.createMaterial("material242303","material242303");
        Material.createMaterial("material242304","material242304");
        HashMap<String,Object> map=new HashMap<String, Object>();
        map.put("productMaterialCode","material242301");
        map.put("currentUnitId", Unit.unitId+"");
        map.put("rawMaterialList[0].materialCode","material242302");
        map.put("rawMaterialList[1].materialCode","material242303");
        map.put("rawMaterialList[2].materialCode","material242304");
        String body = JsonReader.getJson("/data/def/eBOM.json",map);
        ValidatableResponse response = RequestObject.postRequest(Environment.server_def,"/v1/ebom",body);

        return response;
    }



}
