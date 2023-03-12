package cars.enums;

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

    public TypeOfCar getTypeOfCar() {
        return typeOfCar;
    }
}
