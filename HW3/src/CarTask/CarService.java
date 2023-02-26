package CarTask;

import CarTask.Enums.ColorsOfCar;
import CarTask.Enums.Options;
import CarTask.Enums.SizeOfWheels;

import java.util.EnumSet;

public class CarService {
    public void repaintCar(Car car, ColorsOfCar newColor) {
        car.changeColor(newColor);
    }

    public void setNewWheels(Car car, SizeOfWheels newSize) {
        car.changeWheels(newSize);
    }

    public void addOneOption(Car car, Options newOption) {
        car.addOption(newOption);
    }

    public void deleteOneOption(Car car, Options oldOption) {
        car.deleteOption(oldOption);
    }

    public static void changeAllOptions(Car car, EnumSet<Options> newSetOfOptions) {
        car.deleteAllOptions();
        if (newSetOfOptions != null) {
            for (Options option : newSetOfOptions) {
                car.addOption(option);
            }
        }
    }
}
