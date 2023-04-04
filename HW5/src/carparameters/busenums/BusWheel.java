package carparameters.busenums;

import carparameters.TypeOfCar;
import carparameters.Wheel;

import java.util.ArrayList;

public enum BusWheel implements Wheel {
    R20(TypeOfCar.BUS),
    R22(TypeOfCar.BUS),
    ;

    private TypeOfCar typeOfCar;

    BusWheel(TypeOfCar typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public static ArrayList<BusWheel> getListOfWheels() {
        ArrayList<BusWheel> wheels = new ArrayList<>();
        for (BusWheel wheel : BusWheel.values()) {
            wheels.add(wheel);
        }
        return wheels;
    }

    @Override
    public TypeOfCar getTypeOfCar() {
        return typeOfCar;
    }
}
