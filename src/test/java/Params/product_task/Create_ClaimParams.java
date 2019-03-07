package Params.product_task;

import org.testng.annotations.DataProvider;

public class Create_ClaimParams {

    /**
     * 创建领取并创建生产任务的测试数据
     * projectCode
     * processSeq
     * amountProductPlanned
     * statusCode
     * 测试用例描述
     * @return
     */
    @DataProvider
    public Object[][] getCreateClaim(){
        String name = (int)(Math.random()*10000) + "";
        return new Object[][]{
                {"14679023","01",56,100,200,""},


        };
    }
}
