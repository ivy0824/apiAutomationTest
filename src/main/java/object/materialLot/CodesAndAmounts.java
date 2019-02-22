package object.materialLot;

public class CodesAndAmounts {
    private String amount;
    private String code;
    private String unit;

    public CodesAndAmounts(String amount, String code, String unit) {
        this.amount = amount;
        this.code = code;
        this.unit = unit;
    }

    public String toString() {
        return "CodesAndAmounts{" +
                "amount='" + amount + '\'' +
                ",code='" + code + '\'' +
                ",unit;" + unit + '\'' +
                '}';
    }
}


