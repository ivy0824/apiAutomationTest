package Params.def;

import org.testng.annotations.DataProvider;
import utils.common.CSVReader;
import utils.common.ExcelReader;
import utils.common.JsonReader;

public class MaterialParams {

    /**
     * 创建物料的测试数据
     * code
     * name
     * fifo
     * statusCode
     * 测试用例描述
     * @return
     */
    @DataProvider
    public Object[][] getMaterial() {
        String code = (int) (Math.random() * 10000) + "";
        return new Object[][]{
                {"material1" + code, "", 400, "创建有编码没有名称的物料"},
                {"", code, 400, "创建无编码有名称的物料"},
                {"material" + code, "test0002", 200, "创建有编码有名称的物料"},
                {"material" + code, code, 400, "创建编码重复的物料"}

        };
    }

    @DataProvider
    public Object[][]getMaterialWithExcel(){
        return ExcelReader.readExcel("./dataXlsx/material.xlsv");
    }


    @DataProvider
    public Object[][]getMaterialWithCSV() throws Exception {
        return CSVReader.getData("./dataXlsx/material.csv");
    }



    /**
     * 创建不同状态物料的测试数据
     * code
     * name
     * status
     * 测试用例描述
     * @return
     */
    @DataProvider
    public Object[][] getMaterialStatus() {
        String code = (int) (Math.random() * 10000) + "";
        return new Object[][]{
                {code, code, 1, "创建状态为启用中的物料"},
                {code+"1", code, 0, "创建状态为停用中的物料"},

        };
    }




    /**暂时做不了
     * 特殊字符验证
     * @return
     */
    @DataProvider
    public Object[][] getSpecialMaterila() {
        return new Object[][]{
                {"material", "material", 400, "创建有编码没有名称的物料"},
                {"material", "material", 400, "创建无编码有名称的物料"},
                {"material", "material", 200, "创建有编码有名称的物料"},
                {"material", "material", 400, "创建编码重复的物料"}
        };
    }


}
