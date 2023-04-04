package cars;

import carparameters.Option;
import carparameters.TypeOfCar;
import carparameters.busenums.*;

import java.util.EnumSet;

import static java.lang.String.format;

public class Bus extends Car{
    private final String TO_STRING_ABOUT_BUS = "Type: %s, model: %s, passenger seats: %s, year: %s," +
            " engineVol: %s, color: %s, wheels: %s, options: %s";
    private final BusPassengerCapacity passengerSeats;

    public Bus(
            BusColor color,
            BusModel model,
            int year,
            BusWheel wheel,
            BusEngine engine,
            EnumSet<Option> options,
            BusPassengerCapacity passengerSeats
    ) {
        super(color, TypeOfCar.BUS, model, year, wheel, engine, options);
        this.passengerSeats = passengerSeats;
    }

    public Bus(
            BusColor color,
            BusModel model,
            int year,
            BusWheel wheel,
            BusEngine engine,
            BusPassengerCapacity passengerSeats
    ) {
        super(color, TypeOfCar.BUS, model, year, wheel, engine);
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
