package order;

import carparameters.passengercarenums.*;

import java.util.EnumSet;

public class PassengerCarOrder extends Order {
    private PassengerCarBodyType passengerCarBodyTypeOfOrderedCar;

    public PassengerCarOrder(
            PassengerCarModel modelOfOrderedCar,
            PassengerCarColor colorOfOrderedCar,
            PassengerCarWheel wheelOfOrderedCar,
            PassengerCarEngine engineOfOrderedCar,
            EnumSet optionsOfOrderedCar,
            PassengerCarBodyType passengerCarBodyTypeOfOrderedCar
    ) {
        super(modelOfOrderedCar, colorOfOrderedCar, wheelOfOrderedCar, engineOfOrderedCar, optionsOfOrderedCar);
        this.passengerCarBodyTypeOfOrderedCar = passengerCarBodyTypeOfOrderedCar;
    }

    public PassengerCarBodyType getPassengerCarBodyType() {
        return passengerCarBodyTypeOfOrderedCar;
    }
}
