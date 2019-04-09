package materialLot.admit;

import Params.materialLot.AdmitParams;
import config.Environment;
import object.materialLot.Admit;
import object.materialLot.OriginPlace;
import org.testng.annotations.Test;
import request.RequestObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class TestAdmit {

    @Test(dataProvider= "getAdmit",dataProviderClass = AdmitParams.class)
    private void testAdmitPost(String materialCode, ArrayList codesAndAmounts, ArrayList mfgBatches, Object storageId, Date validityPeriod, String supplierCode, OriginPlace originPlace, String remark, int statusCode, String msg){

        System.out.println("----------" + msg + "----------");

        Admit admit = new Admit();
        admit.admitAll(materialCode,codesAndAmounts,mfgBatches,storageId,validityPeriod,supplierCode,originPlace,remark);
        System.out.println(admit.toString());
        HashMap<String,String> params=new HashMap<String, String>();
        RequestObject.getStatus(RequestObject.testPost(Environment.server_manufacture,"/v2/materialLot/_admit",admit,params),statusCode);

    }

}
