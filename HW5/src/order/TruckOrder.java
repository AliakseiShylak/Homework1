package order;

import carparameters.truckenums.*;

import java.util.EnumSet;

public class TruckOrder extends Order {
    private TruckLoadCapacity truckLoadCapacityOfOrderedCar;

    public TruckOrder(
            TruckModel modelOfOrderedCar,
            TruckColor colorOfOrderedCar,
            TruckWheel wheelOfOrderedCar,
            TruckEngine engineOfOrderedCar,
            EnumSet optionsOfOrderedCar,
            TruckLoadCapacity truckLoadCapacityOfOrderedCar
    ) {
        super(modelOfOrderedCar, colorOfOrderedCar, wheelOfOrderedCar, engineOfOrderedCar, optionsOfOrderedCar);
        this.truckLoadCapacityOfOrderedCar = truckLoadCapacityOfOrderedCar;
    }

    public TruckLoadCapacity getTruckLoadCapacityOfOrderedCar() {
        return truckLoadCapacityOfOrderedCar;
    }
}
