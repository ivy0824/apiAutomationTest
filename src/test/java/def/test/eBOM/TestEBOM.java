package def.test.eBOM;

import defParams.EBOMParams;
import defObject.EBOM;
import defRequest.RequestObject;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class TestEBOM {

    @Test(dataProvider = "getEBOM",dataProviderClass = EBOMParams.class)
    public void testEBOMPost(String productMaterialCode,String productmaterialname,int currentUnitId,int status,String version,ArrayList rawMaterialList ,int statusCode,String msg) {
        EBOM eBOM = new EBOM(productMaterialCode,productmaterialname,currentUnitId,status,version,rawMaterialList);
        HashMap<String, String> params = new HashMap<String, String>();
        System.out.println("----------" + msg + "----------");
        RequestObject.getStatus(RequestObject.testPost("ebom", eBOM, params), statusCode);
    }

    @Test(dataProvider = "getEBOM1",dataProviderClass = EBOMParams.class)
    public void testEBOMPost1(String productMaterialCode,String productmaterialname,int currentUnitId,int status,String version,ArrayList rawMaterialList,int statusCode,String msg) {
        EBOM eBOM = new EBOM(productMaterialCode,productmaterialname,currentUnitId,status,version,rawMaterialList);
        HashMap<String, String> params = new HashMap<String, String>();
        System.out.println("----------" + msg + "----------");
        RequestObject.getStatus(RequestObject.testPost("ebom", eBOM, params), statusCode);
    }

}

