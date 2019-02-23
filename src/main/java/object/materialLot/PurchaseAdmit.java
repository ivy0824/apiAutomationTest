package object.materialLot;

import java.util.ArrayList;

public class PurchaseAdmit {

    private int procureOrderId;
    private int procureOrderDetailId;
    private ArrayList<CodesAndAmounts> codesAndAmounts;
    private String supplierCode;
    private String materialCode;
    private Object storageId;


    public PurchaseAdmit(int procureOrderId,int procureOrderDetailId, ArrayList<CodesAndAmounts> codesAndAmounts,String supplierCode,String materialCode, Object storageId ) {
        this.procureOrderId = procureOrderId;
        this.procureOrderDetailId = procureOrderDetailId;
        this.codesAndAmounts = codesAndAmounts;
        this.supplierCode = supplierCode;
        this.materialCode = materialCode;
        this.storageId = storageId;
    }

    public String toString() {
        return "Admit{" +
                "procureOrderId='" + procureOrderId + '\''+
                ",procureOrderDetailId='" + procureOrderDetailId + '\''+
                ",codesAndAmounts='" + codesAndAmounts + '\'' +
                ",supplierCode;" + supplierCode + '\''+
                ",materialCode='" + materialCode + '\'' +
                ",storageId=" + storageId +
                '}';
    }
}
