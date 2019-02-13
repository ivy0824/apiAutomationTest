package def.test.utils;

import def.test.defRequest.RequestObject;

import java.util.HashMap;

public class UnitMethod {

    /**
     * 创建单位并获取单位响应值
     * @param name
     * @param jsonPath
     * @return
     */
    public static String getUnitResponse(String name,String jsonPath){
        HashMap<String, String> body = new HashMap<String, String>();
        body.put("name", "单位" + name);
        HashMap<String, String> params = new HashMap<String, String>();
        String unitResponse = RequestObject.testPost("unit", body, params).extract().path(jsonPath)+"";
        return unitResponse;
    }

    public static void createUnit(String name,String jsonPath){
        HashMap<String, String> body = new HashMap<String, String>();
        body.put("name", "单位" + name);
        HashMap<String, String> params = new HashMap<String, String>();
        RequestObject.testPost("unit", body, params);
    }


}
