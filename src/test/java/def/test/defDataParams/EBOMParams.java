package def.test.defDataParams;

import def.test.defObject.RawMaterial;
import org.testng.annotations.BeforeClass;
import def.test.utils.MaterialMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class EBOMParams {

    private static String code1;
    private static String code2;
    private static String code3;
    private static String unitId1;
    private static String unitId2;
    private static String unitId3;

    @BeforeClass
    public static void createMaterial() {
        //创建物料
        String code1 = (int) (Math.random() * 10000) + "";
        String code2 = (int) (Math.random() * 10000) + "";
        String code3 = (int) (Math.random() * 10000) + "";
        int unitId1 = MaterialMethod.getUnitID(code1, code1);
        int unitId2 = MaterialMethod.getUnitID(code2, code2);
        int unitId3 = MaterialMethod.getUnitID(code3, code3);

    }


    /**
     * 创建不同的EBOM数据
     * productMaterialCode
     * productmaterialname
     * currentUnitId
     * status
     * version
     * rawMaterialList
     * statusCode
     * msg 测试用例描述
     * @return
     */
    @DataProvider
    public Object[][] getEBOM() {
        //创建物料清单数组数据
        ArrayList<RawMaterial> rawMaterialList = new ArrayList<RawMaterial>();
        RawMaterial rawMaterial1 = new RawMaterial("1","1","1","1000001",true);
        RawMaterial rawMaterial2 = new RawMaterial("1","1","1","1000002",true);
        rawMaterialList.add(rawMaterial1);
        rawMaterialList.add(rawMaterial2);

        String version = (int) (Math.random() * 10000) + "";
        return new Object[][]{
                {"1000003","1000003",1,1,version+"1",rawMaterialList,400,"创建版本号为空的物料清单"},
                {"1000003","1000003",1,1,version+"2",rawMaterialList,200,"创建有效的物料清单"},
                {"1000003","1000003",1,1,version+"2",rawMaterialList,400,"创建版本号重复的物料清单"},

        };
    }

    /**
     * 创建不同的物料列表数据
     * productMaterialCode
     * productmaterialname
     * currentUnitId
     * status
     * version
     * rawMaterialList
     * msg 测试用例描述
     * @return
     */
    @DataProvider
    public Object[][] getEBOM1() {
        //创建物料清单数组数据
        ArrayList<RawMaterial> rawMaterialList = new ArrayList<RawMaterial>();
        RawMaterial rawMaterial1 = new RawMaterial("1","1","1",code1,true);
        RawMaterial rawMaterial2 = new RawMaterial("1","1","1",code2,true);
        rawMaterialList.add(rawMaterial1);
        rawMaterialList.add(rawMaterial2);

        //创建一个数据都为空的物料列表
        ArrayList<RawMaterial> rawMaterialList1 = new ArrayList<RawMaterial>();
        RawMaterial rawMaterial3 = new RawMaterial("1","1","1",code1,true);
        RawMaterial rawMaterial4 = new RawMaterial("","","","",true);
        rawMaterialList1.add(rawMaterial3);
        rawMaterialList1.add(rawMaterial4);

        return new Object[][]{
                {code3,code3,unitId1,1,"1001",rawMaterialList,200,"创建正常的物料列表"},
                {code3,code3,unitId1,1,"1002",rawMaterialList1,400,"创建值为空的物料列表"},
        };
    }

}



