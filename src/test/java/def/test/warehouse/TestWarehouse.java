package def.test.warehouse;

import defParams.WarehouseParams;
import defRequest.RequestObject;
import org.testng.annotations.Test;

import java.util.HashMap;

public class TestWarehouse {

    /**
     * 测试创建仓库
     * @param code
     * @param name
     * @param category
     * @param statusCode
     * @param msg
     */
    @Test(dataProvider = "getWarehouse",dataProviderClass = WarehouseParams.class)
    public void testwarehousePost(String code,String name,int category,int statusCode,String msg) {
        HashMap<String, String> body = new HashMap<String, String>();
        System.out.println("----------" + msg + "----------");
        body.put("code", code);
        body.put("name", name);
        body.put("category", category+"");
        HashMap<String, String> params = new HashMap<String, String>();
        System.out.println(code);
        RequestObject.getStatus(RequestObject.testPost("warehouse", body, params), statusCode);
    }



}
