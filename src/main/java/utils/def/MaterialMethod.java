package utils.def;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import config.Environment;
import org.springframework.context.annotation.Bean;
import utils.common.RequestObject;

import java.util.HashMap;

public class MaterialMethod {


    /**
     * 创建一个随机单位的物料并获取响应值
     * @param code
     * @param name
     * @param jsonPath
     * @return
     */
    public static String getMaterialResponse(String code, String name, String jsonPath) {
        String unitName = (int) (Math.random() * 10000) + "";
        String unitId = UnitMethod.getUnitResponse(unitName, "data.id");
        HashMap<String, String> body = new HashMap<String, String>();
        body.put("code", "code" + code);
        body.put("name", "material" + name);
        body.put("status", "1");
        body.put("unitId", unitId);
        body.put("fifo","false");
        HashMap<String, String> params = new HashMap<String, String>();
        String materialResponse = RequestObject.testPost(Environment.server_def,"material", body, params).extract().path(jsonPath);
        return materialResponse;

    }

    /**
     * 创建一个随机单位的物料并获取单位ID
     * @param code
     * @param name
     * @return
     */
    public static int getUnitID(String code, String name) {
        String unitName = (int) (Math.random() * 10000) + "";
        String unitId = UnitMethod.getUnitResponse(unitName, "data.id");
        HashMap<String, String> body = new HashMap<String, String>();
        body.put("code", "code" + code);
        body.put("name", "material" + name);
        body.put("status", "1");
        body.put("unitId", unitId);
        HashMap<String, String> params = new HashMap<String, String>();
        int unitID = RequestObject.testPost(Environment.server_def,"material", body, params).extract().path("data.unitID");
        return unitID;

    }

    /**
     * 创建物料
     * @param code
     * @param name
     */
    public static void createMaterial(String code, String name) {
        String unitName = (int) (Math.random() * 10000) + "";
        String unitId = UnitMethod.getUnitResponse(unitName, "data.id");
        HashMap<String, String> body = new HashMap<String, String>();
        body.put("code", "code" + code);
        body.put("name", "material" + name);
        body.put("status", "1");
        body.put("unitId", unitId);
        body.put("fifo","false");
        HashMap<String, String> params = new HashMap<String, String>();
        RequestObject.testPost(Environment.server_def,"material", body, params);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

}


