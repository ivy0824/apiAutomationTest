package request;

import config.Environment;
import io.restassured.response.ValidatableResponse;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class RequestObject{

//     1. baseUrl
    public static final String orgId = Environment.orgId;
    public static final String userId = Environment.userId;
    public static final String userName = Environment.userName;



    /**get请求方法
     * @parampath
     * @paramparams
     */
    public static ValidatableResponse testGet(String server,String path,HashMap params){
        return given()
                .header("X-Org-Id",orgId)
                .params(params)
                .when().get("http://"+server+"-feature.test.blacklake.tech" + path)
                .then()
                .log().all();
    }


    /**
     * post请求方法
     * @param path
     * @param body
     * @param params
     */
    public static ValidatableResponse testPost(String server, String path, Object body, HashMap params){

        return given()
                .contentType("application/json")
                .header("X-Org-Id",orgId)
                .header("X-User-Id",userId)
                .header("X-User-Name",userName)
                .body(body)
                .params(params)
                .when().post("http://"+server+"-feature.test.blacklake.tech" + path)
                .then()
                .log().all();
    }


    /**
     * 判断返回状态是多少
     * @param response
     * @param statusCode
     */
    public static void getStatus(ValidatableResponse response, int statusCode){
        response.statusCode(statusCode);
    }



    /**
     * 判断返回响应体信息
     * @param response
     * @param jsonPath
     * @param responseMessage  String
     */
    public static void getResponseMessage(ValidatableResponse response, String jsonPath, String responseMessage){
        response.body(jsonPath, equalTo(responseMessage));
    }

    /**
     * 判断返回响应体信息
     * @param response
     * @param jsonPath
     * @param responseMessage  int
     */
    public static void getResponseMessage(ValidatableResponse response, String jsonPath, int responseMessage){
        response.body(jsonPath, equalTo(responseMessage));
    }

    /**
     * 判断返回响应体信息是否包含某些信息
     * @param response
     * @param jsonPath
     * @param responseMessage
     */
    public static void getHasItem(ValidatableResponse response, String jsonPath, String responseMessage){
        response.body(jsonPath, hasItem(responseMessage));
    }
}