package preCondition;

import blacklake.def.EBOM;
import blacklake.def.Material;
import blacklake.def.Unit;
import blacklake.lakers.Org;
import org.testng.annotations.Test;

import static blacklake.lakers.Org.orgId;

public class CreateData {

    @Test
    void createData(){

        Unit.createUnit("kg4","kg");
        EBOM.createEbom();
    }

}
