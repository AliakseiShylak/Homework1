package cars.enums;

public enum Wheel {
    R13(TypeOfCar.PASSENGER_CAR),
    R14(TypeOfCar.PASSENGER_CAR),
    R20(TypeOfCar.BUS),
    R22(TypeOfCar.BUS),
    R23(TypeOfCar.TRUCK),
    R25(TypeOfCar.TRUCK),
    ;

    private TypeOfCar typeOfCar;

    Wheel(TypeOfCar typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public boolean isWheelForThisCar(TypeOfCar car) {
        return this.typeOfCar.equals(car);
    }

    public TypeOfCar getTypeOfCar() {
        return typeOfCar;
    }
}
