package showroom;

import carparameters.Color;
import carparameters.Wheel;
import cars.Car;
import carparameters.Option;
import factoty.BusFactory;
import factoty.PassengerCarFactoty;
import factoty.TruckFactory;
import order.BusOrder;
import order.PassengerCarOrder;
import order.TruckOrder;
import services.ChangeColorService;
import services.ChangeWheelService;
import services.OptionService;
import stock.Stock;

import java.awt.*;
import java.util.*;

public class Showroom {
    private final String nameOfShowroom;
    private final ChangeColorService changeColorServiceOfShowroom;
    private final ChangeWheelService changeWheelServiceOfShowroom;
    private final OptionService optionServiceOfShowroom;
    private final Stock stockOfShowroom;
    private final BusFactory busFactory;
    private final PassengerCarFactoty passengerCarFactoty;
    private final TruckFactory truckFactory;


    public Showroom(
            String nameOfShowroom,
            BusFactory busFactory,
            PassengerCarFactoty passengerCarFactoty,
            TruckFactory truckFactory
    ) {
        this.nameOfShowroom = nameOfShowroom;
        this.changeColorServiceOfShowroom = new ChangeColorService();
        this.changeWheelServiceOfShowroom = new ChangeWheelService();
        this.optionServiceOfShowroom = new OptionService();
        this.stockOfShowroom = new Stock(new ArrayList());
        this.busFactory = busFactory;
        this.passengerCarFactoty = passengerCarFactoty;
        this.truckFactory = truckFactory;
    }

    public void printStockOfShowroom() {
        System.out.println("\nStock of showroom \"" + this.nameOfShowroom + ":" + this.stockOfShowroom.printStock());
    }

    public  <T extends Car> boolean addCarToStock(T car) {
        return stockOfShowroom.addCarToStock(car);
    }

   public <T extends Car> ArrayList<T> getStock() {
       return stockOfShowroom.getStock();
   }


   public boolean orderBus(BusOrder order) {
        return stockOfShowroom.addCarToStock(busFactory.completeOrder(order));
   }

    public boolean orderPassengerCar(PassengerCarOrder order) {
        return stockOfShowroom.addCarToStock(passengerCarFactoty.completeOrder(order));
    }

    public boolean orderTruck(TruckOrder order) {
        return stockOfShowroom.addCarToStock(truckFactory.completeOrder(order));
    }

    public <T extends Car> T changeColor(T car, Color newColor) {
        changeColorServiceOfShowroom.changeColor(car, newColor);
        return car;
    }

    public <T extends Car> T changeWheels(T car, Wheel newWheel) {
        changeWheelServiceOfShowroom.changeWheel(car, newWheel);
        return car;
    }

    public <T extends Car> T addOption(T car, Option option) {
        optionServiceOfShowroom.addOption(car, option);
        return car;
    }

    public <T extends Car> T deleteOption(T car, Option option) {
        optionServiceOfShowroom.deleteOption(car, option);
        return car;
    }

    public <T extends Car> T setOptions(T car, EnumSet<Option> options) {
        optionServiceOfShowroom.setOptions(car, options);
        return car;
    }


}
