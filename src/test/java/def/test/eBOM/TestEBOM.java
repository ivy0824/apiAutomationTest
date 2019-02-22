package def.test.eBOM;

import config.Environment;
import object.def.EBOM;
import Params.def.EBOMParams;
import request.RequestObject;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class TestEBOM {

    @Test(dataProvider = "getEBOM",dataProviderClass = EBOMParams.class)
    public void testEBOMPost(String productMaterialCode,String productmaterialname,int currentUnitId,int status,String version,ArrayList rawMaterialList ,int statusCode,String msg) {
        EBOM eBOM = new EBOM(productMaterialCode,productmaterialname,currentUnitId,status,version,rawMaterialList);
        System.out.println(eBOM.toString());
        HashMap<String, String> params = new HashMap<String, String>();
        System.out.println("----------" + msg + "----------");
        RequestObject.getStatus(RequestObject.testPost(Environment.server_def,"ebom", eBOM, params), statusCode);
    }

    @Test(dataProvider = "getEBOM1",dataProviderClass = EBOMParams.class)
    public void testEBOMPost1(String productMaterialCode,String productmaterialname,int currentUnitId,int status,String version,ArrayList rawMaterialList,int statusCode,String msg) {
        EBOM eBOM = new EBOM(productMaterialCode,productmaterialname,currentUnitId,status,version,rawMaterialList);
        HashMap<String, String> params = new HashMap<String, String>();
        System.out.println("----------" + msg + "----------");
        RequestObject.getStatus(RequestObject.testPost(Environment.server_def,"ebom", eBOM, params), statusCode);
    }

}

