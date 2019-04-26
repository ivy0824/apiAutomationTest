package preCondition;

import blacklake.def.*;
import blacklake.lakers.Org;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.testng.annotations.Test;

public class CreateData {

    @Test
    void createData(){
//        Org.createOrg("42501","42501");
//        Org.createAdmin(Org.orgId);
//        Unit.createUnit("kg4","kg");
//        EBOM.createEbom();

        //创建工位
        int workshopId = Workshop.createWorkshop("042503","042503").extract().path("data.id");
//        Workshop.updateWorkshopStatus(workshopId);
//        int prodLineId = ProdLine.createProdLine("042502-2","042502-2",workshopId).extract().path("data.id");
//        ProdLine.updateProdLineStatus(prodLineId);
//        int workstationId = Workstation.createWorkstation("042502-2-1","042502-2-1",prodLineId).extract().path("data.id");
//        Workstation.updateWorkstationStatus(workstationId);

    }

}
