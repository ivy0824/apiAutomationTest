package object.materialLot;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/*
 * materialCode
 * codeAndAmount
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
    private ArrayList<CodeAndAmount> codeAndAmount;
    private ArrayList<MfgBatches> mfgBatches;
    private Object storageId;
    private Date validityPeriod;
    private String supplierCode;
    private OriginPlace originPlace;
    private String remark;


    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public ArrayList<CodeAndAmount> getcodeAndAmount() {
        return codeAndAmount;
    }

    public void setcodeAndAmount(ArrayList<CodeAndAmount> codeAndAmount) {
        this.codeAndAmount = codeAndAmount;
    }

    public ArrayList<MfgBatches> getMfgBatches() {
        return mfgBatches;
    }

    public void setMfgBatches(ArrayList<MfgBatches> mfgBatches) {
        this.mfgBatches = mfgBatches;
    }

    public Object getStorageId() {
        return storageId;
    }

    public void setStorageId(Object storageId) {
        this.storageId = storageId;
    }

    public Date getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(Date validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public OriginPlace getOriginPlace() {
        return originPlace;
    }

    public void setOriginPlace(OriginPlace originPlace) {
        this.originPlace = originPlace;
    }

    public void admitAll(String materialCode, ArrayList<CodeAndAmount> codeAndAmount, ArrayList<MfgBatches> MfgBatches, Object storageId, Date validityPeriod, String supplierCode, OriginPlace originPlace, String remark ) {
        this.materialCode = materialCode;
        this.codeAndAmount = codeAndAmount;
        this.mfgBatches = MfgBatches;
        this.storageId = storageId;
        this.validityPeriod = validityPeriod;
        this.supplierCode = supplierCode;
        this.originPlace = originPlace;
        this.remark = remark;
    }

    public void admitNeed(String materialCode, ArrayList<CodeAndAmount> codeAndAmount, Object storageId ) {
        this.materialCode = materialCode;
        this.codeAndAmount = codeAndAmount;
        this.storageId = storageId;

    }


    public String toString() {
        return "Admit{" +
                "materialCode='" + materialCode + '\'' +
                ",codeAndAmount='" + codeAndAmount + '\'' +
                ",MfgBatches;" + mfgBatches + '\''+
                ", storageId=" + storageId + '\'' +
                ", validityPeriod=" + validityPeriod + '\'' +
                ", supplierCode=" + supplierCode + '\'' +
                ", originPlace=" + originPlace + '\'' +
                ", remark=" + remark + '\'' +
                '}';
    }
}
