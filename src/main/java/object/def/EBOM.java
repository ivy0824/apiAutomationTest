package object.def;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.ArrayList;

//忽略序列化问题
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class EBOM {
    private String productMaterialCode;
    private String productMaterialName;
    private int currentUnitId;
    private int status;
    private String version;
    private ArrayList<RawMaterial> rawMaterialList;

    public EBOM(String productMaterialCode, String productMaterialName, int currentUnitId, int status, String version, ArrayList<RawMaterial> rawMaterialList) {
        this.productMaterialCode = productMaterialCode;
        this.productMaterialName = productMaterialName;
        this.currentUnitId = currentUnitId;
        this.status = status;
        this.version = version;
        this.rawMaterialList = rawMaterialList;

    }

    public String toString() {
        return "EBOM{" +
                "productMaterialCode='" + productMaterialCode + '\'' +
                ", productMaterialName='" + productMaterialName + '\'' +
                ",currentUnitId;" + currentUnitId + '\''+
                ", status=" + status +
                ", version='" + version + '\'' +
                ", rawMaterialList=" + rawMaterialList +
                '}';
    }


}



