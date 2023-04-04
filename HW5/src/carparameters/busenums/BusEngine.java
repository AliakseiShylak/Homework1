package carparameters.busenums;

import carparameters.Engine;
import java.util.ArrayList;

public enum BusEngine implements Engine {
    V5_0,
    V6_0,
    ;

    public static ArrayList<BusEngine> getListOfEngines() {
        ArrayList<BusEngine> engines = new ArrayList<>();
        for (BusEngine engine : BusEngine.values()) {
            engines.add(engine);
        }
        return engines;
    }
}
