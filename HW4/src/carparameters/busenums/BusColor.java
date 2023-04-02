package carparameters.busenums;

import carparameters.Color;
import carparameters.TypeOfCar;

import java.util.ArrayList;

public enum BusColor implements Color {
    GREEN(TypeOfCar.BUS),
    YELLOW(TypeOfCar.BUS),
    WHITE(TypeOfCar.BUS),
    ;

    private TypeOfCar typeOfCar;

    BusColor(TypeOfCar typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public static ArrayList<BusColor> getListOfColors() {
        ArrayList<BusColor> colors = new ArrayList<>();
        for (BusColor color : BusColor.values()) {
            colors.add(color);
        }
        return colors;
    }

    @Override
    public TypeOfCar getTypeOfCar() {
        return typeOfCar;
    }
}
