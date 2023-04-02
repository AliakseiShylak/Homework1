package order;

import carparameters.*;

import java.util.EnumSet;

public class Order<S> {
    protected Model modelOfOrderedCar;
    protected Color colorOfOrderedCar;
    protected Wheel wheelOfOrderedCar;
    protected Engine engineOfOrderedCar;
    protected EnumSet<Option> optionsOfOrderedCar;

    public Order(
            Model modelOfOrderedCar,
            Color colorOfOrderedCar,
            Wheel wheelOfOrderedCar,
            Engine engineOfOrderedCar,
            EnumSet<Option> optionsOfOrderedCar
    ) {
        this.modelOfOrderedCar = modelOfOrderedCar;
        this.colorOfOrderedCar = colorOfOrderedCar;
        this.wheelOfOrderedCar = wheelOfOrderedCar;
        this.engineOfOrderedCar = engineOfOrderedCar;
        if (optionsOfOrderedCar == null) {
            this.optionsOfOrderedCar = EnumSet.noneOf(Option.class);
        } else {
            this.optionsOfOrderedCar = optionsOfOrderedCar.clone();
        }
    }

    public Model getModelOfOrderedCar() {
        return modelOfOrderedCar;
    }

    public Color getColorOfOrderedCar() {
        return colorOfOrderedCar;
    }

    public Wheel getWheelOfOrderedCar() {
        return wheelOfOrderedCar;
    }

    public Engine getEngineOfOrderedCar() {
        return engineOfOrderedCar;
    }

    public EnumSet<Option> getOptionsOfOrderedCar() {
        return optionsOfOrderedCar;
    }
}
