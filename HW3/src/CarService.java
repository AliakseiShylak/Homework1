import java.util.EnumSet;

public class CarService {
    public static void repaintCar(Car car, ColorsOfCar newColor) {
        car.changeColor(newColor);
    }

    public static void setNewWheels(Car car, SizeOfWheels newSize) {
        car.changeWheels(newSize);
    }

    public static void addOneOption(Car car, Options newOption) {
        car.addOption(newOption);
    }

    public static void deleteOneOption(Car car, Options oldOption) {
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
