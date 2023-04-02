package carparameters.passengercarenums;

import carparameters.Engine;
import java.util.ArrayList;

public enum PassengerCarEngine implements Engine {
    V1_4,
    V1_6,
    ;

    public static ArrayList<PassengerCarEngine> getListOfEngines() {
        ArrayList<PassengerCarEngine> engines = new ArrayList<>();
        for (PassengerCarEngine engine : PassengerCarEngine.values()) {
            engines.add(engine);
        }
        return engines;
    }
}
