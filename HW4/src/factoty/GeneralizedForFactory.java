package factoty;

import cars.Car;
import cars.enums.*;
import showroom.Order;

import java.util.EnumSet;

public interface GeneralizedForFactory<T extends Car, S> {
    T createCar(Color color,
                Model model,
                Wheel wheel,
                Engine engine,
                EnumSet<Option> options,
                S carFarameter);

    T completeOrder(Order order);
}