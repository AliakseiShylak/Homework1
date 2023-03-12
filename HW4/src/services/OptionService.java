package services;

import cars.Car;
import cars.enums.Option;

import java.util.EnumSet;
import java.util.Set;

public class OptionService<T extends Car> {
    public static <T extends Car> void addOption(T vehicle, Option option) {
        if (vehicle != null && option != null) {
            vehicle.addOption(option);
        }
    }

    public static <T extends Car> void deleteOption(T vehicle, Option option) {
        if (vehicle != null && option != null) {
            vehicle.getOptions().remove(option);
        }
    }

    public static <T extends Car> void setOptions(T vehicle, EnumSet<Option> options) {
        if (vehicle != null && options != null) {
            for (Option option : vehicle.getOptions()) {
                if (!options.contains(option)) {
                    deleteOption(vehicle, option);
                }
            }
            for (Option option : options) {
                if (!options.contains(vehicle.getOptions())) {
                    addOption(vehicle, option);
                }
            }
        }
    }
}
