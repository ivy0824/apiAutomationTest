package materialLot.admit;

import Params.materialLot.PurchaseAdmitParams;
import config.Environment;
import object.materialLot.PurchaseAdmit;
import org.testng.annotations.Test;
import utils.common.RequestObject;

import java.util.ArrayList;
import java.util.HashMap;

public class TestPurchaseAdmit {

    @Test(dataProvider= "getPurchaseAdmit",dataProviderClass = PurchaseAdmitParams.class)
    private void testAdmitPost(int procureOrderId,int procureOrderDetailId, ArrayList codeAndAmount, String supplierCode,String materialCode, Object storageId, int statusCode, String msg){

        System.out.println("----------" + msg + "----------");

        PurchaseAdmit purchaseAdmit = new PurchaseAdmit(procureOrderId,procureOrderDetailId,codeAndAmount,supplierCode,materialCode,storageId);
        System.out.println(purchaseAdmit.toString());
        HashMap<String,String> params=new HashMap<String, String>();
        RequestObject.getStatus(RequestObject.testPost(Environment.server_manufacture,"/v2/materialLot/_admit_by_procure_order",purchaseAdmit,params),statusCode);

    }
}
