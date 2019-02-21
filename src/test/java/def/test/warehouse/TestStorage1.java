package def.test.warehouse;

import defParams.StorageParams;
import defRequest.RequestObject;
import org.testng.annotations.Test;

import java.util.HashMap;

public class TestStorage1 {
    /**
     * 测试创建一级仓位
     * @param code
     * @param name
     * @param parentCode
     * @param level
     * @param statusCode
     * @param msg
     */
    @Test(dataProvider = "getStorage1",dataProviderClass = StorageParams.class)
    public void testStorage1Post(String code,String name,String parentCode,int level,int statusCode,String msg) {
        HashMap<String, String> body = new HashMap<String, String>();
        System.out.println("----------" + msg + "----------");
        body.put("code", code);
        body.put("name", name);
        body.put("parentCode", parentCode);
        body.put("level", level+"");
        HashMap<String, String> params = new HashMap<String, String>();
        RequestObject.getStatus(RequestObject.testPost("storage", body, params), statusCode);
    }
}
