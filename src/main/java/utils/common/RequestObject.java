package utils.common;

import blacklake.lakers.Org;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import config.Environment;
import io.restassured.response.ValidatableResponse;
import org.springframework.context.annotation.Bean;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class RequestObject{

//     1. baseUrl
    public static final String url = Environment.url;
    public static final String orgId = Environment.orgId;
    public static final String userId = Environment.userId;
    public static final String userName = Environment.userName;

    public static final String orgId1 = "138";
    public static final String userId1 = "11908";
    public static final String userName1 = "admin";

    /**
     * post请求方法,创建工厂专用的请求
     * @param path
     * @param body
     */
    public static ValidatableResponse post(String server, String path, Object body){

        return given()
                .contentType("application/json")
                .body(body)
                .log().all()
                .when().post("http://"+server+url + path)
                .then()
                .log().all();
    }

    /**
     * post请求方法
     * @param path
     * @param body
     */
    public  ValidatableResponse postRequest(String server, String path, Object body){

        return given()
                .contentType("application/json")
                .header("X-Org-Id", orgId1)
                .header("X-User-Id",userId1)
                .header("X-User-Name",userName1)
                .body(body)
                .log().all()
                .when().post("http://"+server+url + path)
                .then()
                .log().all();
    }

    /**
     * put请求方法
     * @param path
     * @param body
     */
    public static ValidatableResponse putRequest(String server, String path, Object body){

        return given()
                .contentType("application/json")
                .header("X-Org-Id", orgId1)
                .header("X-User-Id",userId1)
                .header("X-User-Name",userName1)
                .body(body)
                .log().all()
                .when().put("http://"+server+url + path)
                .then()
                .log().all();
    }


    /**get请求方法
     * @parampath
     * @paramparams
     */
    public static ValidatableResponse testGet(String server,String path,HashMap params){
        return given()
                .header("X-Org-Id",orgId)
                .params(params)
                .when().get("http://"+server+url + path)
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
                .log().all()
                .when().post("http://"+server+url + path)
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
    public static void getContainsString(ValidatableResponse response, String jsonPath, String responseMessage){
        response.body(jsonPath, containsString(responseMessage));
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }
}