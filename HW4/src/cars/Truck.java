package cars;

import carparameters.Option;
import carparameters.TypeOfCar;
import carparameters.truckenums.*;

import java.util.EnumSet;

import static java.lang.String.format;

public class Truck extends Car {
    private final String TO_STRING_ABOUT_TRUCK = "Type: %s, model: %s, load capacity: %s tons, year: %s," +
            " engineVol: %s, color: %s, wheels: %s, options: %s";
    private TruckLoadCapacity loadCapacity;

    public Truck(
            TruckColor color,
            TruckModel model,
            int year,
            TruckWheel wheel,
            TruckEngine engine,
            EnumSet<Option> options,
            TruckLoadCapacity loadCapacity
    ) {
        super(color, TypeOfCar.TRUCK, model, year, wheel, engine, options);
        this.loadCapacity = loadCapacity;
    }

    public Truck(
            TruckColor color,
            TruckModel model,
            int year,
            TruckWheel wheel,
            TruckEngine engine,
            TruckLoadCapacity loadCapacity
    ) {
        super(color, TypeOfCar.TRUCK, model, year, wheel, engine);
        this.loadCapacity = loadCapacity;
    }

    public TruckLoadCapacity getTruckLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public String toString() {
        return format(
                TO_STRING_ABOUT_TRUCK,
                getTypeOfCar(),
                getModel(),
                loadCapacity.getLoadCapacity(),
                getYear(),
                getEngine(),
                getColor(),
                getWheel(),
                getOptions()
        );
    }
}
