package CarTask;

import java.util.ArrayList;

public class Stock {
    private ArrayList<Car> stock;

    public Stock(ArrayList<Car> stock) {
        this.stock = stock;
    }

    public ArrayList<Car> getStock() {
        return stock;
    }

    public String printStock() {
        String str;
        if (this.stock.size() == 0 || this.stock == null) {
            str = "There are not cars in stock.";
            return str;
        }
        str = "\n";
        for (Car car : stock) {
            str = str.concat(car.toString());
        }
        return str;
    }

    public boolean addCarToStock(Car car) {
        return stock.add(car);
    }

    public boolean deleteCar(Car car) {
        return stock.remove(car);
    }

    public boolean findCar(Car car) {
        return stock.contains(car);
    }

    public Car findConvertibleCar(Car car) {
        Car suitableCar = null;
        for (Car currentCar : stock) {
            if (currentCar.convertibleCar(car)) {
                suitableCar = currentCar;
                break;
            }
        }
        return suitableCar;
    }
}
