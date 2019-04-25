package def.material;

import Params.def.MaterialParams;
import config.Environment;
import io.restassured.response.ValidatableResponse;
import utils.common.JsonReader;
import utils.common.RequestObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import utils.def.UnitMethod;

public class TestMaterial {

    private static String unitId;

    /**
     * 创建单位并获取单位id
     */
    @BeforeClass
    public static void getUnitId(){
        String name = (int) (Math.random() * 10000) + "";
        unitId = UnitMethod.getUnitResponse(name,"data.id");
    }

    /**
     * 测试创建物料
     * @param code
     * @param name
     * @param statusCode
     * @param msg
     */
//    @Test(dataProvider = "getMaterial",dataProviderClass = MaterialParams.class)
//    public void testMaterialPost(String code,String name,int statusCode,String msg) {
//        HashMap<String, String> body = new HashMap<String, String>();
//        System.out.println("----------" + msg + "----------");
//        body.put("code", code);
//        body.put("name", name);
//        body.put("status", "1");
//        body.put("unitId",unitId);
//        body.put("fifo","false");
//        HashMap<String, String> params = new HashMap<String, String>();
//        RequestObject.getStatus(RequestObject.testPost(Environment.server_def,"/v1/material", body, params), statusCode);
//    }

//    /**
//     * 用excel数据测试
//     * @param code
//     * @param name
//     * @param statusCode
//     */
//    @Test(dataProvider = "getMaterialWithExcel",dataProviderClass = MaterialParams.class)
//    public void testMaterialPost1(String code,String name,String statusCode) {
//        HashMap<String, String> body = new HashMap<String, String>();
////        System.out.println("----------" + msg + "----------");
//        body.put("code", code);
//        body.put("name", name);
//        body.put("status", "1");
//        body.put("unitId",unitId);
//        HashMap<String, String> params = new HashMap<String, String>();
//        RequestObject.getStatus(RequestObject.testPost(Environment.server_def,"/v1/material", body, params),Integer.valueOf(statusCode).intValue());
//    }

    /**
     * 用csv数据测试
     * @param code
     * @param name
     * @param statusCode
     */
//    @Test(dataProvider = "getMaterialWithCSV",dataProviderClass = MaterialParams.class)
//    public void testMaterialPost1(String code, String name, String statusCode) {
//        HashMap<String, String> body = new HashMap<String, String>();
////        System.out.println("----------" + msg + "----------");
//        body.put("code", code);
//        body.put("name", name);
//        body.put("status", "1");
//        body.put("fifo","false");
//        body.put("unitId",unitId);
//        HashMap<String, String> params = new HashMap<String, String>();
//        ValidatableResponse response = RequestObject.testPost(Environment.server_def,"/v1/material", body, params);
//        RequestObject.getStatus(response, Integer.parseInt(statusCode));
//    }


    /* 用json数据测试
     * @param code
     * @param name
     * @param statusCode
     * @param msg
     */
    @Test(dataProvider = "getMaterial",dataProviderClass = MaterialParams.class)
    public void testMaterialPost3(String code, String name, int statusCode,String msg) {
        System.out.println("----------" + msg + "----------");
        HashMap<String, Object> map = new HashMap<>();
        //修改原json数据中内容
        map.put("code", code);
        map.put("name", name);
        String body = JsonReader.getJson("/data/def/material.json",map);
        System.out.println(body);
        HashMap<String, String> params = new HashMap<String, String>();
        ValidatableResponse response = RequestObject.testPost(Environment.server_def,"/v1/material", body, params);
        RequestObject.getStatus(response, statusCode);
    }




    /**
     * 测试创建物料后状态的返回值是否正确
     * @param code
     * @param name
     * @param status
     * @param msg
     */
    @Test(dataProvider = "getMaterialStatus",dataProviderClass = MaterialParams.class)
    public void testMaterialStatus(String code,String name,int status,String msg){
        HashMap<String, String> body = new HashMap<String, String>();
        System.out.println("----------" + msg + "----------");
        body.put("code", code);
        body.put("name", name);
        body.put("status", status+"");
        body.put("unitId",unitId);
        body.put("fifo","false");
        HashMap<String, String> params = new HashMap<String, String>();
        RequestObject.getResponseMessage(RequestObject.testPost(Environment.server_def,"/v1/material", body, params), "data.status", status);
    }

}