package Params.materialLot;

import config.Environment;
import object.materialLot.CodesAndAmounts;
import object.materialLot.MfgBatches;
import org.testng.annotations.DataProvider;
import utils.materialLot.AdmitMethod;

import java.util.ArrayList;
import java.util.HashMap;

public class AdjustParams {

    /**
     * 创建二维码调整的测试数据
     * materialLotId
     * transactionCode
     * amountBefore
     * amountDiff
     * mfgBatches
     * projectCode
     * supplierCode
     * remark
     * statusCode
     * 测试用例描述
     * @return
     */
    @DataProvider
    public Object[][] getAdjust() {

        String qcCode = (Math.random() * 100000) + "";

        //创建入厂的：数量，二维码，单位 数据
        ArrayList<CodesAndAmounts> codesAndAmounts = new ArrayList<CodesAndAmounts>();
        CodesAndAmounts codesAndAmounts01 = new CodesAndAmounts("100", qcCode, "瓶");
        codesAndAmounts.add(codesAndAmounts01);

        //创建供应商数据
        ArrayList<MfgBatches> mfgBatches = new ArrayList<MfgBatches>();
        MfgBatches mfgBatches1 = new MfgBatches("供应商批次号1");
        MfgBatches mfgBatches2 = new MfgBatches("供应商批次号2");
        mfgBatches.add(mfgBatches1);
        mfgBatches.add(mfgBatches2);

        //创建入厂物料并获取返回的物料单元值
        int materialLotId = AdmitMethod.admit("1000001", codesAndAmounts, Environment.storageId).get(qcCode);
        System.out.println(materialLotId);

        return new Object[][]{

                {materialLotId,"adjust1",100,-10,"成功","物料调整数量减少"},
                {materialLotId,"adjust1",90,+10,"成功","物料调整数量增加"},
                {materialLotId,"adjust1",100,-200,"物料数量不能为负","物料调整数量为负数"},
                {materialLotId,"adjust1",100,-100,"成功","物料调整数量为0"},

        };
    }

}
