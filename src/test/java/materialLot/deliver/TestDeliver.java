package materialLot.deliver;

import Params.materialLot.DeliverParams;
import config.Environment;
import object.materialLot.Deliver;
import org.testng.annotations.Test;
import request.RequestObject;
import java.util.HashMap;

public class TestDeliver {

    @Test(dataProvider= "getDeliver",dataProviderClass = DeliverParams.class)
    private void testDelivertPost(String materialCode, int materialLotIdList[],int statusCode, String msg){

        System.out.println("----------" + msg + "----------");
        Deliver deliver = new Deliver(materialCode,materialLotIdList);
        HashMap<String,String> params=new HashMap<String, String>();
        RequestObject.getStatus(RequestObject.testPost(Environment.server_manufacture,"/v2/materialLot/_deliver",deliver,params),statusCode);

    }

}
