package factoty;

import cars.*;
import cars.enums.*;
import exceptions.NotValidArgumentException;
import services.ChangeService;
import services.OptionService;
import showroom.Order;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;

public class Factory {
    final static int CURRENT_YEAR = 2023;
    private final String nameOfFactory;
    private final TypeOfCar carTypeOfFactory;
    private final ArrayList<Model> modelsOfFactory;
    private final ArrayList<Engine> setOfEngines;
    private final ArrayList<Color> setOfColors;
    private final ArrayList<Wheel> setOfWheels;
    protected final Stock stockOfFactory;
    private final ChangeService changeServiceOfFactory;
    private final OptionService optionServiceOfFactory;

    public TypeOfCar getCarTypeOfFactory() {
        return carTypeOfFactory;
    }

    public Factory(String nameOfFactory,
                   TypeOfCar carTypeOfFactory,
                   ArrayList<Model> modelsOfFactory,
                   ArrayList<Engine> setOfEngines,
                   ArrayList<Color> setOfColors,
                   ArrayList<Wheel> setOfWheels
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
        this.stockOfFactory = new Stock(new ArrayList<>());
        Random carQuantity = new Random();
        CarUtils.generateRandomCars(carTypeOfFactory, this.stockOfFactory, carQuantity.nextInt(10));
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

    public String printStockOfFactory() {
        return "\nStock of factory \"" + this.nameOfFactory + "\":\n" + this.stockOfFactory.printStock();
    }

    public <T extends Car> boolean addCarToStock(T car) {
        return stockOfFactory.addCarToStock(car);
    }

    protected boolean checkOrder(Order order) {
        if (order.getTypeOfOrderedCar().equals(this.carTypeOfFactory)
                && order.getModelOfOrderedCar().isModelForThisCar(this.carTypeOfFactory)
                && order.getEngineOfOrderedCar().isEngineForThisCar(this.carTypeOfFactory)
                && order.getColorOfOrderedCar().isColorForThisCar(this.carTypeOfFactory)
                && order.getWheelOfOrderedCar().isWheelForThisCar(this.carTypeOfFactory)
        ) {
            return true;
        }
        return false;
    }

    public static <T extends Car, S> boolean isCarConvertible(T car,
                                                              TypeOfCar typeOfOrderedCar,
                                                              Model modelOfOrderedCar,
                                                              Engine engineOfOrderedCar,
                                                              S carParameter) {
        if (car.getTypeOfCar().equals(typeOfOrderedCar)
                && car.getModel().equals(modelOfOrderedCar)
                && car.getEngine().equals(engineOfOrderedCar)
        ) {
            if (car instanceof Bus
                    && typeOfOrderedCar.equals(TypeOfCar.BUS)
                    && ((Bus) car).getBusPassengerCapacity().equals(carParameter)
            ) {
                return true;
            }
            if (car instanceof PassengerCar
                    && typeOfOrderedCar.equals(TypeOfCar.PASSENGER_CAR)
                    && ((PassengerCar) car).getPassengerCarBodyType().equals(carParameter)
            ) {
                return true;
            }
            if (car instanceof Truck
                    && typeOfOrderedCar.equals(TypeOfCar.TRUCK)
                    && ((Truck) car).getTruckLoadCapacity().equals(carParameter)
            ) {
                return true;
            }
        }
        return false;
    }

    protected <T extends Car> T convertCar(T carToChange, Order order) {
        if (carToChange == null) {
            return null;
        }
        if (!carToChange.getColor().equals(order.getColorOfOrderedCar())) {
            changeServiceOfFactory.change(carToChange, order.getColorOfOrderedCar());
        }
        if (!carToChange.getWheel().equals(order.getWheelOfOrderedCar())) {
            changeServiceOfFactory.change(carToChange, order.getWheelOfOrderedCar());
        }
        if (!carToChange.getOptions().equals(order.getOptionsOfOrderedCar())) {
            optionServiceOfFactory.setOptions(carToChange, order.getOptionsOfOrderedCar());
        }
        return carToChange;
    }
}
