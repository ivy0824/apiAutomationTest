package Params.materialLot;


import config.Environment;
import object.materialLot.CodesAndAmounts;
import org.testng.annotations.DataProvider;
import utils.materialLot.AdmitMethod;
import java.util.ArrayList;
import java.util.HashMap;

public class TransferParams {

    /**
     * 创建物料转移的测试数据
     * inStorageId
     * materialLotIdList
     * materialLotContainerIdList
     * statusCode
     * 测试用例描述
     * @return
     */
    @DataProvider
    public Object[][] getTransfer(){

        String qcCode = (int) (Math.random() * 100000) + "";

        //创建入厂二维码数据
        ArrayList<CodesAndAmounts> codesAndAmounts = new ArrayList<CodesAndAmounts>();
        CodesAndAmounts codesAndAmounts1 = new CodesAndAmounts("100",qcCode+"1","拖");
        CodesAndAmounts codesAndAmounts2 = new CodesAndAmounts("100",qcCode+"2","拖");

        codesAndAmounts.add(codesAndAmounts1);
        codesAndAmounts.add(codesAndAmounts2);

        //创建入厂物料并获取返回的物料单元值
        HashMap<String,Integer> materialLotId = AdmitMethod.admit("1000002",codesAndAmounts, Environment.storageId);
        int materialLotId1 = materialLotId.get(qcCode+"1");
        int materialLotId2 = materialLotId.get(qcCode+"2");

        int[] materialLotIdList = {materialLotId1};


        int[] materialLotContainerIdList = {};


        return new Object[][]{
                {Environment.inStorageId,materialLotIdList,materialLotContainerIdList,"成功","物料转移"},
                {Environment.inStorageId,materialLotIdList,materialLotContainerIdList,"已经在要转运的目的仓库中","物料二维码位置与转移位置相同"},
                {Environment.inStorageId,materialLotIdList,materialLotContainerIdList,"已经在要转运的目的仓库中","物料二维码位置与转移位置相同"},

        };
    }
}
