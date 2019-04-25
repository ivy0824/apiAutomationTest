package def.unit;

import Params.def.UnitParams;
import blacklake.def.Unit;
import io.restassured.response.ValidatableResponse;
import utils.common.RequestObject;
import org.testng.annotations.Test;


import java.util.HashMap;

public class TestUnit {

    @Test(dataProvider= "getUnit",dataProviderClass = UnitParams.class)
    private void testUnitPost(String name,String des,int statusCode,String msg){
        HashMap<String,String> body=new HashMap<String, String>();
        System.out.println("----------" + msg + "----------");
        body.put("name",name);
        body.put("desc",des);
        ValidatableResponse response = Unit.createUnit(name,des);
        RequestObject.getStatus(response, statusCode);
        RequestObject.getResponseMessage(response,"data.name",name);


    }


}
