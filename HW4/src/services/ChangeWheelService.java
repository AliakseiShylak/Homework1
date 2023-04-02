package services;

import carparameters.Color;
import carparameters.Wheel;
import cars.Car;

public class ChangeWheelService {
    public boolean changeWheel(Car car, Wheel wheel) {
        if (car.getTypeOfCar().equals(wheel.getTypeOfCar())) {
            car.setWheel(wheel);
            return true;
        }
        return false;
    }
}
