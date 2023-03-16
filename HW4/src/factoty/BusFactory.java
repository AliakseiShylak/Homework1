package factoty;

import cars.Bus;
import cars.PassengerCar;
import cars.enums.BusPassengerCapacity;
import cars.enums.*;
import exceptions.NotValidArgumentException;
import showroom.Order;

import java.util.ArrayList;
import java.util.EnumSet;

public class BusFactory extends Factory implements GeneralizedForFactory<Bus, BusPassengerCapacity> {
    public BusFactory(String nameOfFactory,
                      TypeOfCar carTypeOfFactory,
                      ArrayList<Model> modelsOfFactory,
                      ArrayList<Engine> setOfEngines,
                      ArrayList<Color> setOfColors,
                      ArrayList<Wheel> setOfWheels
    ) throws NotValidArgumentException {
        super(nameOfFactory, carTypeOfFactory, modelsOfFactory, setOfEngines, setOfColors, setOfWheels);
    }

    @Override
    public Bus createCar(Color color,
                         Model model,
                         Wheel wheel,
                         Engine engine,
                         EnumSet<Option> options,
                         BusPassengerCapacity busPassengerCapacity
    ) {
        try {
            return new Bus(color,
                    super.getCarTypeOfFactory(),
                    model,
                    CURRENT_YEAR,
                    wheel,
                    engine,
                    options,
                    busPassengerCapacity
            );
        } catch (NotValidArgumentException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Bus completeOrder(Order order) {
        if (!(order.getParameterOfOrderedCar() instanceof BusPassengerCapacity) || !checkOrder(order)) {
            return null;
        }
        Bus suitableCar = (Bus) stockOfFactory.findCar(order);
        if (suitableCar == null) {
            try {
                suitableCar = new Bus(order.getColorOfOrderedCar(),
                        order.getTypeOfOrderedCar(),
                        order.getModelOfOrderedCar(),
                        CURRENT_YEAR,
                        order.getWheelOfOrderedCar(),
                        order.getEngineOfOrderedCar(),
                        order.getOptionsOfOrderedCar(),
                        (BusPassengerCapacity) order.getParameterOfOrderedCar()
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