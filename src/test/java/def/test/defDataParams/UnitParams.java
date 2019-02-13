package def.test.defDataParams;

import org.testng.annotations.DataProvider;

public class UnitParams {

    /**
     * 创建单位的测试数据
     * name
     * desc
     * statusCode
     * 测试用例描述
     * @return
     */
    @DataProvider
    public Object[][] getUnit(){
        String name = (int)(Math.random()*10000) + "";
        return new Object[][]{
                {"unit"+name,"",200,"创建有名称没有描述的单位"},
                {"","test0001",400,"创建无名称有描述的单位"},
                {"unit"+name,"test0002",200,"创建有名称有描述的单位"},
                {"unit"+name,"test00023",400,"创建名称重复的单位"}

        };
    }


}
