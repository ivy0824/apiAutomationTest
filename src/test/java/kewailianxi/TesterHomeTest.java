//package kewailianxi;
//
//import io.restassured.RestAssured;
//import io.restassured.filter.Filter;
//import io.restassured.filter.FilterContext;
//import io.restassured.response.Response;
//import io.restassured.specification.FilterableRequestSpecification;
//import io.restassured.specification.FilterableResponseSpecification;
//import org.testng.annotations.Test;
//
//import static io.restassured.RestAssured.given;
//import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
//
//public class TesterHomeTest {
//
//    @Test
//    public void testSchema(){
//        given()
//                .when().get("https://testerhome.com/api/v3/topics/6040.json")
//                .then()
//                .statusCode(200)
//                .body(matchesJsonSchemaInClasspath("schema/json.schema"))
//                .log().all();
//
//    }
//
//    @Test
//    public void testFilterResponse(){
//        given()
//                .filter(new Filter() {
//                    public Response filter(FilterableRequestSpecification req, FilterableResponseSpecification res, FilterContext ctx) {
//                        //code
//                        //fliter request
//                        System.out.println(req.getURI());
//                        System.out.println(res);
//                        //request real
//                        Response resNew = ctx.next(req, res);
//                        //response real
//                        //filter response
//                        //return response
//                        //then
//                        System.out.println(resNew.getStatusLine());
//                        return resNew;
//                    }
//                })
//                .when()
//                .get("https://testerhome.com/api/v3/topics/6040.json")
//                .then()
//                .statusCode(200)
//                .body(matchesJsonSchemaInClasspath("schema/json.schema"))
//                .log().all();
//
//    }
//
//    @Test
//    public void testFilter(){
//
////        RestAssured.filters((req,res,ctx)->{
////
////            return ;
////        })
//        given()
//                .filter((req, res, ctx)->{
//            req.header("testerhome","seveniruby");
//            Response resOrigin = ctx.next(req,res);
//            return resOrigin;
//        })
//                .cookie("")
//                .when().get("https://testerhome.com/api/v3/topics/6040.json")
//                .then()
//                .log().all()
//                .statusCode(200);
//    }
//}
