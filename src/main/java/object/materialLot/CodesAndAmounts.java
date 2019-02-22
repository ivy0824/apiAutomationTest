package object.materialLot;

public class InventoryList {
    private String amount;
    private String materialCode;
    private String qcStatus;



    public codesAndAmounts(String amount, String materialCode, String qcStatus) {
        this.amount = amount;
        this.materialCode = materialCode;
        this.qcStatus = qcStatus;

    }

    public String toString() {
        return "RawMaterial{" +
                "amount='" + amount + '\'' +
                ", lossRate='" + materialCode + '\'' +
                ",currentUnitId;" + qcStatus + '\''+

                '}';
    }
}
