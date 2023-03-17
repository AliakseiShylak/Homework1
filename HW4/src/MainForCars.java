import cars.CarUtils;
import cars.PassengerCar;
import cars.enums.*;
import exceptions.NotValidArgumentException;
import factoty.BusFactory;
import factoty.Factory;
import factoty.PassengerCarFactoty;
import factoty.TruckFactory;
import showroom.Order;
import showroom.Showroom;

import java.util.EnumSet;

public class MainForCars {
    public static void main(String[] args) {
        EnumSet<Option> base = null;
        EnumSet<Option> standart = EnumSet.of(Option.ABS, Option.CONDITIONER);
        EnumSet<Option> premium = EnumSet.of(Option.ABS, Option.CONDITIONER, Option.CRUISE_CONTROL, Option.HEATED_SEATS);

        Showroom multibrandShowroom = new Showroom("KiNeSca");
        System.out.println(multibrandShowroom.printStockOfShowroom());

        try {
// создание завода с некоторым запасом автобусов на складе
            BusFactory factoryNeoplan = new BusFactory("Neoplan",
                    TypeOfCar.BUS,
                    CarUtils.getListOfModels(TypeOfCar.BUS),
                    CarUtils.getListOfEngines(TypeOfCar.BUS),
                    CarUtils.getListOfColors(TypeOfCar.BUS),
                    CarUtils.getListOfWheels(TypeOfCar.BUS)
            );
            System.out.println(factoryNeoplan.getDataAboutFactory());
            System.out.println(factoryNeoplan.printStockOfFactory());

// Выполнение заказа автосалона
            for (int i = 0; i < 10; i++) {
                multibrandShowroom.orderCar(factoryNeoplan, new Order(
                        TypeOfCar.BUS,
                        CarUtils.generateRandomModel(TypeOfCar.BUS),
                        CarUtils.generateRandomColor(TypeOfCar.BUS),
                        CarUtils.generateRandomWheel(TypeOfCar.BUS),
                        CarUtils.generateRandomEngine(TypeOfCar.BUS),
                        CarUtils.generateRandomOptions(),
                        CarUtils.generateRandomBusPassengerCapacity()
                ));
            }
// Остаток на складе завода после выполнения заказа
            System.out.println(factoryNeoplan.printStockOfFactory());
        } catch (NotValidArgumentException e) {
            System.out.println(e);
        }
// Остаток на складе автосолона после выполнения заказа автозаводом
        System.out.println(multibrandShowroom.printStockOfShowroom());

        try {
// создание завода с некоторым запасом грузовиков на складе
            TruckFactory factoryScania = new TruckFactory("Scania",
                    TypeOfCar.TRUCK,
                    CarUtils.getListOfModels(TypeOfCar.TRUCK),
                    CarUtils.getListOfEngines(TypeOfCar.TRUCK),
                    CarUtils.getListOfColors(TypeOfCar.TRUCK),
                    CarUtils.getListOfWheels(TypeOfCar.TRUCK));
            System.out.println(factoryScania.getDataAboutFactory());
            System.out.println(factoryScania.printStockOfFactory());

// Выполнение заказа автосалона
            for (int i = 0; i < 6; i++) {
                multibrandShowroom.orderCar(factoryScania, new Order(
                        TypeOfCar.TRUCK,
                        CarUtils.generateRandomModel(TypeOfCar.TRUCK),
                        CarUtils.generateRandomColor(TypeOfCar.TRUCK),
                        CarUtils.generateRandomWheel(TypeOfCar.TRUCK),
                        CarUtils.generateRandomEngine(TypeOfCar.TRUCK),
                        CarUtils.generateRandomOptions(),
                        CarUtils.generateRandomTruckLoadCapacity()
                ));
            }
// Остаток на складе завода после выполнения заказа
            System.out.println(factoryScania.printStockOfFactory());
        } catch (NotValidArgumentException e) {
            System.out.println(e);
        }
// Остаток на складе автосолона после выполнения заказа автозаводом
        System.out.println(multibrandShowroom.printStockOfShowroom());

        try {
// создание завода с некоторым запасом легковых автомобилей на складе
            PassengerCarFactoty factoryKia = new PassengerCarFactoty("Kia",
                    TypeOfCar.PASSENGER_CAR,
                    CarUtils.getListOfModels(TypeOfCar.PASSENGER_CAR),
                    CarUtils.getListOfEngines(TypeOfCar.PASSENGER_CAR),
                    CarUtils.getListOfColors(TypeOfCar.PASSENGER_CAR),
                    CarUtils.getListOfWheels(TypeOfCar.PASSENGER_CAR));
            System.out.println(factoryKia.getDataAboutFactory());
            System.out.println(factoryKia.printStockOfFactory());

// Выполнение заказа автосалона
            for (int i = 0; i < 12; i++) {
                multibrandShowroom.orderCar(factoryKia, new Order(
                        TypeOfCar.PASSENGER_CAR,
                        CarUtils.generateRandomModel(TypeOfCar.PASSENGER_CAR),
                        CarUtils.generateRandomColor(TypeOfCar.PASSENGER_CAR),
                        CarUtils.generateRandomWheel(TypeOfCar.PASSENGER_CAR),
                        CarUtils.generateRandomEngine(TypeOfCar.PASSENGER_CAR),
                        CarUtils.generateRandomOptions(),
                        CarUtils.generateRandomPassengerCarBodyType()
                ));
            }
// Остаток на складе завода после выполнения заказа
            System.out.println(factoryKia.printStockOfFactory());
        } catch (NotValidArgumentException e) {
            System.out.println(e);
        }

// Остаток на складе автосолона после выполнения заказа автозаводом
        System.out.println(multibrandShowroom.printStockOfShowroom());

        //Демонстрация работы сервиса автосалона
        try {
            PassengerCar carToChange = new PassengerCar(Color.BLUE,
                    TypeOfCar.PASSENGER_CAR,
                    Model.KIA_RIO,
                    2014,
                    Wheel.R13,
                    Engine.V1_4,
                    PassengerCarBodyType.SEDAN
            );
            System.out.println("\nDemonstration of work of showroom service.\nCar before modification:\n\t" + carToChange);
            multibrandShowroom.changeColor(carToChange, Color.ORANGE);
            multibrandShowroom.changeWheels(carToChange, Wheel.R14);
            multibrandShowroom.setOptions(carToChange, standart);
            multibrandShowroom.addOption(carToChange, Option.CRUISE_CONTROL);
            multibrandShowroom.deleteOption(carToChange, Option.ABS);
            System.out.println("Car after modification:\n\t" + carToChange);
        } catch (NotValidArgumentException e) {
            System.out.println(e);
        }

    }
}
