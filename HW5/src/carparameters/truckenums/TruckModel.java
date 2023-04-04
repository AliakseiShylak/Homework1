package carparameters.truckenums;

import carparameters.Model;
import java.util.ArrayList;

public enum TruckModel implements Model {
    SCANIA_L320,
    SCANIA_S730,
    ;

    public static ArrayList<TruckModel> getListOfModels() {
        ArrayList<TruckModel> models = new ArrayList<>();
        for (TruckModel model : TruckModel.values()) {
            models.add(model);
        }
        return models;
    }
}
