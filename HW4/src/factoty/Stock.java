package factoty;

import cars.Bus;
import cars.Car;
import cars.PassengerCar;
import cars.Truck;
import cars.enums.Engine;
import cars.enums.Model;
import cars.enums.PassengerCarBodyType;
import cars.enums.TypeOfCar;
import showroom.Order;

import java.util.ArrayList;

public class Stock<T extends Car, S> {
    private final String ERROR_STOCK = "There are not cars in stock.";
    private ArrayList<T> stock;

    public Stock(ArrayList<T> stock) {
        this.stock = stock;
    }

    public ArrayList<T> getStock() {
        return stock;
    }

    public boolean addCarToStock(T car) {
        if (car == null) {
            return false;
        }
        return stock.add(car);
    }

    public boolean deleteCar(T car) {
        return stock.remove(car);
    }

    public T findCar(Order order) {
        T convertibleCar = null;
        for (T currentCar : stock) {
            if (Factory.isCarConvertible(currentCar,
                    order.getTypeOfOrderedCar(),
                    order.getModelOfOrderedCar(),
                    order.getEngineOfOrderedCar(),
                    order.getParameterOfOrderedCar())
            ) {
                convertibleCar = currentCar;
                if (currentCar.getColor().equals(order.getColorOfOrderedCar())
                        && currentCar.getWheel().equals(order.getWheelOfOrderedCar())
                        && currentCar.getOptions().equals(order.getOptionsOfOrderedCar())
                ) {
                    deleteCar(currentCar);
                    return currentCar;
                }
            }
        }
        deleteCar(convertibleCar);
        return convertibleCar;
    }

    public String printStock() {
        String str = "";
        if (this.stock.size() == 0 || this.stock == null) {
            return ERROR_STOCK;
        }
        for (T car : stock) {
            str = str.concat(car.toString() + "\n");
        }
        return str;
    }
}
