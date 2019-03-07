package Params.materialLot;

import config.Environment;
import object.materialLot.CodesAndAmounts;
import object.materialLot.MfgBatches;
import object.materialLot.OriginPlace;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
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
        HashMap<String,String> originPlace = new HashMap<String, String>();
        originPlace.put("province","北京市");
        originPlace.put("city","东城区");

        //创建originPalce 为空的数据
        HashMap<String,String> originPlaceN = new HashMap<String, String>();
        originPlaceN.put("province","");
        originPlaceN.put("city","");


        return new Object[][]{
                {"",codesAndAmounts,mfgBatches, Environment.storageId,"2021-02-25T07:16:48.000Z","00000001",originPlace,"入厂备注信息",400,"创建没有入厂物料的数据"},
                {"1000002",codesAndAmounts,mfgBatches,Environment.storageId,"2021-02-25T07:16:48.000Z","00000001",originPlace,"入厂备注信息",200,"创建入厂数据"},
                {"1000002",codesAndAmounts,mfgBatches,Environment.storageId,"2021-02-25T07:16:48.000Z","00000001",originPlace,"入厂备注信息",400,"创建入厂二维码相同的数据"},

                {"1000002",codesAndAmountsM,mfgBatches,Environment.storageId,"","",originPlaceN,"",200,"创建入厂多个二维码的数据"},
                {"1000002",codesAndAmountsT,mfgBatches,Environment.storageId,"","",originPlaceN,"",200,"创建入厂物料使用转换单位的数据"},
                {"1000002",codesAndAmountsZ,mfgBatches,Environment.storageId,"","",originPlaceN,"",400,"创建入厂二维码数量为0的数据"},
                {"1000002",codesAndAmountsN,mfgBatches,Environment.storageId,"","",originPlaceN,"",400,"创建没有入厂二维码的数据"},
                {"1000002",codesAndAmounts,mfgBatches,null,"","",originPlaceN,"",400,"创建没有入厂仓位的数据"},


                {"1000002",codesAndAmountsO,mfgBatchesN,Environment.storageId,"","",originPlaceN,"",200,"创建没有非必填项，只有必填项的入厂数据"},




        };
    }

}
