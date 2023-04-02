package carparameters.passengercarenums;

import carparameters.Color;
import carparameters.TypeOfCar;
import java.util.ArrayList;

public enum PassengerCarColor implements Color {
    GREEN(TypeOfCar.PASSENGER_CAR),
    YELLOW(TypeOfCar.PASSENGER_CAR),
    WHITE(TypeOfCar.PASSENGER_CAR),
    RED(TypeOfCar.PASSENGER_CAR),
    ORANGE(TypeOfCar.PASSENGER_CAR),
    BLACK(TypeOfCar.PASSENGER_CAR),
    BLUE(TypeOfCar.PASSENGER_CAR),
    ;

    private TypeOfCar typeOfCar;

    PassengerCarColor(TypeOfCar typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public static ArrayList<PassengerCarColor> getListOfColors() {
        ArrayList<PassengerCarColor> colors = new ArrayList<>();
        for (PassengerCarColor color : PassengerCarColor.values()) {
            colors.add(color);
        }
        return colors;
    }

    @Override
    public TypeOfCar getTypeOfCar() {
        return typeOfCar;
    }
}
