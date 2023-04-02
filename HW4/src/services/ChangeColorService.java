package services;

import carparameters.Color;
import cars.Car;

public class ChangeColorService {
    public boolean changeColor(Car car, Color color) {
        if (car.getTypeOfCar().equals(color.getTypeOfCar())) {
            car.setColor(color);
            return true;
        }
        return false;
    }
}
