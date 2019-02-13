package def.test.defObject;

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
