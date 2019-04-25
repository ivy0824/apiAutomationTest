package Params.materialLot;

import config.Environment;
import object.materialLot.CodeAndAmount;
import org.testng.annotations.DataProvider;
import java.util.ArrayList;

public class PurchaseAdmitParams {

    /**
     * 创建按采购清单入厂的测试数据
     * procureOrderId：180
     * procureOrderDetailId：388-390
     * codeAndAmount
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
        ArrayList<CodeAndAmount> codeAndAmount = new ArrayList<CodeAndAmount>();
        CodeAndAmount codeAndAmount1 = new CodeAndAmount(100.0,qcCode,"拖");
        codeAndAmount.add(codeAndAmount1);

        //创建入厂的：数量，二维码，单位 数据
        ArrayList<CodeAndAmount> codeAndAmountO = new ArrayList<CodeAndAmount>();
        CodeAndAmount codeAndAmountO1 = new CodeAndAmount(100.0,qcCode+"0","拖");
        codeAndAmountO.add(codeAndAmountO1);

        //创建入厂多个二维码数据
        ArrayList<CodeAndAmount> codeAndAmountM = new ArrayList<CodeAndAmount>();
        CodeAndAmount codeAndAmountM1 = new CodeAndAmount(100.0,qcCode+"1-0","拖");
        CodeAndAmount codeAndAmountM2 = new CodeAndAmount(100.0,qcCode+"1-1","拖");
        CodeAndAmount codeAndAmountM3 = new CodeAndAmount(100.0,qcCode+"1-2","拖");
        codeAndAmountM.add(codeAndAmountM1);
        codeAndAmountM.add(codeAndAmountM2);
        codeAndAmountM.add(codeAndAmountM3);

        //创建数量为0的二维码数据
        ArrayList<CodeAndAmount> codeAndAmountZ = new ArrayList<CodeAndAmount>();
        CodeAndAmount codeAndAmountZ1 = new CodeAndAmount(0.0,qcCode+"2","拖");
        codeAndAmountZ.add(codeAndAmountZ1);

        //创建使用转换单位的二维码数据
        ArrayList<CodeAndAmount> codeAndAmountT = new ArrayList<CodeAndAmount>();
        CodeAndAmount codeAndAmountT1 = new CodeAndAmount(100.0,qcCode+"3","瓶");
        codeAndAmountT.add(codeAndAmountT1);

        //创建没有入厂二维码的数据
        ArrayList<CodeAndAmount> codeAndAmountN = new ArrayList<CodeAndAmount>();
        CodeAndAmount codeAndAmountN1 = new CodeAndAmount(null,"","");
        codeAndAmountN.add(codeAndAmountN1);


        return new Object[][]{
                {180,388,codeAndAmountZ,"","1000003", Environment.storageId,400,"创建没有入厂二维码的数据"},
                {180,388,codeAndAmount,"","1000003",null,400,"创建没有入厂仓位的数据"},
                {180,388,codeAndAmount,"","1000003",Environment.storageId,200,"创建成功入厂的数据"},
                {180,388,codeAndAmountT,"","1000003",Environment.storageId,200,"创建使用转换单位入厂的数据"},

                {180,388,codeAndAmount,"","1000003",Environment.storageId,400,"创建入厂二维码重复的数据"},

                {180,388,codeAndAmountM,"","1000003",Environment.storageId,200,"创建入厂多个二维码的数据"},


        };
    }

}
