package cars;

import carparameters.Option;
import carparameters.TypeOfCar;
import carparameters.busenums.BusColor;
import carparameters.busenums.BusWheel;
import carparameters.passengercarenums.*;

import java.util.EnumSet;

import static java.lang.String.format;

public class PassengerCar extends Car {
    private final String TO_STRING_ABOUT_PASSENGER_CAR = "Type: %s, model: %s, car body type: %s, year: %s," +
            " engineVol: %s, color: %s, wheels: %s, options: %s";
    private final PassengerCarBodyType carBodyType;

    public PassengerCar(
            PassengerCarColor color,
            PassengerCarModel model,
            int year,
            PassengerCarWheel wheel,
            PassengerCarEngine engine,
            EnumSet<Option> options,
            PassengerCarBodyType carBodyType
    ) {
        super(color, TypeOfCar.PASSENGER_CAR, model, year, wheel, engine, options);
        this.carBodyType = carBodyType;
    }

    public PassengerCar(
            PassengerCarColor color,
            PassengerCarModel model,
            int year,
            PassengerCarWheel wheel,
            PassengerCarEngine engine,
            PassengerCarBodyType carBodyType
    ) {
        super(color, TypeOfCar.PASSENGER_CAR, model, year, wheel, engine);
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
