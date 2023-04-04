package carparameters.passengercarenums;

import carparameters.TypeOfCar;
import carparameters.Wheel;

import java.util.ArrayList;

public enum PassengerCarWheel implements Wheel {
    R13(TypeOfCar.PASSENGER_CAR),
    R14(TypeOfCar.PASSENGER_CAR),
    ;

    private TypeOfCar typeOfCar;

    PassengerCarWheel(TypeOfCar typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public static ArrayList<PassengerCarWheel> getListOfWheels() {
        ArrayList<PassengerCarWheel> wheels = new ArrayList<>();
        for (PassengerCarWheel wheel : PassengerCarWheel.values()) {
            wheels.add(wheel);
        }
        return wheels;
    }

    @Override
    public TypeOfCar getTypeOfCar() {
        return typeOfCar;
    }
}
