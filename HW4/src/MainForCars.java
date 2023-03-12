import cars.Bus;
import cars.CarUtils;
import cars.PassengerCar;
import cars.Truck;
import cars.enums.*;
import exceptions.NotValidArgumentException;
import factoty.Factory;
import services.ChangeService;
import services.OptionService;
import factoty.Stock;

import java.util.ArrayList;
import java.util.EnumSet;

public class MainForCars {
    public static void main(String[] args) {
        EnumSet<Option> base = null;
        EnumSet<Option> standart = EnumSet.of(Option.ABS, Option.CONDITIONER);
        EnumSet<Option> premium = EnumSet.of(Option.ABS, Option.CONDITIONER, Option.CRUISE_CONTROL, Option.HEATED_SEATS);

        Stock stockOfFactoryNeoplan = new Stock(new ArrayList<>());
        CarUtils.generateRandomCars(TypeOfCar.BUS, stockOfFactoryNeoplan, 10);
        try {
            Factory factoryNeoplan = new Factory("Neoplan",
                    TypeOfCar.BUS,
                    CarUtils.getListOfModels(TypeOfCar.BUS),
                    CarUtils.getListOfEngines(TypeOfCar.BUS),
                    CarUtils.getListOfColors(TypeOfCar.BUS),
                    CarUtils.getListOfWheels(TypeOfCar.BUS),
                    stockOfFactoryNeoplan);
            System.out.println(factoryNeoplan.getDataAboutFactory());
            System.out.println(factoryNeoplan.getStockOfFactory());
        } catch (NotValidArgumentException e) {
            System.out.println(e);
        }

        Stock stockOfFactoryScania = new Stock(new ArrayList<>());
        CarUtils.generateRandomCars(TypeOfCar.TRUCK, stockOfFactoryScania, 10);
        try {
            Factory factoryScania = new Factory("Scania",
                    TypeOfCar.TRUCK,
                    CarUtils.getListOfModels(TypeOfCar.TRUCK),
                    CarUtils.getListOfEngines(TypeOfCar.TRUCK),
                    CarUtils.getListOfColors(TypeOfCar.TRUCK),
                    CarUtils.getListOfWheels(TypeOfCar.TRUCK),
                    stockOfFactoryScania);
            System.out.println(factoryScania.getDataAboutFactory());
            System.out.println(factoryScania.getStockOfFactory());
        } catch (NotValidArgumentException e) {
            System.out.println(e);
        }

        Stock stockOfFactoryKia = new Stock(new ArrayList<>());
        CarUtils.generateRandomCars(TypeOfCar.PASSENGER_CAR, stockOfFactoryKia, 0);
        try {
            Factory factoryKia = new Factory("Kia",
                    TypeOfCar.PASSENGER_CAR,
                    CarUtils.getListOfModels(TypeOfCar.PASSENGER_CAR),
                    CarUtils.getListOfEngines(TypeOfCar.PASSENGER_CAR),
                    CarUtils.getListOfColors(TypeOfCar.PASSENGER_CAR),
                    CarUtils.getListOfWheels(TypeOfCar.PASSENGER_CAR),
                    stockOfFactoryKia);
            System.out.println(factoryKia.getDataAboutFactory());
            System.out.println(factoryKia.getStockOfFactory());

            PassengerCar newCar = factoryKia.createCar(Color.BLACK, Model.KIA_CEED, Wheel.R14, Engine.V1_6,
                    standart, PassengerCarBodyType.UNIVERSAL);
            factoryKia.addCarToStock(newCar);
            System.out.println(factoryKia.getStockOfFactory());
        } catch (NotValidArgumentException e) {
            System.out.println(e);
        }

















       /*
        try {
            Truck truck = new Truck(Color.GRAY, TypeOfCar.TRUCK, Model.SCANIA_S730, 2023,
                    Wheel.R23, Engine.V6_5, TruckLoadCapacity.TONS_22);

            System.out.println(truck);

            ChangeService.change(truck, Color.WHITE);
            ChangeService.change(truck, Wheel.R20);
            OptionService.addOption(truck, Option.CRUISE_CONTROL);
            System.out.println(truck);

            OptionService.deleteOption(truck, Option.ABS);
            System.out.println(truck);

            OptionService.setOptions(truck, premium);
            System.out.println(truck);
        } catch (NotValidArgumentException e) {
            System.out.println(e);
        }

        try {
            Bus bus = new Bus(Color.YELLOW, TypeOfCar.BUS, Model.NEOPLAN_EUROLINER, 2022,
                    Wheel.R22, Engine.V5_0, standart, BusPassengerCapacity.SEATS_50);

            System.out.println(bus);

            ChangeService.change(bus, Color.WHITE);
            ChangeService.change(bus, Wheel.R20);
            OptionService.addOption(bus, Option.CRUISE_CONTROL);
            System.out.println(bus);

            OptionService.deleteOption(bus, Option.ABS);
            System.out.println(bus);

            OptionService.setOptions(bus, standart);
            System.out.println(bus);


        } catch (NotValidArgumentException e) {
            System.out.println(e);
        }

        try {
            PassengerCar car = new PassengerCar(Color.BLACK, TypeOfCar.PASSENGER_CAR, Model.KIA_CEED, 2020,
                    Wheel.R14, Engine.V1_6, premium, PassengerCarBodyType.UNIVERSAL);

            System.out.println(car);

            ChangeService.change(car, Color.WHITE);
            ChangeService.change(car, Wheel.R20);
            OptionService.addOption(car, Option.CRUISE_CONTROL);
            System.out.println(car);

            OptionService.deleteOption(car, Option.ABS);
            System.out.println(car);

            OptionService.setOptions(car, standart);
            System.out.println(car);


        } catch (NotValidArgumentException e) {
            System.out.println(e);
        }

*/

    }
}
