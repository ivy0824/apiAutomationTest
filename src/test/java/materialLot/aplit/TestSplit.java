package materialLot.aplit;

import Params.materialLot.SplitParams;
import config.Environment;
import object.materialLot.Split;
import object.materialLot.Targets;
import org.testng.annotations.Test;
import utils.common.RequestObject;
import java.util.ArrayList;
import java.util.HashMap;

public class TestSplit {

    @Test(dataProvider= "getSplit",dataProviderClass = SplitParams.class)
    private void testSplitPost(int sourceMaterialLotId, ArrayList<Targets> targets,String result, String msg){

        System.out.println("----------" + msg + "----------");

        Split split = new Split(sourceMaterialLotId,targets);
        System.out.println(split.toString());
        HashMap<String,String> params=new HashMap<String, String>();
        RequestObject.getResponseMessage(RequestObject.testPost(Environment.server_manufacture,"/v1/materialLot/_split",split,params),"message",result);

    }
}
