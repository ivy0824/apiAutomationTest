package def.test.defDataParams;

import org.testng.annotations.DataProvider;

public class WarehouseParams {

    private String code = (int) (Math.random() * 10000) + "";

    /**
     * 创建车间的测试数据
     * code
     * name
     * category
     * statusCode
     * 测试用例描述
     * @return
     */
    @DataProvider
    public Object[][] getWarehouse() {
        return new Object[][]{
                {"warehouse" + code, "",1, 400, "创建有编码没有名称的仓库"},
                {"", code,1, 400, "创建无编码有名称的仓库"},
                {"warehouse" + code, code,1, 200, "创建有编码有名称的仓库"},
                {"warehouse" + code, code,1, 400, "创建编码重复的仓库"}

        };
    }


}
