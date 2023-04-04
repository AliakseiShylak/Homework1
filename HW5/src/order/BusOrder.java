package order;

import carparameters.busenums.*;

import java.util.EnumSet;

public class BusOrder extends Order {
    private BusPassengerCapacity busPassengerCapacityOfOrderedCar;

    public BusOrder(
            BusModel modelOfOrderedCar,
            BusColor colorOfOrderedCar,
            BusWheel wheelOfOrderedCar,
            BusEngine engineOfOrderedCar,
            EnumSet optionsOfOrderedCar,
            BusPassengerCapacity busPassengerCapacityOfOrderedCar
    ) {
        super(modelOfOrderedCar, colorOfOrderedCar, wheelOfOrderedCar, engineOfOrderedCar, optionsOfOrderedCar);
        this.busPassengerCapacityOfOrderedCar = busPassengerCapacityOfOrderedCar;
    }

    public BusPassengerCapacity getBusPassengerCapacityOfOrderedCar() {
        return busPassengerCapacityOfOrderedCar;
    }
}
