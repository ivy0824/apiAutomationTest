package utils.def;

import config.Environment;
import request.RequestObject;

import java.util.HashMap;

public class StorageMethod {

    public static String createStorage1(String code,String name,String parentCode,int level) {
        HashMap<String, String> body = new HashMap<String, String>();
        body.put("code", code);
        body.put("name", name);
        body.put("parentCode", parentCode);
        body.put("level", level+"");
        HashMap<String, String> params = new HashMap<String, String>();
        RequestObject.testPost(Environment.server_def,"storage", body, params);
        return code;
    }

    public static String createStorage2(String code,String name,String parentCode,int level) {
        HashMap<String, String> body = new HashMap<String, String>();
        body.put("code", code);
        body.put("name", name);
        body.put("parentCode", parentCode);
        body.put("level", level+"");
        HashMap<String, String> params = new HashMap<String, String>();
        return code;
    }
}
