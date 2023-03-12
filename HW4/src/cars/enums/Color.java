package cars.enums;

import java.util.ArrayList;

public enum Color {
    GREEN(TypeOfCar.BUS),
    YELLOW(TypeOfCar.BUS),
    WHITE(TypeOfCar.BUS),
    VIOLET(TypeOfCar.TRUCK),
    RED(TypeOfCar.TRUCK),
    GRAY(TypeOfCar.TRUCK),
    ORANGE(TypeOfCar.PASSENGER_CAR),
    BLACK(TypeOfCar.PASSENGER_CAR),
    BLUE(TypeOfCar.PASSENGER_CAR),
    ;

    private TypeOfCar typeOfCar;

    Color(TypeOfCar typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public boolean isColorForThisCar(TypeOfCar car) {
        return this.typeOfCar.equals(car);
    }

    public TypeOfCar getTypeOfCar() {
        return typeOfCar;
    }
}