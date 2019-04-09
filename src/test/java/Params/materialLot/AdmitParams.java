package Params.materialLot;

import config.Environment;
import object.materialLot.CodeAndAmount;
import object.materialLot.CodesAndAmounts;
import object.materialLot.MfgBatches;
import object.materialLot.OriginPlace;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class AdmitParams {

    /**
     * 创建入厂的测试数据
     * materialCode
     * codesAndAmounts
     * MfgBatches
     * storageId
     * validityPeriod
     * supplierCode：	00000001
     * originPlace
     * remark
     * statusCode
     * 测试用例描述
     * @return
     */
    @DataProvider
    public Object[][] getAdmit(){

        String qcCode = (int) (Math.random() * 100000) + "";

        //创建入厂的：数量，二维码，单位 数据
        ArrayList<CodeAndAmount> codesAndAmounts = new ArrayList<CodeAndAmount>();
        CodeAndAmount codeAndAmount = new CodeAndAmount(100.0,qcCode,"拖");
        codesAndAmounts.add(codeAndAmount);

        //创建入厂的：数量，二维码，单位 数据
        ArrayList<CodeAndAmount> codesAndAmountsO = new ArrayList<CodeAndAmount>();
        CodeAndAmount codesAndAmountsO1 = new CodeAndAmount(100.0,qcCode+"0","拖");
        codesAndAmountsO.add(codesAndAmountsO1);

        //创建入厂多个二维码数据
        ArrayList<CodeAndAmount> codesAndAmountsM = new ArrayList<CodeAndAmount>();
        CodeAndAmount codesAndAmountsM1 = new CodeAndAmount(100.0,qcCode+"1-0","拖");
        CodeAndAmount codesAndAmountsM2 = new CodeAndAmount(100.0,qcCode+"1-1","拖");
        CodeAndAmount codesAndAmountsM3 = new CodeAndAmount(100.0,qcCode+"1-2","拖");
        codesAndAmountsM.add(codesAndAmountsM1);
        codesAndAmountsM.add(codesAndAmountsM2);
        codesAndAmountsM.add(codesAndAmountsM3);

        //创建数量为0的二维码数据
        ArrayList<CodeAndAmount> codesAndAmountsZ = new ArrayList<CodeAndAmount>();
        CodeAndAmount codesAndAmountsZ1 = new CodeAndAmount(0.0,qcCode+"2","拖");
        codesAndAmountsZ.add(codesAndAmountsZ1);

        //创建使用转换单位的二维码数据
        ArrayList<CodeAndAmount> codesAndAmountsT = new ArrayList<CodeAndAmount>();
        CodeAndAmount codesAndAmountsT1 = new CodeAndAmount(100.0,qcCode+"3","瓶");
        codesAndAmountsT.add(codesAndAmountsT1);

        //创建没有入厂二维码的数据
        ArrayList<CodeAndAmount> codesAndAmountsN = new ArrayList<CodeAndAmount>();
        CodeAndAmount codesAndAmountsN1 = new CodeAndAmount(0.0,"","");
        codesAndAmountsN.add(codesAndAmountsN1);


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
                {"",codesAndAmounts,mfgBatches, Environment.storageId,new Date(),"00000001",originPlace,"入厂备注信息",400,"创建没有入厂物料的数据"},
                {"1000002",codesAndAmounts,mfgBatches,Environment.storageId,new Date(),"00000001",originPlace,"入厂备注信息",200,"创建入厂数据"},
                {"1000002",codesAndAmounts,mfgBatches,Environment.storageId,new Date(),"00000001",originPlace,"入厂备注信息",400,"创建入厂二维码相同的数据"},

                {"1000002",codesAndAmountsM,mfgBatches,Environment.storageId,new Date(),"00000001",originPlace,"入厂备注信息",200,"创建入厂多个二维码的数据"},
                {"1000002",codesAndAmountsT,mfgBatches,Environment.storageId,new Date(),"00000001",originPlace,"入厂备注信息",200,"创建入厂物料使用转换单位的数据"},
                {"1000002",codesAndAmountsZ,mfgBatches,Environment.storageId,new Date(),"00000001",originPlace,"入厂备注信息",400,"创建入厂二维码数量为0的数据"},
                {"1000002",codesAndAmountsN,mfgBatches,Environment.storageId,new Date(),"00000001",originPlace,"入厂备注信息",400,"创建没有入厂二维码的数据"},
                {"1000002",codesAndAmounts,mfgBatches,null,new Date(),"00000001",originPlace,"入厂备注信息",400,"创建没有入厂仓位的数据"},


//                {"1000002",codesAndAmountsO,mfgBatchesN,Environment.storageId,"","",originPlaceN,"",200,"创建没有非必填项，只有必填项的入厂数据"},




        };
    }

}
