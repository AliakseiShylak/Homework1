package services;

import cars.Car;
import cars.enums.Color;
import cars.enums.Wheel;

public class ChangeService {
    public <T extends Car, S> boolean change(T vehicle, S parameterForChanging) {
        if (vehicle == null || parameterForChanging == null) {
            return false;
        }
        if (parameterForChanging instanceof Color &&
                !parameterForChanging.equals(vehicle.getColor()) &&
                ((Color) parameterForChanging).isColorForThisCar(vehicle.getTypeOfCar())) {
            vehicle.setColor((Color) parameterForChanging);
            return true;
        }
        if (parameterForChanging instanceof Wheel &&
                !parameterForChanging.equals(vehicle.getWheel()) &&
                ((Wheel) parameterForChanging).isWheelForThisCar(vehicle.getTypeOfCar())) {
            vehicle.setWheel((Wheel) parameterForChanging);
            return true;
        }
        return false;
    }
}
