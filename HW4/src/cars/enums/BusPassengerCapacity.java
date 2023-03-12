package cars.enums;

import cars.Bus;

public enum BusPassengerCapacity {
    SEATS_30 (30, TypeOfCar.BUS),
    SEATS_40 (40, TypeOfCar.BUS),
    SEATS_50 (50, TypeOfCar.BUS),
    SEATS_60 (60, TypeOfCar.BUS),
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

    public TypeOfCar getTypeOfCar() {
        return typeOfCar;
    }
}
