package cars;

import cars.enums.*;
import exceptions.NotValidArgumentException;

import java.util.EnumSet;

import static java.lang.String.format;

public class Truck extends Car {
    private final String TO_STRING_ABOUT_TRUCK = "Type: %s, model: %s, load capacity: %s tons, year: %s," +
            " engineVol: %s, color: %s, wheels: %s, options: %s";
    private TruckLoadCapacity loadCapacity;

    public Truck(Color color,
                 TypeOfCar typeOfCar,
                 Model model,
                 int year,
                 Wheel wheel,
                 Engine engine,
                 EnumSet<Option> options,
                 TruckLoadCapacity loadCapacity
    ) throws NotValidArgumentException {
        super(color, typeOfCar, model, year, wheel, engine, options);
        if (!CarUtils.isParameterForThisTypeOfCar(typeOfCar, color, model, wheel, engine, loadCapacity)) {
            throw new NotValidArgumentException("Not valid constructor arguments");
        }
        this.loadCapacity = loadCapacity;
    }

    public Truck(Color color,
                 TypeOfCar typeOfCar,
                 Model model,
                 int year,
                 Wheel wheel,
                 Engine engine,
                 TruckLoadCapacity loadCapacity
    ) throws NotValidArgumentException {
        super(color, typeOfCar, model, year, wheel, engine);
        if (!CarUtils.isParameterForThisTypeOfCar(typeOfCar, color, model, wheel, engine, loadCapacity)) {
            throw new NotValidArgumentException("Not valid constructor arguments");
        }
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
