package cars.enums;

public enum Model {
    NEOPLAN_STARLINER(TypeOfCar.BUS),
    NEOPLAN_EUROLINER(TypeOfCar.BUS),
    SCANIA_L320(TypeOfCar.TRUCK),
    SCANIA_S730(TypeOfCar.TRUCK),
    KIA_CEED(TypeOfCar.PASSENGER_CAR),
    KIA_RIO(TypeOfCar.PASSENGER_CAR),
    KIA_CERATO(TypeOfCar.PASSENGER_CAR),
    ;

    private TypeOfCar typeOfCar;

    Model(TypeOfCar typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public boolean isModelForThisCar(TypeOfCar car) {
        return this.typeOfCar.equals(car);
    }

    public TypeOfCar getTypeOfCar() {
        return typeOfCar;
    }
}
