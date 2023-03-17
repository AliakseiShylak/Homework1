package cars;

import cars.Car;
import cars.enums.*;
import exceptions.NotValidArgumentException;

import java.util.EnumSet;

import static java.lang.String.format;

public class PassengerCar extends Car {
    private final String TO_STRING_ABOUT_PASSENGER_CAR = "Type: %s, model: %s, car body type: %s, year: %s," +
            " engineVol: %s, color: %s, wheels: %s, options: %s";
    private final PassengerCarBodyType carBodyType;

    public PassengerCar(Color color,
                        TypeOfCar typeOfCar,
                        Model model, int year,
                        Wheel wheel,
                        Engine engine,
                        EnumSet<Option> options,
                        PassengerCarBodyType carBodyType
    ) throws NotValidArgumentException {
        super(color, typeOfCar, model, year, wheel, engine, options);
        if (!CarUtils.isParameterForThisTypeOfCar(typeOfCar, color, model, wheel, engine, carBodyType)) {
            throw new NotValidArgumentException("Not valid constructor arguments");
        }
        this.carBodyType = carBodyType;
    }

    public PassengerCar(Color color,
                        TypeOfCar typeOfCar,
                        Model model,
                        int year,
                        Wheel wheel,
                        Engine engine,
                        PassengerCarBodyType carBodyType
    ) throws NotValidArgumentException {
        super(color, typeOfCar, model, year, wheel, engine);
        if (!CarUtils.isParameterForThisTypeOfCar(typeOfCar, color, model, wheel, engine, carBodyType)) {
            throw new NotValidArgumentException("Not valid constructor arguments");
        }
        this.carBodyType = carBodyType;
    }

    public PassengerCarBodyType getPassengerCarBodyType() {
        return carBodyType;
    }

    @Override
    public String toString() {
        return format(
                TO_STRING_ABOUT_PASSENGER_CAR,
                getTypeOfCar(),
                getModel(),
                carBodyType,
                getYear(),
                getEngine(),
                getColor(),
                getWheel(),
                getOptions()
        );
    }
}
