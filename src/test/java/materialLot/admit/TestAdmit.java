package materialLot.admit;

import Params.materialLot.AdmitParams;
import object.materialLot.Admit;
import org.testng.annotations.Test;
import request.RequestObject;
import java.util.ArrayList;
import java.util.HashMap;


public class TestAdmit {

    @Test(dataProvider= "getAdmit",dataProviderClass = AdmitParams.class)
    private void testAdmitPost(String materialCode, ArrayList codesAndAmounts, ArrayList mfgBatches,int storageId,int statusCode, String msg){

        System.out.println("----------" + msg + "----------");

        Admit admit = new Admit(materialCode,codesAndAmounts,mfgBatches,storageId);
        System.out.println(admit.toString());
        HashMap<String,String> params=new HashMap<String, String>();
        RequestObject.getStatus(RequestObject.testPost("materialLot/_admit",admit,params),statusCode);

    }



}
