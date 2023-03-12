package cars.enums;

public enum TruckLoadCapacity {
    TONS_20(20.0, TypeOfCar.TRUCK),
    TONS_22(22.0, TypeOfCar.TRUCK),
    TONS_23_5(23.5, TypeOfCar.TRUCK),
    ;
    private double loadCapacity;
    private TypeOfCar typeOfCar;

    TruckLoadCapacity(double loadCapacity, TypeOfCar typeOfCar) {
        this.loadCapacity = loadCapacity;
        this.typeOfCar = typeOfCar;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public TypeOfCar getTypeOfCar() {
        return typeOfCar;
    }
}
