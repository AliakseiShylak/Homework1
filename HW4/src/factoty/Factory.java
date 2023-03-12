package factoty;

import cars.*;
import cars.enums.*;
import exceptions.NotValidArgumentException;
import services.ChangeService;
import services.OptionService;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Set;

public class Factory {
    private final String nameOfFactory;
    private final TypeOfCar carTypeOfFactory;
    private final ArrayList<Model> modelsOfFactory;
    private final ArrayList<Engine> setOfEngines;
    private final ArrayList<Color> setOfColors;
    private final ArrayList<Wheel> setOfWheels;
    private final Stock stockOfFactory;
    private final ChangeService changeServiceOfFactory;
    private final OptionService optionServiceOfFactory;

    public Factory(String nameOfFactory,
                   TypeOfCar carTypeOfFactory,
                   ArrayList<Model> modelsOfFactory,
                   ArrayList<Engine> setOfEngines,
                   ArrayList<Color> setOfColors,
                   ArrayList<Wheel> setOfWheels,
                   Stock stockOfFactory
    ) throws NotValidArgumentException {
        if (!CarUtils.isParameterForThisTypeOfCar(carTypeOfFactory, setOfColors.get(0), modelsOfFactory.get(0),
                setOfWheels.get(0), setOfEngines.get(0))) {
            throw new NotValidArgumentException("Not valid constructor arguments");
        }
        this.nameOfFactory = nameOfFactory;
        this.carTypeOfFactory = carTypeOfFactory;
        this.modelsOfFactory = modelsOfFactory;
        this.setOfEngines = setOfEngines;
        this.setOfColors = setOfColors;
        this.setOfWheels = setOfWheels;
        this.stockOfFactory = stockOfFactory;
        this.changeServiceOfFactory = new ChangeService();
        this.optionServiceOfFactory = new OptionService();
    }

    public String getDataAboutFactory() {
        String str = "Factory: \"" + nameOfFactory +
                "\"\nSet of models: " + modelsOfFactory.toString() +
                "\nSet of engines: " + setOfEngines.toString() +
                "\nSet of colors: " + setOfColors.toString() +
                "\nSet of wheels: " + setOfWheels.toString();
        return str;
    }

    public String getStockOfFactory() {
        return "\nStock of factory \"" + this.nameOfFactory + "\":\n" + this.stockOfFactory.printStock();
    }

    public Bus createCar(Color color, Model model, Wheel wheel, Engine engine,
                         EnumSet<Option> options, BusPassengerCapacity busPassengerCapacity) {
        try {
            return new Bus(color, this.carTypeOfFactory, model, 2023, wheel, engine,
                    options, busPassengerCapacity);
        } catch (NotValidArgumentException e) {
            System.out.println(e);
        }
        return null;
    }

    public Truck createCar(Color color, Model model, Wheel wheel, Engine engine,
                           EnumSet<Option> options, TruckLoadCapacity truckLoadCapacity) {
        try {
            return new Truck(color, this.carTypeOfFactory, model, 2023, wheel, engine,
                    options, truckLoadCapacity);
        } catch (NotValidArgumentException e) {
            System.out.println(e);
        }
        return null;
    }

    public PassengerCar createCar(Color color, Model model, Wheel wheel, Engine engine,
                                  EnumSet<Option> options, PassengerCarBodyType passengerCarBodyType) {
        try {
            return new PassengerCar(color, this.carTypeOfFactory, model, 2023, wheel, engine,
                    options, passengerCarBodyType);
        } catch (NotValidArgumentException e) {
            System.out.println(e);
        }
        return null;
    }

    public <T extends Car> boolean addCarToStock(T car) {
        return stockOfFactory.addCarToStock(car);
    }
/*
    private boolean canFactoryProduceSuchCar(Car car) {
        if (!modelsOfFactory.contains(car.getMODEL()) ||
                !setOfEngines.contains(car.getENGINE()) ||
                !setOfColors.contains(car.getColor()) ||
                !setOfWheels.contains(car.getWheel())) {
            return false;
        } else {
            return true;
        }
    }

    private Car convertCar(Car oldCar, Car newCar) {
        if (!oldCar.getColor().equals(newCar.getColor())) {
            oldCar.changeColor(newCar.getColor());
        }
        if (!oldCar.getWheel().equals(newCar.getWheel())) {
            oldCar.changeWheels(newCar.getWheel());
        }
        if (!oldCar.getOption().equals(newCar.getOption())) {
            CarService.changeAllOptions(oldCar, newCar.getOption());
        }
        return oldCar;
    }

    public boolean completeShopOrder(CarShop shop, Car car) {
        Car currentCar = null;
        if (!canFactoryProduceSuchCar(car)) {
            return false;
        }
        if (stockOfFactory.findCar(car)) {
            return shop.addCarToStock(car) && stockOfFactory.deleteCar(car);
        }
        if (stockOfFactory.findConvertibleCar(car) != null) {
            currentCar = stockOfFactory.findConvertibleCar(car);
            convertCar(currentCar, car);
            return shop.addCarToStock(currentCar) && stockOfFactory.deleteCar(currentCar);
        } else {
            return shop.addCarToStock(car);
        }
    }

    public boolean addCarToStock(Car car) {
        if (!canFactoryProduceSuchCar(car)) {
            return false;
        } else {
            return this.stockOfFactory.addCarToStock(car);
        }
    }
    */
}
