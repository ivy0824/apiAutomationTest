package object.materialLot;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * materialCode
 * codesAndAmounts
 * MfgBatches
 * storageId
 * validityPeriod
 * supplierCode：	00000001
 * originPlace
 * remark
 */

public class Admit {

    private String materialCode;
    private ArrayList<CodesAndAmounts> codesAndAmounts;
    private ArrayList<MfgBatches> MfgBatches;
    private Object storageId;
    private String validityPeriod;
    private String supplierCode;
    private HashMap originPlace;
    private String remark;


    public void AdmitAll(String materialCode, ArrayList<CodesAndAmounts> codesAndAmounts,ArrayList<MfgBatches> MfgBatches, Object storageId,String validityPeriod,String supplierCode,HashMap originPlace,String remark ) {
        this.materialCode = materialCode;
        this.codesAndAmounts = codesAndAmounts;
        this.MfgBatches = MfgBatches;
        this.storageId = storageId;
        this.validityPeriod = validityPeriod;
        this.supplierCode = supplierCode;
        this.originPlace = originPlace;
        this.remark = remark;
    }

    public void AdmitNeed(String materialCode, ArrayList<CodesAndAmounts> codesAndAmounts, Object storageId ) {
        this.materialCode = materialCode;
        this.codesAndAmounts = codesAndAmounts;
        this.storageId = storageId;

    }


    public String toString() {
        return "Admit{" +
                "materialCode='" + materialCode + '\'' +
                ",codesAndAmounts='" + codesAndAmounts + '\'' +
                ",MfgBatches;" + MfgBatches + '\''+
                ", storageId=" + storageId + '\'' +
                ", validityPeriod=" + validityPeriod + '\'' +
                ", supplierCode=" + supplierCode + '\'' +
                ", originPlace=" + originPlace + '\'' +
                ", remark=" + remark + '\'' +
                '}';
    }
}
