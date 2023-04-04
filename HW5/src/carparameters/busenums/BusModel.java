package carparameters.busenums;

import carparameters.Model;
import java.util.ArrayList;

public enum BusModel implements Model {
    NEOPLAN_STARLINER,
    NEOPLAN_EUROLINER,
    ;

    public static ArrayList<BusModel> getListOfModels() {
        ArrayList<BusModel> models = new ArrayList<>();
        for (BusModel model : BusModel.values()) {
            models.add(model);
        }
        return models;
    }
}
