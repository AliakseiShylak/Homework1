package CarTask;

import CarTask.Enums.*;

import java.util.EnumSet;


public class Car {
    private ColorsOfCar color;
    private final Brands BRAND;
    private final ModelsOfCar MODEL;
    private final int YEAR;
    private SizeOfWheels wheel;
    private final Engines ENGINE;
    private EnumSet<Options> option;

    public Car(ColorsOfCar color, Brands brand, ModelsOfCar model, int year, SizeOfWheels wheel, Engines engine) {
        this.color = color;
        this.BRAND = brand;
        this.MODEL = model;
        this.YEAR = year;
        this.wheel = wheel;
        this.ENGINE = engine;
        this.option = null;
    }

    public Car(ColorsOfCar color, Brands brand, ModelsOfCar model, int year, SizeOfWheels wheel, Engines engine, EnumSet<Options> option) {
        this.color = color;
        this.BRAND = brand;
        this.MODEL = model;
        this.YEAR = year;
        this.wheel = wheel;
        this.ENGINE = engine;
        this.option = option;
    }

    public void changeColor(ColorsOfCar colorNew) {
        this.color = colorNew;
    }

    public void changeWheels(SizeOfWheels wheelNew) {
        this.wheel = wheelNew;
    }

    public void addOption(Options optionNew) {
        if (this.option == null) {
            this.option = EnumSet.of(optionNew);
        } else {
            this.option.add(optionNew);
        }
    }

    public void deleteOption(Options optionDeleted) {
        this.option.remove(optionDeleted);
    }

    public void deleteAllOptions() {
        this.option.removeAll(this.option);
    }

    public ColorsOfCar getColor() {
        return color;
    }

    public Brands getBRAND() {
        return BRAND;
    }

    public ModelsOfCar getMODEL() {
        return MODEL;
    }

    public int getYEAR() {
        return YEAR;
    }

    public SizeOfWheels getWheel() {
        return wheel;
    }

    public Engines getENGINE() {
        return ENGINE;
    }

    public EnumSet<Options> getOption() {
        return option;
    }

    public boolean convertibleCar(Car car) {
        if (this.BRAND == car.BRAND &&
                this.MODEL == car.MODEL &&
                this.YEAR == car.YEAR &&
                this.ENGINE == car.ENGINE) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "brand: " + BRAND +
                        ", model: " + MODEL +
                        ", year: " + YEAR +
                        ", color: " + color +
                        ", wheels: " + wheel +
                        ", engine: " + ENGINE +
                        ", options: " + (option == null || option.size() == 0 ? "[]" : option) +
                        '\n';
    }
}
