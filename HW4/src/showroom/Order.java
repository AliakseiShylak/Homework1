package showroom;

import cars.enums.*;
import factoty.Factory;
import showroom.Showroom;

import java.util.EnumSet;

public class Order<S> {
    private Showroom buyer;
    private Factory producer;
    private TypeOfCar typeOfOrderedCar;
    private Model modelOfOrderedCar;
    private Color colorOfOrderedCar;
    private Wheel wheelOfOrderedCar;
    private Engine engineOfOrderedCar;
    private EnumSet<Option> optionsOfOrderedCar;
    private S parameterOfOrderedCar;

    public Order(Showroom buyer,
                 Factory producer,
                 TypeOfCar typeOfOrderedCar,
                 Model modelOfOrderedCar,
                 Color colorOfOrderedCar,
                 Wheel wheelOfOrderedCar,
                 Engine engineOfOrderedCar,
                 EnumSet<Option> optionsOfOrderedCar,
                 S parameterOfOrderedCar) {
        this.buyer = buyer;
        this.producer = producer;
        this.typeOfOrderedCar = typeOfOrderedCar;
        this.modelOfOrderedCar = modelOfOrderedCar;
        this.colorOfOrderedCar = colorOfOrderedCar;
        this.wheelOfOrderedCar = wheelOfOrderedCar;
        this.engineOfOrderedCar = engineOfOrderedCar;
        if (optionsOfOrderedCar == null) {
            this.optionsOfOrderedCar = EnumSet.noneOf(Option.class);
        } else {
            this.optionsOfOrderedCar = optionsOfOrderedCar.clone();
        }
        this.parameterOfOrderedCar = parameterOfOrderedCar;
    }

    public Showroom getBuyer() {
        return buyer;
    }

    public Factory getProducer() {
        return producer;
    }

    public TypeOfCar getTypeOfOrderedCar() {
        return typeOfOrderedCar;
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

    public S getParameterOfOrderedCar() {
        return parameterOfOrderedCar;
    }
}
