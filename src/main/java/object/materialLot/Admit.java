package object.materialLot;

import java.util.ArrayList;

public class Admit {
    private String materialCode;
    private ArrayList<CodesAndAmounts> codesAndAmounts;
    private ArrayList<MfgBatches> MfgBatches;
    private int storageId;


    public Admit(String materialCode, ArrayList<CodesAndAmounts> codesAndAmounts,ArrayList<MfgBatches> MfgBatches, int storageId ) {
        this.materialCode = materialCode;
        this.codesAndAmounts = codesAndAmounts;
        this.MfgBatches = MfgBatches;
        this.storageId = storageId;
    }

    public String toString() {
        return "Admit{" +
                "materialCode='" + materialCode + '\'' +
                ",codesAndAmounts='" + codesAndAmounts + '\'' +
                ",MfgBatches;" + MfgBatches + '\''+
                ", storageId=" + storageId +
                '}';
    }
}
