package carparameters.truckenums;

import carparameters.TypeOfCar;
import carparameters.Wheel;

import java.util.ArrayList;

public enum TruckWheel implements Wheel {
    R23(TypeOfCar.TRUCK),
    R25(TypeOfCar.TRUCK),
    ;

    private TypeOfCar typeOfCar;

    TruckWheel(TypeOfCar typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public static ArrayList<TruckWheel> getListOfWheels() {
        ArrayList<TruckWheel> wheels = new ArrayList<>();
        for (TruckWheel wheel : TruckWheel.values()) {
            wheels.add(wheel);
        }
        return wheels;
    }

    @Override
    public TypeOfCar getTypeOfCar() {
        return typeOfCar;
    }
}
