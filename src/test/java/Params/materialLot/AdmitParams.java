package Params.materialLot;

import config.Environment;
import object.materialLot.CodeAndAmount;
import object.materialLot.MfgBatches;
import object.materialLot.OriginPlace;
import org.testng.annotations.DataProvider;
import java.util.ArrayList;
import java.util.Date;

public class AdmitParams {

    /**
     * 创建入厂的测试数据
     * materialCode
     * codeAndAmount
     * MfgBatches
     * storageId
     * validityPeriod
     * supplierCode：	00000001originPlace
     *
     * remark
     * statusCode
     * 测试用例描述
     * @return
     */
    @DataProvider
    public Object[][] getAdmit(){

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
        CodeAndAmount codeAndAmountN1 = new CodeAndAmount(0.0,"","");
        codeAndAmountN.add(codeAndAmountN1);


        //创建供应商数据
        ArrayList<MfgBatches> mfgBatches = new ArrayList<MfgBatches>();
        MfgBatches mfgBatches1 = new MfgBatches("供应商批次号1");
        MfgBatches mfgBatches2 = new MfgBatches("供应商批次号2");
        mfgBatches.add(mfgBatches1);
        mfgBatches.add(mfgBatches2);

        //创建没有供应商的数据
        ArrayList<MfgBatches> mfgBatchesN = new ArrayList<MfgBatches>();
        MfgBatches mfgBatchesN1 = new MfgBatches("供应商批次号1");
        MfgBatches mfgBatchesN2 = new MfgBatches("供应商批次号2");
        mfgBatchesN.add(mfgBatchesN1);
        mfgBatchesN.add(mfgBatchesN2);

        //创建originPalce 的数据
        OriginPlace originPlace = new OriginPlace("北京市", "东城区");
        OriginPlace originPlaceN = new OriginPlace();


        return new Object[][]{
                {"",codeAndAmount,mfgBatches, Environment.storageId,new Date(),"00000001",originPlace,"入厂备注信息",400,"创建没有入厂物料的数据"},
                {"1000002",codeAndAmount,mfgBatches,Environment.storageId,new Date(),"00000001",originPlace,"入厂备注信息",200,"创建入厂数据"},
                {"1000002",codeAndAmount,mfgBatches,Environment.storageId,new Date(),"00000001",originPlace,"入厂备注信息",400,"创建入厂二维码相同的数据"},

                {"1000002",codeAndAmountM,mfgBatches,Environment.storageId,new Date(),"00000001",originPlace,"入厂备注信息",200,"创建入厂多个二维码的数据"},
                {"1000002",codeAndAmountT,mfgBatches,Environment.storageId,new Date(),"00000001",originPlace,"入厂备注信息",200,"创建入厂物料使用转换单位的数据"},
                {"1000002",codeAndAmountZ,mfgBatches,Environment.storageId,new Date(),"00000001",originPlace,"入厂备注信息",400,"创建入厂二维码数量为0的数据"},
                {"1000002",codeAndAmountN,mfgBatches,Environment.storageId,new Date(),"00000001",originPlace,"入厂备注信息",400,"创建没有入厂二维码的数据"},
                {"1000002",codeAndAmount,mfgBatches,null,new Date(),"00000001",originPlace,"入厂备注信息",400,"创建没有入厂仓位的数据"},


//                {"1000002",codeAndAmountO,mfgBatchesN,Environment.storageId,"","",originPlaceN,"",200,"创建没有非必填项，只有必填项的入厂数据"},




        };
    }

}
