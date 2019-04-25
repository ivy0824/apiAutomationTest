package Params.materialLot;

import config.Environment;
import object.materialLot.CodeAndAmount;
import object.materialLot.MfgBatches;
import org.testng.annotations.DataProvider;
import utils.materialLot.AdmitMethod;
import java.util.ArrayList;
import java.util.HashMap;

public class DeliverParams {

//    @Test
//    public void test(){
//        String qcCode = (int) (Math.random() * 100000) + "";
//
//        int[] materialLotIdList1 = {parseInt(qcCode)};
//       for(int a:materialLotIdList1){
//           System.out.println(a);
//       }
//        //创建入厂的：数量，二维码，单位 数据
//        ArrayList<codeAndAmount> codeAndAmount = new ArrayList<codeAndAmount>();
//        codeAndAmount codeAndAmount01 = new codeAndAmount("100",qcCode,"瓶");
//        codeAndAmount codeAndAmountO2 = new codeAndAmount("100",qcCode+"1","瓶");
//
//        codeAndAmount.add(codeAndAmount01);
//        codeAndAmount.add(codeAndAmountO2);
//
//        //创建供应商数据
//        ArrayList<MfgBatches> mfgBatches = new ArrayList<MfgBatches>();
//        MfgBatches mfgBatches1 = new MfgBatches("供应商批次号1");
//        MfgBatches mfgBatches2 = new MfgBatches("供应商批次号2");
//        mfgBatches.add(mfgBatches1);
//        mfgBatches.add(mfgBatches2);
//
//        AdmitMethod.admit("1000001",codeAndAmount,mfgBatches,1319);
//
//    }

    /**
     * 创建出厂的测试数据
     * materialCode
     * materialLotIdList
     * statusCode
     * 测试用例描述
     * @return
     */
    @DataProvider
    public Object[][] getDeliver(){

        String qcCode =  (Math.random() * 100000) + "";

        //创建入厂的：数量，二维码，单位 数据
        ArrayList<CodeAndAmount> codeAndAmount = new ArrayList<CodeAndAmount>();
        CodeAndAmount codeAndAmount01 = new CodeAndAmount(100.0,qcCode,"瓶");
        codeAndAmount.add(codeAndAmount01);

        //创建入厂的：数量，二维码，单位 数据
        ArrayList<CodeAndAmount> codeAndAmount1 = new ArrayList<CodeAndAmount>();
        CodeAndAmount codeAndAmountO1 = new CodeAndAmount(100.0,qcCode+"0","瓶");
        CodeAndAmount codeAndAmountO2 = new CodeAndAmount(100.0,qcCode+"1","瓶");
        codeAndAmount1.add(codeAndAmountO1);
        codeAndAmount1.add(codeAndAmountO2);

        //创建供应商数据
        ArrayList<MfgBatches> mfgBatches = new ArrayList<MfgBatches>();
        MfgBatches mfgBatches1 = new MfgBatches("供应商批次号1");
        MfgBatches mfgBatches2 = new MfgBatches("供应商批次号2");
        mfgBatches.add(mfgBatches1);
        mfgBatches.add(mfgBatches2);

        //创建入厂物料并获取返回的物料单元值
        //入厂单个二维码
        int materialLotId1 = AdmitMethod.admit("1000001",codeAndAmount, Environment.storageId).get(qcCode) ;
        //入厂多个二维码
        HashMap<String,Integer> materialLotId = AdmitMethod.admit("1000002",codeAndAmount1,Environment.storageId);
        int materialLotId2 = materialLotId.get(qcCode+"0");
        int materialLotId3 = materialLotId.get(qcCode+"1");


        //
        int[] materialLotIdList0 = new int[0];
        int[] materialLotIdList1 = {materialLotId1};
        int[] materialLotIdList2 = {materialLotId2,materialLotId3};

        return new Object[][]{

                {"1000001",materialLotIdList1,200,"创建只有一个二维码的出厂数据"},
                {"1000001",materialLotIdList2,200,"创建两种物料二维码的出厂数据"},
                {"1000001",materialLotIdList1,400,"创建空二维码的出厂数据"},
                {"1000001",materialLotIdList0,400,"创建没有二维码的出厂数据"},

        };
    }
}
