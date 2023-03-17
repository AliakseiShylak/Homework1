package showroom;

import cars.Bus;
import cars.Car;
import cars.PassengerCar;
import cars.Truck;
import cars.enums.Color;
import cars.enums.Option;
import cars.enums.TypeOfCar;
import cars.enums.Wheel;
import factoty.*;
import services.ChangeService;
import services.OptionService;

import java.util.*;

public class Showroom {
    private final String nameOfShowroom;
    private final ChangeService changeServiceOfShowroom;
    private final OptionService optionServiceOfShowroom;
    private final Map<TypeOfCar, Stock> stockOfShowroom;

    public Showroom(String nameOfShowroom) {
        this.nameOfShowroom = nameOfShowroom;
        this.changeServiceOfShowroom = new ChangeService();
        this.optionServiceOfShowroom = new OptionService();
        this.stockOfShowroom = new HashMap<>();
        this.stockOfShowroom.put(TypeOfCar.BUS, new Stock(new ArrayList<Bus>()));
        this.stockOfShowroom.put(TypeOfCar.PASSENGER_CAR, new Stock(new ArrayList<PassengerCar>()));
        this.stockOfShowroom.put(TypeOfCar.TRUCK, new Stock(new ArrayList<Truck>()));
    }

    public String printStockOfShowroom() {
        return "\nStock of showroom \"" + this.nameOfShowroom
                + "\":\nBuses: " + this.stockOfShowroom.get(TypeOfCar.BUS).printStock()
                + "\nPassenger cars: " + this.stockOfShowroom.get(TypeOfCar.PASSENGER_CAR).printStock()
                + "\nTrucks: " + this.stockOfShowroom.get(TypeOfCar.TRUCK).printStock();
    }

    private <T extends Car> boolean addCarToStock(T car) {
        if (car == null) {
            return false;
        }
        if (car.getTypeOfCar().equals(TypeOfCar.BUS)) {
            return this.stockOfShowroom.get(TypeOfCar.BUS).addCarToStock(car);
        }
        if (car.getTypeOfCar().equals(TypeOfCar.PASSENGER_CAR)) {
            return this.stockOfShowroom.get(TypeOfCar.PASSENGER_CAR).addCarToStock(car);
        }
        if (car.getTypeOfCar().equals(TypeOfCar.TRUCK)) {
            return this.stockOfShowroom.get(TypeOfCar.TRUCK).addCarToStock(car);
        }
        return false;
    }

    public <P extends Factory> boolean orderCar(P factory, Order order) {
        if (factory instanceof BusFactory && addCarToStock(((BusFactory) factory).completeOrder(order))) {
            return true;
        }
        if (factory instanceof PassengerCarFactoty && addCarToStock(((PassengerCarFactoty) factory).completeOrder(order))) {
            return true;
        }
        if (factory instanceof TruckFactory && addCarToStock(((TruckFactory) factory).completeOrder(order))) {
            return true;
        }
        return false;
    }

    public <T extends Car> T changeColor(T car, Color newColor) {
        changeServiceOfShowroom.change(car, newColor);
        return car;
    }

    public <T extends Car> T changeWheels(T car, Wheel newWheel) {
        changeServiceOfShowroom.change(car, newWheel);
        return car;
    }

    public <T extends Car> T addOption(T car, Option option) {
        optionServiceOfShowroom.addOption(car, option);
        return car;
    }

    public <T extends Car> T deleteOption(T car, Option option) {
        optionServiceOfShowroom.deleteOption(car, option);
        return car;
    }

    public <T extends Car> T setOptions(T car, EnumSet<Option> options) {
        optionServiceOfShowroom.setOptions(car, options);
        return car;
    }
}
