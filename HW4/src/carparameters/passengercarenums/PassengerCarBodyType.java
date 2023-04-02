package carparameters.passengercarenums;

import carparameters.TypeOfCar;

import java.util.ArrayList;

public enum PassengerCarBodyType {
    SEDAN(TypeOfCar.PASSENGER_CAR),
    HATCHBACK(TypeOfCar.PASSENGER_CAR),
    UNIVERSAL(TypeOfCar.PASSENGER_CAR),
    CABRIOLET(TypeOfCar.PASSENGER_CAR),
    ;

    private TypeOfCar typeOfCar;

    PassengerCarBodyType(TypeOfCar typeOfCar) {

        this.typeOfCar = typeOfCar;
    }

    public static ArrayList<PassengerCarBodyType> getListOfPassengerCarBodyTypes() {
        ArrayList<PassengerCarBodyType> passengerCarBodyTypes = new ArrayList<>();
        for (PassengerCarBodyType passengerCarBodyType : PassengerCarBodyType.values()) {
            passengerCarBodyTypes.add(passengerCarBodyType);
        }
        return passengerCarBodyTypes;
    }

    public TypeOfCar getTypeOfCar() {
        return typeOfCar;
    }
}
