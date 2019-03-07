package materialLot.transfer;

import Params.materialLot.TransferParams;
import config.Environment;
import object.materialLot.Transfer;
import org.testng.annotations.Test;
import request.RequestObject;
import java.util.ArrayList;
import java.util.HashMap;

public class TestTransfer {

    @Test(dataProvider= "getTransfer",dataProviderClass = TransferParams.class)
    private void testTransferPost(int inStorageId, int[] materialLotIdList,int[] materialLotContainerIdList, String result, String msg){

        System.out.println("----------" + msg + "----------");

        Transfer transfer = new Transfer(inStorageId,materialLotIdList,materialLotContainerIdList);
        System.out.println(transfer.toString());
        HashMap<String,String> params=new HashMap<String, String>();
        RequestObject.getContainsString(RequestObject.testPost(Environment.server_manufacture, "/v2/materialLot/_transfer", transfer, params),"message",result);

    }

}
