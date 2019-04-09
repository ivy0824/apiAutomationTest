package def.unit;

import Params.def.UnitParams;
import config.Environment;
import request.RequestObject;
import org.testng.annotations.Test;


import java.util.HashMap;

public class TestUnit {

    @Test(dataProvider= "getUnit",dataProviderClass = UnitParams.class)
    private void testUnitPost(String name,String des,int statusCode,String msg){
        HashMap<String,String> body=new HashMap<String, String>();
        System.out.println("----------" + msg + "----------");
        body.put("name",name);
        body.put("desc",des);
        HashMap<String,String> params=new HashMap<String, String>();
        RequestObject.getStatus(RequestObject.testPost(Environment.server_def,"/v1/unit",body,params),statusCode);

    }

//    @Test
//    public void testUnitGet(){
//        HashMap<String,String> params=new HashMap<String, String>();
////        RequestObject.getStatus(RequestObject.testGet("unit",params),200);
//        RequestObject.getResponseMessage(RequestObject.testGet(Environment.server_def,"/v1/unit",params),"data.name", "单位8248");
//    }

}
