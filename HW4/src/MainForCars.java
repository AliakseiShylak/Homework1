import carparameters.Option;
import carparameters.busenums.*;
import carparameters.passengercarenums.*;
import carparameters.truckenums.*;
import cars.PassengerCar;
import factoty.BusFactory;
import factoty.PassengerCarFactoty;
import factoty.TruckFactory;
import order.BusOrder;
import order.PassengerCarOrder;
import order.TruckOrder;
import showroom.Showroom;
import utils.Generator;

import java.util.EnumSet;

public class MainForCars {
    public static void main(String[] args) {
        EnumSet<Option> base = null;
        EnumSet<Option> standart = EnumSet.of(Option.ABS, Option.CONDITIONER);
        EnumSet<Option> premium = EnumSet.of(Option.ABS, Option.CONDITIONER, Option.CRUISE_CONTROL, Option.HEATED_SEATS);

// Создание завода с некоторым запасом автобусов на складе
        BusFactory factoryNeoplan = new BusFactory(
                "Neoplan",
                BusModel.getListOfModels(),
                BusEngine.getListOfEngines(),
                BusColor.getListOfColors(),
                BusWheel.getListOfWheels(),
                5
        );
        factoryNeoplan.printDataAboutFactory();
        factoryNeoplan.printStockOfFactory();

// Создание завода с некоторым запасом грузовиков на складе
        TruckFactory factoryScania = new TruckFactory(
                "Scania",
                TruckModel.getListOfModels(),
                TruckEngine.getListOfEngines(),
                TruckColor.getListOfColors(),
                TruckWheel.getListOfWheels(),
                5
        );
        factoryScania.printDataAboutFactory();
        factoryScania.printStockOfFactory();

// Создание завода с некоторым запасом легковых автомобилей на складе
        PassengerCarFactoty factoryKia = new PassengerCarFactoty(
                "Kia",
                PassengerCarModel.getListOfModels(),
                PassengerCarEngine.getListOfEngines(),
                PassengerCarColor.getListOfColors(),
                PassengerCarWheel.getListOfWheels(),
                10
        );
        factoryKia.printDataAboutFactory();
        factoryKia.printStockOfFactory();

// Создание автосалона
        Showroom multibrandShowroom = new Showroom("KiNeSca", factoryNeoplan, factoryKia, factoryScania);
        multibrandShowroom.printStockOfShowroom();

// Выполнение заказа автосалона на автобусы
        for (int i = 0; i < 5; i++) {
            multibrandShowroom.orderBus(
                    new BusOrder(
                            Generator.generateRandomParameter(BusModel.values()),
                            Generator.generateRandomParameter(BusColor.values()),
                            Generator.generateRandomParameter(BusWheel.values()),
                            Generator.generateRandomParameter(BusEngine.values()),
                            Generator.generateRandomOptions(),
                            Generator.generateRandomParameter(BusPassengerCapacity.values())
                    )
            );
        }
// Остаток на складе завода после выполнения заказа
        factoryNeoplan.printStockOfFactory();
// Остаток на складе автосолона после выполнения заказа автозаводом
        multibrandShowroom.printStockOfShowroom();

// Выполнение заказа автосалона на грузовики
        for (int i = 0; i < 5; i++) {
            multibrandShowroom.orderTruck(
                    new TruckOrder(
                            Generator.generateRandomParameter(TruckModel.values()),
                            Generator.generateRandomParameter(TruckColor.values()),
                            Generator.generateRandomParameter(TruckWheel.values()),
                            Generator.generateRandomParameter(TruckEngine.values()),
                            Generator.generateRandomOptions(),
                            Generator.generateRandomParameter(TruckLoadCapacity.values())
                    )
            );
        }
// Остаток на складе завода после выполнения заказа
        factoryScania.printStockOfFactory();
// Остаток на складе автосолона после выполнения заказа автозаводом
        multibrandShowroom.printStockOfShowroom();

// Выполнение заказа автосалона на егковые автомобили
        for (int i = 0; i < 5; i++) {
            multibrandShowroom.orderPassengerCar(
                    new PassengerCarOrder(
                            Generator.generateRandomParameter(PassengerCarModel.values()),
                            Generator.generateRandomParameter(PassengerCarColor.values()),
                            Generator.generateRandomParameter(PassengerCarWheel.values()),
                            Generator.generateRandomParameter(PassengerCarEngine.values()),
                            Generator.generateRandomOptions(),
                            Generator.generateRandomParameter(PassengerCarBodyType.values())
                    )
            );
        }
// Остаток на складе завода после выполнения заказа
        factoryKia.printStockOfFactory();
// Остаток на складе автосолона после выполнения заказа автозаводом
        multibrandShowroom.printStockOfShowroom();

//Демонстрация работы сервиса автосалона
        PassengerCar carToChange = (PassengerCar) multibrandShowroom
                .getStock().get(multibrandShowroom.getStock().size() - 1);
        System.out.println("\nDemonstration of work of showroom service.\nCar before modification:\n\t" + carToChange);
        multibrandShowroom.changeColor(carToChange, PassengerCarColor.ORANGE);
        multibrandShowroom.changeWheels(carToChange, PassengerCarWheel.R13);
        multibrandShowroom.setOptions(carToChange, standart);
        multibrandShowroom.addOption(carToChange, Option.CRUISE_CONTROL);
        multibrandShowroom.deleteOption(carToChange, Option.ABS);
        System.out.println("Car after modification:\n\t"
                + multibrandShowroom.getStock().get(multibrandShowroom.getStock().size() - 1));

    }
}
