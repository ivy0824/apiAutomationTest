package blacklake.lakers;

import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import utils.common.RequestObject;

import static blacklake.lakers.Org.orgId;

public class OrgTest {


    @Test
    void testOrg(){
        ValidatableResponse response = Org.createOrg("042372","042372");
        RequestObject.getStatus(response,200);


    }

    @Test
    void testCreateAdmin(){
        Org.createAdmin(137);
    }

}