package carparameters;

import java.util.ArrayList;

public enum Option {
    CONDITIONER,
    ABS,
    HEATED_SEATS,
    CRUISE_CONTROL,
    ;

    public static ArrayList<Option> getListOfOptions() {
        ArrayList<Option> options = new ArrayList<>();
        for (Option option : Option.values()) {
            options.add(option);
        }
        return options;
    }
}