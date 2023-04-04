package services;

import cars.Car;
import carparameters.Option;

import java.util.EnumSet;

public class OptionService<T extends Car> {
    public <T extends Car> boolean addOption(T car, Option option) {
        if (car == null || option == null) {
            return false;
        }
        car.addOption(option);
        return true;
    }

    public <T extends Car> boolean deleteOption(T car, Option option) {
        if (car == null || option == null) {
            return false;
        }
        car.getOptions().remove(option);
        return true;
    }

    public <T extends Car> boolean setOptions(T car, EnumSet<Option> options) {
        if (car == null || options == null) {
            return false;
        }
        for (Option option : car.getOptions()) {
            if (!options.contains(option)) {
                deleteOption(car, option);
            }
        }
        for (Option option : options) {
            if (!options.contains(car.getOptions())) {
                addOption(car, option);
            }
        }
        return true;
    }
}
