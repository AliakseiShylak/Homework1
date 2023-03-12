package factoty;

import cars.Car;

import java.util.ArrayList;

public class Stock<T extends Car> {
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

    public boolean findCar(T car) {
        return stock.contains(car);
    }
/*
    public T findConvertibleCar(T car) {
        T suitableCar = null;
        for (T currentCar : stock) {
            if (currentCar.convertibleCar(car)) {
                suitableCar = currentCar;
                break;
            }
        }
        return suitableCar;
    }
*/

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
