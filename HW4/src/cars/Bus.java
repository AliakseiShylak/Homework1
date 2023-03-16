package cars;

import cars.enums.*;
import exceptions.NotValidArgumentException;

import java.util.EnumSet;

import static java.lang.String.format;

public class Bus extends Car {
    private final String TO_STRING_ABOUT_BUS = "Type: %s, model: %s, passenger seats: %s, year: %s," +
            " engineVol: %s, color: %s, wheels: %s, options: %s";
    private final BusPassengerCapacity passengerSeats;

    public Bus(Color color, TypeOfCar typeOfCar, Model model, int year, Wheel wheel, Engine engine,
               EnumSet<Option> options, BusPassengerCapacity passengerSeats) throws NotValidArgumentException {
        super(color, typeOfCar, model, year, wheel, engine, options);
        if (!CarUtils.isParameterForThisTypeOfCar(typeOfCar, color, model, wheel, engine, passengerSeats)) {
            throw new NotValidArgumentException("Not valid constructor arguments");
        }
        this.passengerSeats = passengerSeats;
    }

    public Bus(Color color, TypeOfCar typeOfCar, Model model, int year, Wheel wheel,
               Engine engine, BusPassengerCapacity passengerSeats) throws NotValidArgumentException {
        super(color, typeOfCar, model, year, wheel, engine);
        if (!CarUtils.isParameterForThisTypeOfCar(typeOfCar, color, model, wheel, engine, passengerSeats)) {
            throw new NotValidArgumentException("Not valid constructor arguments");
        }
        this.passengerSeats = passengerSeats;
    }

    public BusPassengerCapacity getBusPassengerCapacity() {
        return passengerSeats;
    }

    @Override
    public String toString() {
        return format(
                TO_STRING_ABOUT_BUS,
                getTypeOfCar(),
                getModel(),
                passengerSeats.getSeatQuantity(),
                getYear(),
                getEngine(),
                getColor(),
                getWheel(),
                getOptions()
        );
    }
}
