package utils.def;

import config.Environment;
import request.RequestObject;
import java.util.HashMap;

public class WarehouseMethod {

    /**
     * 创建仓库
     * @param code
     * @param name
     * @param category
     */
    public static String createwarehouse(String code,String name,int category) {
        HashMap<String, String> body = new HashMap<String, String>();
        body.put("code", code);
        body.put("name", name);
        body.put("category", category+"");
        HashMap<String, String> params = new HashMap<String, String>();
        RequestObject.testPost(Environment.server_def,"warehouse", body, params);
        System.out.println(code);
        return code;
    }


}
