package Params.materialLot;

import config.Environment;
import object.materialLot.CodesAndAmounts;
import object.materialLot.MfgBatches;
import object.materialLot.Targets;
import org.testng.annotations.DataProvider;
import utils.materialLot.AdmitMethod;

import java.util.ArrayList;
import java.util.HashMap;

public class SplitParams {

    /**
     * 创建二维码拆分的测试数据
     * sourceMaterialLotId
     * targets
     * validationPeriod
     * statusCode
     * 测试用例描述
     * @return
     */
    @DataProvider
    public Object[][] getSplit(){

        String qcCode = (int) (Math.random() * 100000) + "";


        //创建入厂二维码数据
        ArrayList<CodesAndAmounts> codesAndAmounts = new ArrayList<CodesAndAmounts>();
        CodesAndAmounts codesAndAmounts1 = new CodesAndAmounts("100",qcCode+"1","拖");
        CodesAndAmounts codesAndAmounts2 = new CodesAndAmounts("100",qcCode+"2","拖");

        codesAndAmounts.add(codesAndAmounts1);
        codesAndAmounts.add(codesAndAmounts2);

        //创建入厂物料并获取返回的物料单元值
        HashMap<String,Integer> materialLotId = AdmitMethod.admit("1000002",codesAndAmounts, Environment.storageId);
        int sourceMaterialLotId1 = materialLotId.get(qcCode+"1");
        int sourceMaterialLotId2 = materialLotId.get(qcCode+"2");

        //准备拆分的空二维码数据，拆分数量=原二维码数量
        ArrayList<Targets> targets0 = new ArrayList();
        Targets targets01 = new Targets(qcCode+"10",100);
        targets0.add(targets01);

        //准备拆分的多个空二维码数据，拆分数量小于原二维码数量
        ArrayList<Targets> targets1 = new ArrayList();
        Targets targets11 = new Targets(qcCode+"11",1);
        Targets targets12 = new Targets(qcCode+"12",1);
        targets1.add(targets11);
        targets1.add(targets12);

        //准备拆分的空二维码数据且拆入数量也为0
        ArrayList<Targets> targets2 = new ArrayList();
        Targets targets21 = new Targets(qcCode+"10",0);
        targets2.add(targets21);


        //准备拆分的非空二维码数据
        ArrayList<Targets> targetsN = new ArrayList();
        Targets targetsN1 = new Targets(qcCode+"2",1);
        targetsN.add(targetsN1);


        return new Object[][]{
                {sourceMaterialLotId1,targetsN,"该二维码是物料二维码, 请扫描空码进行拆分","拆分到非空二维码中"},
                {sourceMaterialLotId1,targets0,"成功","拆分到原二维码数量等于0的二维码中"},
                {sourceMaterialLotId1,targets2,"物料拆分后的新物料数量必须大于零","拆分的新二维码数量大于0"},
                {sourceMaterialLotId2,targets1,"成功","拆分到原二维码数量大余0的多个二维码中"},


        };
    }
}
