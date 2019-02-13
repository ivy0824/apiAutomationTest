package manufacture.test.manufactureRequest;

import io.restassured.response.ValidatableResponse;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RequestObject {

    // 1. baseUrl
    public static final String baseUrl = "http://manufacture.blacklake.tech/v1/";

    /**
     * get请求方法
     * @param path
     * @param params
     */
    public static ValidatableResponse testGet(String path, HashMap params) {
        return given()
                .header("X-Org-Id", "2")
                .params(params)
                .when().get(baseUrl + path)
                .then()
                .log().all();
    }

    /**
     * post请求防范
     * @param path
     * @param body
     * @param params
     */
    public static ValidatableResponse testPost(String path, HashMap body, HashMap params) {

        return given()
                .contentType("application/json")
                .header("X-Org-Id", "2")
                .body(body)
                .params(params)
                .when().post(baseUrl + path)
                .then()
                .log().all();
    }

    /**
     * 判断返回状态是多少
     *
     * @param response
     * @param statusCode
     */
    public static void getStatus(ValidatableResponse response, int statusCode) {
        response.statusCode(statusCode);
    }

    /**
     * 判断返回名称是多少
     *
     * @param response
     * @param name
     */
    public static void getData(ValidatableResponse response, String name) {
        response.body("data.name", equalTo(name));
    }

    /**
     * 判断返回状态和名称
     * response
     * statusCode
     * name
     */
    public static void getResult(ValidatableResponse response, int statusCode) {
        Object t = response.statusCode(statusCode);
        System.out.println("-----------" + t);
//        response.body("data.name", equalTo(name));
    }
}



