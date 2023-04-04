package factoty;

import carparameters.*;
import cars.*;
import services.ChangeColorService;
import services.ChangeWheelService;
import services.OptionService;
import order.Order;
import stock.Stock;

import java.util.ArrayList;

public class Factory {
    final static int CURRENT_YEAR = 2023;
    private final String nameOfFactory;
    protected final TypeOfCar carTypeOfFactory;
    protected final ArrayList<Model> modelsOfFactory;
    protected final ArrayList<Engine> setOfEngines;
    protected final ArrayList<Color> setOfColors;
    protected final ArrayList<Wheel> setOfWheels;
    protected final Stock stockOfFactory;
    private final ChangeColorService changeColorServiceOfFactory;
    private final ChangeWheelService changeWheelServiceOfFactory;
    private final OptionService optionServiceOfFactory;

    public TypeOfCar getCarTypeOfFactory() {
        return carTypeOfFactory;
    }

    public Factory(String nameOfFactory, TypeOfCar carTypeOfFactory) {
        this.nameOfFactory = nameOfFactory;
        this.carTypeOfFactory = carTypeOfFactory;
        this.modelsOfFactory = new ArrayList<>();
        this.setOfEngines = new ArrayList<>();
        this.setOfColors = new ArrayList<>();
        this.setOfWheels = new ArrayList<>();
        this.stockOfFactory = new Stock(new ArrayList<>());
        this.changeColorServiceOfFactory = new ChangeColorService();
        this.changeWheelServiceOfFactory = new ChangeWheelService();
        this.optionServiceOfFactory = new OptionService();
    }

    public void printDataAboutFactory() {
        System.out.println(
                "\nFactory: \"" + nameOfFactory +
                        "\"\nSet of models: " + modelsOfFactory.toString() +
                        "\nSet of engines: " + setOfEngines.toString() +
                        "\nSet of colors: " + setOfColors.toString() +
                        "\nSet of wheels: " + setOfWheels.toString()
        );
    }

    public void printStockOfFactory() {
        System.out.println("\nStock of factory \"" + this.nameOfFactory + "\":" + this.stockOfFactory.printStock());
    }

    protected  <T extends Car> boolean addCarToStock(T car) {
        return stockOfFactory.addCarToStock(car);
    }

    protected int estimateСarСompatibility(Car car, Order order) {
        int counter = -1;
        if (car.getModel().equals(order.getModelOfOrderedCar())
                && car.getEngine().equals(order.getEngineOfOrderedCar())) {
            counter++;
            if (car.getColor().equals(order.getColorOfOrderedCar())) {
                counter += 10;
            }
            if (car.getWheel().equals(order.getWheelOfOrderedCar())) {
                counter += 1;
            }
            for (Option option : car.getOptions()) {
                if (order.getOptionsOfOrderedCar().contains(option)) {
                    counter += 2;
                }
            }
        }
        return counter;
    }

    protected <T extends Car> T convertCar(T carToChange, Order order) {
        if (carToChange == null) {
            return null;
        }
        if (!carToChange.getColor().equals(order.getColorOfOrderedCar())) {
            changeColorServiceOfFactory.changeColor(carToChange, order.getColorOfOrderedCar());
        }
        if (!carToChange.getWheel().equals(order.getWheelOfOrderedCar())) {
            changeWheelServiceOfFactory.changeWheel(carToChange, order.getWheelOfOrderedCar());
        }
        if (!carToChange.getOptions().equals(order.getOptionsOfOrderedCar())) {
            optionServiceOfFactory.setOptions(carToChange, order.getOptionsOfOrderedCar());
        }
        return carToChange;
    }
}
