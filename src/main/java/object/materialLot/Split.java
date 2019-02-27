package object.materialLot;

import java.util.ArrayList;

public class Split {

    private int sourceMaterialLotId;
    private ArrayList<Targets> targets;

    public Split(int sourceMaterialLotId,ArrayList<Targets> targets) {
        this.sourceMaterialLotId = sourceMaterialLotId;
        this.targets = targets;
    }

    public String toString() {
        return "split{" +
                "sourceMaterialLotId='" + sourceMaterialLotId + '\'' +
                ",targets='" + targets + '\'' +
                '}';
    }
}
