package factoty;

import cars.Bus;
import cars.PassengerCar;
import cars.Truck;
import cars.enums.*;
import exceptions.NotValidArgumentException;
import showroom.Order;

import java.util.ArrayList;
import java.util.EnumSet;

public class PassengerCarFactoty extends Factory implements GeneralizedForFactory<PassengerCar, PassengerCarBodyType> {
    public PassengerCarFactoty(String nameOfFactory,
                               TypeOfCar carTypeOfFactory,
                               ArrayList<Model> modelsOfFactory,
                               ArrayList<Engine> setOfEngines,
                               ArrayList<Color> setOfColors,
                               ArrayList<Wheel> setOfWheels
    ) throws NotValidArgumentException {
        super(nameOfFactory, carTypeOfFactory, modelsOfFactory, setOfEngines, setOfColors, setOfWheels);
    }

    @Override
    public PassengerCar createCar(Color color,
                                  Model model,
                                  Wheel wheel,
                                  Engine engine,
                                  EnumSet<Option> options,
                                  PassengerCarBodyType passengerCarBodyType
    ) {
        try {
            return new PassengerCar(color,
                    super.getCarTypeOfFactory(),
                    model,
                    CURRENT_YEAR,
                    wheel,
                    engine,
                    options,
                    passengerCarBodyType
            );
        } catch (NotValidArgumentException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public PassengerCar completeOrder(Order order) {
        if (!(order.getParameterOfOrderedCar() instanceof PassengerCarBodyType) || !checkOrder(order)) {
            return null;
        }
        PassengerCar suitableCar = (PassengerCar) stockOfFactory.findCar(order);
        if (suitableCar == null) {
            try {
                suitableCar = new PassengerCar(order.getColorOfOrderedCar(),
                        order.getTypeOfOrderedCar(),
                        order.getModelOfOrderedCar(),
                        CURRENT_YEAR,
                        order.getWheelOfOrderedCar(),
                        order.getEngineOfOrderedCar(),
                        order.getOptionsOfOrderedCar(),
                        (PassengerCarBodyType) order.getParameterOfOrderedCar()
                );
            } catch (NotValidArgumentException e) {
                System.out.println(e);
            }
        } else {
            super.convertCar(suitableCar, order);
        }
        return suitableCar;
    }
}
