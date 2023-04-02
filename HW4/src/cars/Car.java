package cars;

import carparameters.*;
import services.ChangeColorService;

import java.util.EnumSet;

public class Car {
    private Color color;
    private final TypeOfCar typeOfCar;
    private final Model model;
    private final int year;
    private Wheel wheel;
    private final Engine engine;
    private EnumSet<Option> options;

    public Car(
            Color color,
            TypeOfCar typeOfCar,
            Model model,
            int year,
            Wheel wheel,
            Engine engine,
            EnumSet<Option> options
    ) {
        this.color = color;
        this.typeOfCar = typeOfCar;
        this.model = model;
        this.year = year;
        this.wheel = wheel;
        this.engine = engine;
        if (options == null) {
            this.options = EnumSet.noneOf(Option.class);
        } else {
            this.options = options.clone();
        }
    }

    public Car(Color color, TypeOfCar typeOfCar, Model model, int year, Wheel wheel, Engine engine) {
        this.color = color;
        this.typeOfCar = typeOfCar;
        this.model = model;
        this.year = year;
        this.wheel = wheel;
        this.engine = engine;
        this.options = EnumSet.noneOf(Option.class);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public void addOption(Option newOption) {
        if (this.options == null) {
            this.options = EnumSet.of(newOption);
        } else {
            this.options.add(newOption);
        }
    }

    public TypeOfCar getTypeOfCar() {
        return typeOfCar;
    }

    public Color getColor() {
        return color;
    }

    public Model getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public Engine getEngine() {
        return engine;
    }

    public EnumSet<Option> getOptions() {
        return options;
    }
}
