package materialLot.admit;

import Params.materialLot.PurchaseAdmitParams;
import config.Environment;
import object.materialLot.Admit;
import object.materialLot.PurchaseAdmit;
import org.testng.annotations.Test;
import request.RequestObject;

import java.util.ArrayList;
import java.util.HashMap;

public class TestPurchaseAdmit {

    @Test(dataProvider= "getPurchaseAdmit",dataProviderClass = PurchaseAdmitParams.class)
    private void testAdmitPost(int procureOrderId,int procureOrderDetailId, ArrayList codesAndAmounts, String supplierCode,String materialCode, Object storageId, int statusCode, String msg){

        System.out.println("----------" + msg + "----------");

        PurchaseAdmit purchaseAdmit = new PurchaseAdmit(procureOrderId,procureOrderDetailId,codesAndAmounts,supplierCode,materialCode,storageId);
        System.out.println(purchaseAdmit.toString());
        HashMap<String,String> params=new HashMap<String, String>();
        RequestObject.getStatus(RequestObject.testPost(Environment.server_manufacture,"/v2/materialLot/_admit_by_procure_order",purchaseAdmit,params),statusCode);

    }
}
