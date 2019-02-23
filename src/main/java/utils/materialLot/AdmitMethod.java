package utils.materialLot;

import config.Environment;
import object.materialLot.Admit;
import request.RequestObject;

import java.util.ArrayList;
import java.util.HashMap;

import static request.RequestObject.testPost;

public class AdmitMethod {

    public static HashMap<String,Integer> admit(String materialCode, ArrayList codesAndAmounts, ArrayList mfgBatches, Object storageId){

        Admit admit = new Admit(materialCode,codesAndAmounts,mfgBatches,storageId);
        System.out.println(admit.toString());
        HashMap<String,Integer> params=new HashMap<String, Integer>();
        HashMap<String, Integer> allIds = RequestObject.testPost(Environment.server_manufacture,"/v2/materialLot/_admit", admit, params).extract().path("data");
        System.out.println(allIds);
        return allIds;


    }
}
