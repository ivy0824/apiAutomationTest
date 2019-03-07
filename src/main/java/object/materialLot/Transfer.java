package object.materialLot;

import java.util.ArrayList;

public class Transfer {

    private int inStorageId;
    private int materialLotIdList[];
    private int materialLotContainerIdList[];

    public Transfer(int inStorageId, int materialLotIdList[], int materialLotContainerIdList[]) {
        this.inStorageId = inStorageId;
        this.materialLotIdList = materialLotIdList;
        this.materialLotContainerIdList = materialLotContainerIdList;
    }

    public String toString() {
        return "split{" +
                "inStorageId='" + inStorageId + '\'' +
                ",materialLotIdList='" + materialLotIdList + '\'' +
                ",materialLotContainerIdList='" + materialLotContainerIdList + '\'' +
                '}';
    }
}
