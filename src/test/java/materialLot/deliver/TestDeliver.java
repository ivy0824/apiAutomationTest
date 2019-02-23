package materialLot.deliver;

import Params.materialLot.DeliverParams;
import config.Environment;
import org.testng.annotations.Test;
import request.RequestObject;
import java.util.HashMap;

public class TestDeliver {

    @Test(dataProvider= "getDeliver",dataProviderClass = DeliverParams.class)
    private void testDelivertPost(String materialCode, int materialLotIdList[],int statusCode, String msg){

        System.out.println("----------" + msg + "----------");

        HashMap<String,Object> body=new HashMap<String, Object>();
        body.put("materialCode",materialCode);
        body.put("materialLotIdList",materialLotIdList);
        System.out.println(body);
        HashMap<String,String> params=new HashMap<String, String>();
        RequestObject.getStatus(RequestObject.testPost(Environment.server_manufacture,"/v2/materialLot/_deliver",body,params),statusCode);

    }

}
