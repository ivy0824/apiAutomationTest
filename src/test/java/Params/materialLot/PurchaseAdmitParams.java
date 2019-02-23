package Params.materialLot;

import object.materialLot.CodesAndAmounts;
import object.materialLot.MfgBatches;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;

public class PurchaseAdmitParams {

    /**
     * 创建按采购清单入厂的测试数据
     * procureOrderId：180
     * procureOrderDetailId：388-390
     * codesAndAmounts
     * supplierCode
     * materialCode
     * storageId
     * statusCode
     * 测试用例描述
     * @return
     */
    @DataProvider
    public Object[][] getPurchaseAdmit(){

        String qcCode = (int) (Math.random() * 100000) + "";

        //创建入厂的：数量，二维码，单位 数据
        ArrayList<CodesAndAmounts> codesAndAmounts = new ArrayList<CodesAndAmounts>();
        CodesAndAmounts codesAndAmounts1 = new CodesAndAmounts("100",qcCode,"拖");
        codesAndAmounts.add(codesAndAmounts1);

        //创建入厂的：数量，二维码，单位 数据
        ArrayList<CodesAndAmounts> codesAndAmountsO = new ArrayList<CodesAndAmounts>();
        CodesAndAmounts codesAndAmountsO1 = new CodesAndAmounts("100",qcCode+"0","拖");
        codesAndAmountsO.add(codesAndAmountsO1);

        //创建入厂多个二维码数据
        ArrayList<CodesAndAmounts> codesAndAmountsM = new ArrayList<CodesAndAmounts>();
        CodesAndAmounts codesAndAmountsM1 = new CodesAndAmounts("100",qcCode+"1-0","拖");
        CodesAndAmounts codesAndAmountsM2 = new CodesAndAmounts("100",qcCode+"1-1","拖");
        CodesAndAmounts codesAndAmountsM3 = new CodesAndAmounts("100",qcCode+"1-2","拖");
        codesAndAmountsM.add(codesAndAmountsM1);
        codesAndAmountsM.add(codesAndAmountsM2);
        codesAndAmountsM.add(codesAndAmountsM3);

        //创建数量为0的二维码数据
        ArrayList<CodesAndAmounts> codesAndAmountsZ = new ArrayList<CodesAndAmounts>();
        CodesAndAmounts codesAndAmountsZ1 = new CodesAndAmounts("0",qcCode+"2","拖");
        codesAndAmountsZ.add(codesAndAmountsZ1);

        //创建使用转换单位的二维码数据
        ArrayList<CodesAndAmounts> codesAndAmountsT = new ArrayList<CodesAndAmounts>();
        CodesAndAmounts codesAndAmountsT1 = new CodesAndAmounts("100",qcCode+"3","瓶");
        codesAndAmountsT.add(codesAndAmountsT1);

        //创建没有入厂二维码的数据
        ArrayList<CodesAndAmounts> codesAndAmountsN = new ArrayList<CodesAndAmounts>();
        CodesAndAmounts codesAndAmountsN1 = new CodesAndAmounts("","","");
        codesAndAmountsN.add(codesAndAmountsN1);


        return new Object[][]{
                {180,388,codesAndAmountsZ,"","1000003",1319,400,"创建没有入厂二维码的数据"},
                {180,388,codesAndAmounts,"","1000003",null,400,"创建没有入厂仓位的数据"},
                {180,388,codesAndAmounts,"","1000003",1319,200,"创建成功入厂的数据"},
                {180,388,codesAndAmountsT,"","1000003",1319,200,"创建使用转换单位入厂的数据"},

                {180,388,codesAndAmounts,"","1000003",1319,400,"创建入厂二维码重复的数据"},

                {180,388,codesAndAmountsM,"","1000003",1319,200,"创建入厂多个二维码的数据"},


        };
    }

}
