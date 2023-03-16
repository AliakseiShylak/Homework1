package factoty;

import cars.Bus;
import cars.Truck;
import cars.enums.*;
import exceptions.NotValidArgumentException;
import showroom.Order;

import java.util.ArrayList;
import java.util.EnumSet;

public class TruckFactory extends Factory implements GeneralizedForFactory<Truck, TruckLoadCapacity> {
    public TruckFactory(String nameOfFactory,
                        TypeOfCar carTypeOfFactory,
                        ArrayList<Model> modelsOfFactory,
                        ArrayList<Engine> setOfEngines,
                        ArrayList<Color> setOfColors,
                        ArrayList<Wheel> setOfWheels
    ) throws NotValidArgumentException {
        super(nameOfFactory, carTypeOfFactory, modelsOfFactory, setOfEngines, setOfColors, setOfWheels);
    }

    @Override
    public Truck createCar(Color color,
                           Model model,
                           Wheel wheel,
                           Engine engine,
                           EnumSet<Option> options,
                           TruckLoadCapacity truckLoadCapacity
    ) {
        try {
            return new Truck(color,
                    super.getCarTypeOfFactory(),
                    model,
                    CURRENT_YEAR,
                    wheel,
                    engine,
                    options,
                    truckLoadCapacity
            );
        } catch (NotValidArgumentException e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Truck completeOrder(Order order) {
        if (!(order.getParameterOfOrderedCar() instanceof TruckLoadCapacity) || !checkOrder(order)) {
            return null;
        }
        Truck suitableCar = (Truck) stockOfFactory.findCar(order);
        if (suitableCar == null) {
            try {
                suitableCar = new Truck(order.getColorOfOrderedCar(),
                        order.getTypeOfOrderedCar(),
                        order.getModelOfOrderedCar(),
                        CURRENT_YEAR,
                        order.getWheelOfOrderedCar(),
                        order.getEngineOfOrderedCar(),
                        order.getOptionsOfOrderedCar(),
                        (TruckLoadCapacity) order.getParameterOfOrderedCar()
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
