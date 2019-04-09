package object.materialLot;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.ArrayList;
import java.util.Date;
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
//忽略序列化问题
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class Admit {

    private String materialCode;
    private ArrayList<CodeAndAmount> codesAndAmounts;
    private ArrayList<MfgBatches> mfgBatches;
    private Object storageId;
    private Date validityPeriod;
    private String supplierCode;
    private OriginPlace originPlace;
    private String remark;


    public void admitAll(String materialCode, ArrayList<CodeAndAmount> codesAndAmounts,ArrayList<MfgBatches> MfgBatches, Object storageId,Date validityPeriod,String supplierCode,OriginPlace originPlace,String remark ) {
        this.materialCode = materialCode;
        this.codesAndAmounts = codesAndAmounts;
        this.mfgBatches = MfgBatches;
        this.storageId = storageId;
        this.validityPeriod = validityPeriod;
        this.supplierCode = supplierCode;
        this.originPlace = originPlace;
        this.remark = remark;
    }

    public void admitNeed(String materialCode, ArrayList<CodeAndAmount> codesAndAmounts, Object storageId ) {
        this.materialCode = materialCode;
        this.codesAndAmounts = codesAndAmounts;
        this.storageId = storageId;

    }


    public String toString() {
        return "Admit{" +
                "materialCode='" + materialCode + '\'' +
                ",codesAndAmounts='" + codesAndAmounts + '\'' +
                ",MfgBatches;" + mfgBatches + '\''+
                ", storageId=" + storageId + '\'' +
                ", validityPeriod=" + validityPeriod + '\'' +
                ", supplierCode=" + supplierCode + '\'' +
                ", originPlace=" + originPlace + '\'' +
                ", remark=" + remark + '\'' +
                '}';
    }
}
