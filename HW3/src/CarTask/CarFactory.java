package CarTask;

import CarTask.Enums.*;

import java.util.EnumSet;

public class CarFactory {
    private final String NAME_OF_FACTORY;
    private final EnumSet<Brands> BRANDS_OF_FACTORY;
    private final EnumSet<ModelsOfCar> MODELS_OF_FACTORY;
    private final EnumSet<Engines> SET_OF_ENGINES;
    private final EnumSet<ColorsOfCar> SET_OF_COLORS;
    private final EnumSet<SizeOfWheels> SET_OF_WHEELS;
    private Stock stockOfFactory;

    public CarFactory(String nameOfFactory,
                      EnumSet<Brands> brandsOfFactory,
                      EnumSet<ModelsOfCar> modelsOfFactory,
                      EnumSet<Engines> setOfEngines,
                      EnumSet<ColorsOfCar> setOfColors,
                      EnumSet<SizeOfWheels> setOfWheels,
                      Stock stock) {
        this.NAME_OF_FACTORY = nameOfFactory;
        this.BRANDS_OF_FACTORY = brandsOfFactory;
        this.MODELS_OF_FACTORY = modelsOfFactory;
        this.SET_OF_ENGINES = setOfEngines;
        this.SET_OF_COLORS = setOfColors;
        this.SET_OF_WHEELS = setOfWheels;
        this.stockOfFactory = stock;
    }

    public String getDataAboutFactory() {
        String str = "Brands produced by the factory " + NAME_OF_FACTORY +
                ": " + BRANDS_OF_FACTORY.toString() +
                "\nSet of models: " + MODELS_OF_FACTORY.toString() +
                "\nSet of engines: " + SET_OF_ENGINES.toString() +
                "\nSet of colors: " + SET_OF_COLORS.toString() +
                "\nSet of wheels: " + SET_OF_WHEELS.toString();
        return str;
    }

    public String printStockOfFactory() {
        return "\nStock of factory " + this.NAME_OF_FACTORY + this.stockOfFactory.printStock();
    }

    private boolean canFactoryProduceSuchCar(Car car) {
        if (!BRANDS_OF_FACTORY.contains(car.getBRAND()) ||
                !MODELS_OF_FACTORY.contains(car.getMODEL()) ||
                !SET_OF_ENGINES.contains(car.getENGINE()) ||
                !SET_OF_COLORS.contains(car.getColor()) ||
                !SET_OF_WHEELS.contains(car.getWheel())) {
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

    public String getNAME_OF_FACTORY() {
        return NAME_OF_FACTORY;
    }
}