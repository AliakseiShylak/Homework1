package carparameters.passengercarenums;

import carparameters.Model;
import java.util.ArrayList;

public enum PassengerCarModel implements Model {
    KIA_CEED,
    KIA_RIO,
    KIA_CERATO,
    ;

    public static ArrayList<PassengerCarModel> getListOfModels() {
        ArrayList<PassengerCarModel> models = new ArrayList<>();
        for (PassengerCarModel model : PassengerCarModel.values()) {
            models.add(model);
        }
        return models;
    }
}
