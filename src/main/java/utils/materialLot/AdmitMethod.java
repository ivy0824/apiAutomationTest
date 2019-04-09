package utils.materialLot;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import config.Environment;
import object.materialLot.Admit;
import request.RequestObject;
import java.util.ArrayList;
import java.util.HashMap;

//忽略序列化问题
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AdmitMethod {

    public static HashMap<String,Integer> admit(String materialCode, ArrayList codesAndAmounts, Object storageId){

        Admit admit = new Admit();
        admit.admitNeed(materialCode,codesAndAmounts,storageId);
        System.out.println(admit.toString());
        HashMap<String,Integer> params=new HashMap<String, Integer>();
        HashMap<String, Integer> allIds = RequestObject.testPost(Environment.server_manufacture,"/v2/materialLot/_admit", admit, params).extract().path("data");
        System.out.println(allIds);
        return allIds;


    }
}
