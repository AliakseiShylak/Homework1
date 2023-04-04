package stock;

import cars.Car;

import java.util.ArrayList;

public class Stock<T extends Car, S> {
    private final String EMPTY_STOCK = "\n\tThere are not cars in stock.";
    private ArrayList<T> stock;

    public Stock(ArrayList<T> stock) {
        this.stock = stock;
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

    public ArrayList<T> getStock() {
        return stock;
    }

    public String printStock() {
        String str = "";
        if (this.stock.size() == 0 || this.stock == null) {
            return EMPTY_STOCK;
        }
        for (T car : stock) {
            str = str.concat("\n\t" + car.toString());
        }
        return str;
    }
}
