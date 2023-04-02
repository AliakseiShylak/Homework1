package carparameters.busenums;

import carparameters.TypeOfCar;
import java.util.ArrayList;

public enum BusPassengerCapacity {
    SEATS_30(30, TypeOfCar.BUS),
    SEATS_40(40, TypeOfCar.BUS),
    SEATS_50(50, TypeOfCar.BUS),
    SEATS_60(60, TypeOfCar.BUS),
    ;
    private int seatQuantity;
    private TypeOfCar typeOfCar;

    BusPassengerCapacity(int seatQuantity, TypeOfCar typeOfCar) {
        this.seatQuantity = seatQuantity;
        this.typeOfCar = typeOfCar;
    }

    public int getSeatQuantity() {
        return seatQuantity;
    }

    public static ArrayList<BusPassengerCapacity> getListOfBusPassengerCapacities() {
        ArrayList<BusPassengerCapacity> busPassengerCapacities = new ArrayList<>();
        for (BusPassengerCapacity busPassengerCapacity : BusPassengerCapacity.values()) {
            busPassengerCapacities.add(busPassengerCapacity);
        }
        return busPassengerCapacities;
    }

    public TypeOfCar getTypeOfCar() {
        return typeOfCar;
    }
}
