package cars.enums;

public enum Engine {
    V1_4(TypeOfCar.PASSENGER_CAR),
    V1_6(TypeOfCar.PASSENGER_CAR),
    V4_0(TypeOfCar.BUS),
    V5_0(TypeOfCar.BUS),
    V6_0(TypeOfCar.TRUCK),
    V6_5(TypeOfCar.TRUCK),
    ;

    private TypeOfCar typeOfCar;

    Engine(TypeOfCar typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public boolean isEngineForThisCar(TypeOfCar car) {
        return this.typeOfCar.equals(car);
    }

    public TypeOfCar getTypeOfCar() {
        return typeOfCar;
    }
}
