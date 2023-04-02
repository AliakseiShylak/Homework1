package utils;

import carparameters.Option;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;

public interface Generator {
    public static final Random RANDOM = new Random();

    void generateRandomCars(int quantity);

    public static <T> T generateRandomParameter(T[] parameters) {
        return parameters[RANDOM.nextInt(parameters.length)];
    }

    public static EnumSet<Option> generateRandomOptions() {
        ArrayList<Option> tempOptions = Option.getListOfOptions();
        EnumSet<Option> randomOptions = EnumSet.noneOf(Option.class);
        int optionQuantity = RANDOM.nextInt(tempOptions.size() + 1);
        for (int j = 0; j < optionQuantity; j++) {
            int tempIndex = RANDOM.nextInt(tempOptions.size());
            randomOptions.add(tempOptions.get(tempIndex));
            tempOptions.remove(tempIndex);
        }
        return randomOptions;
    }
}
