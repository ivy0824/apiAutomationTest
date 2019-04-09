package object.def;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

//忽略序列化问题
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RawMaterial {
    private String amount;
    private String lossRate;
    private String currentUnitId;
    private String materialCode;
    private boolean regulatoryControl;


    public RawMaterial(String amount, String lossRate, String currentUnitId, String materialCode, boolean regulatoryControl) {
        this.amount = amount;
        this.lossRate = lossRate;
        this.currentUnitId = currentUnitId;
        this.materialCode = materialCode;
        this.regulatoryControl = regulatoryControl;
    }

    public String toString() {
        return "RawMaterial{" +
                "amount='" + amount + '\'' +
                ", lossRate='" + lossRate + '\'' +
                ",currentUnitId;" + currentUnitId + '\''+
                ", materialCode='" + materialCode + '\'' +
                ", regulatoryControl=" + regulatoryControl +
                '}';
    }

}
