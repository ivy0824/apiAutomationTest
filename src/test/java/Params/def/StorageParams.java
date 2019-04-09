package Params.def;

import utils.def.StorageMethod;
import utils.def.WarehouseMethod;
import org.testng.annotations.DataProvider;

public class StorageParams {

    /**
     * 创建一级仓位的测试数据
     * code
     * name
     * parentCode
     * level
     * statusCode
     * 测试用例描述
     * @return
     */
    @DataProvider
    public Object[][] getStorage1() {
        String code = (int) (Math.random() * 10000) + "";
        int[] qualityControlItems = {1,2,3,4};
        String parentCode = WarehouseMethod.createWarehouse("warehouse"+code,code,1,qualityControlItems,true);
        return new Object[][]{
                {"storage1" + code,"",parentCode,1, 400, "创建有编码没有名称的一级仓位"},
                {"", code,parentCode,1, 400, "创建无编码有名称的一级仓位"},
                {"storage1" + code, code,parentCode,1, 200, "创建有编码有名称的一级仓位"},
                {"storage1" + code, code,parentCode,1, 400, "创建编码重复的一级仓位"}

        };
    }

    /**
     * 创建二级仓位的测试数据
     * code
     * name
     * parentCode
     * level
     * statusCode
     * 测试用例描述
     * @return
     */
    @DataProvider
    public Object[][] getStorage2() {
        String code = (int) (Math.random() * 10000) + "";
        int[] qualityControlItems2 = {1,2,3,4};
        String parentCode = WarehouseMethod.createWarehouse("warehouse"+code,code,1,qualityControlItems2,true);
        String storage1 = StorageMethod.createStorage1("storage1"+code,code,parentCode,1);
        return new Object[][]{
                {"storage2" + "storage2"+code,"",storage1,2, 400, "创建有编码没有名称的二级仓位"},
                {"", code,storage1,2, 400, "创建无编码有名称的二级仓位"},
                {"storage2" + code, "storage2"+code,storage1,2, 200, "创建有编码有名称的二级仓位"},
                {"storage2" + code, "storage2"+code,storage1,2, 400, "创建编码重复的二级仓位"}

        };
    }
}
