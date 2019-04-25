package materialLot.adjust;

import Params.materialLot.AdjustParams;
import config.Environment;
import org.testng.annotations.Test;
import utils.common.RequestObject;
import java.util.HashMap;

public class TestAdjust {

    @Test(dataProvider= "getAdjust",dataProviderClass = AdjustParams.class)
    private void testAdjustPost(int materialLotId, String transactionCode,int amountBefore,int amountDiff, String message,String msg){

        System.out.println("----------" + msg + "----------");
        HashMap<String,Object> body=new HashMap<String, Object>();
        body.put("materialLotId",materialLotId);
        body.put("transactionCode",transactionCode);
        body.put("amountBefore",amountBefore);
        body.put("amountDiff",amountDiff);
        body.toString();
        HashMap<String,Object> params=new HashMap<String, Object>();
        RequestObject.getResponseMessage(RequestObject.testPost(Environment.server_manufacture,"/v1/materialLot/_adjust",body,params),"message",message);


    }


}
