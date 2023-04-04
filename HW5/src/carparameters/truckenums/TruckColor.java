package carparameters.truckenums;

import carparameters.Color;
import carparameters.TypeOfCar;
import java.util.ArrayList;

public enum TruckColor implements Color {
    GREEN(TypeOfCar.TRUCK),
    WHITE(TypeOfCar.TRUCK),
    RED(TypeOfCar.TRUCK),
    BLUE(TypeOfCar.TRUCK),
    ;

    private TypeOfCar typeOfCar;

    TruckColor(TypeOfCar typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public static ArrayList<TruckColor> getListOfColors() {
        ArrayList<TruckColor> colors = new ArrayList<>();
        for (TruckColor color : TruckColor.values()) {
            colors.add(color);
        }
        return colors;
    }

    @Override
    public TypeOfCar getTypeOfCar() {
        return typeOfCar;
    }
}
