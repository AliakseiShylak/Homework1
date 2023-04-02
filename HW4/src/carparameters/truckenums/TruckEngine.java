package carparameters.truckenums;

import carparameters.Engine;
import java.util.ArrayList;

public enum TruckEngine implements Engine {
    V6_0,
    V6_5,
    ;

    public static ArrayList<TruckEngine> getListOfEngines() {
        ArrayList<TruckEngine> engines = new ArrayList<>();
        for (TruckEngine engine : TruckEngine.values()) {
            engines.add(engine);
        }
        return engines;
    }
}
