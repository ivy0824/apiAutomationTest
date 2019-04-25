package produce_task;

import Params.product_task.Create_ClaimParams;
import config.Environment;
import org.testng.annotations.Test;
import utils.common.RequestObject;

import java.util.HashMap;

public class Create_claim {

    @Test(dataProvider= "getCreateClaim",dataProviderClass = Create_ClaimParams.class)
    private void testCreateClaimPost(String projectCode,String processSeq,int amountProductPlanned,int statusCode,String msg){
        HashMap<String,String> body=new HashMap<String, String>();
        System.out.println("----------" + msg + "----------");
        body.put("projectCode",projectCode);
        body.put("processSeq",processSeq);
        body.put("amountProductPlanned",amountProductPlanned+"");
        HashMap<String,String> params=new HashMap<String, String>();
        RequestObject.getStatus(RequestObject.testPost(Environment.server_manufacture,"/v1/project/produce_task/create_claim",body,params),statusCode);

    }
}
