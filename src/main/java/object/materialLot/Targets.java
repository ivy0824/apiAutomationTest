package object.materialLot;

public class Targets {

    private String code;
    private Object amount;

    public Targets(String code,Object amount) {
        this.code = code;
        this.amount = amount;
    }

    public String toString() {
        return "targets{" +
                "code='" + code + '\'' +
                ",amount='" + amount + '\'' +
                '}';
    }

}
