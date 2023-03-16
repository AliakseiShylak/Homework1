import cars.CarUtils;
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

        Showroom multibrandShowroom = new Showroom();

        try {
            BusFactory factoryNeoplan = new BusFactory("Neoplan",
                    TypeOfCar.BUS,
                    CarUtils.getListOfModels(TypeOfCar.BUS),
                    CarUtils.getListOfEngines(TypeOfCar.BUS),
                    CarUtils.getListOfColors(TypeOfCar.BUS),
                    CarUtils.getListOfWheels(TypeOfCar.BUS)
            );
            System.out.println(factoryNeoplan.getDataAboutFactory());
            System.out.println(factoryNeoplan.printStockOfFactory());
        } catch (NotValidArgumentException e) {
            System.out.println(e);
        }

        try {
            TruckFactory factoryScania = new TruckFactory("Scania",
                    TypeOfCar.TRUCK,
                    CarUtils.getListOfModels(TypeOfCar.TRUCK),
                    CarUtils.getListOfEngines(TypeOfCar.TRUCK),
                    CarUtils.getListOfColors(TypeOfCar.TRUCK),
                    CarUtils.getListOfWheels(TypeOfCar.TRUCK));
            System.out.println(factoryScania.getDataAboutFactory());
            System.out.println(factoryScania.printStockOfFactory());
        } catch (NotValidArgumentException e) {
            System.out.println(e);
        }

        try {
            PassengerCarFactoty factoryKia = new PassengerCarFactoty("Kia",
                    TypeOfCar.PASSENGER_CAR,
                    CarUtils.getListOfModels(TypeOfCar.PASSENGER_CAR),
                    CarUtils.getListOfEngines(TypeOfCar.PASSENGER_CAR),
                    CarUtils.getListOfColors(TypeOfCar.PASSENGER_CAR),
                    CarUtils.getListOfWheels(TypeOfCar.PASSENGER_CAR));
            System.out.println(factoryKia.getDataAboutFactory());
            System.out.println(factoryKia.printStockOfFactory());

            //на рандомно сгенерированный склад добавляю пару конкретных машин,
            //чтобы проще было тестировать выполнение заказа
            factoryKia.addCarToStock(factoryKia.createCar(Color.BLACK, Model.KIA_CEED, Wheel.R14, Engine.V1_6,
                    standart, PassengerCarBodyType.UNIVERSAL));
            factoryKia.addCarToStock(factoryKia.createCar(Color.BLACK, Model.KIA_CEED, Wheel.R13, Engine.V1_6,
                    base, PassengerCarBodyType.UNIVERSAL));
            System.out.println(factoryKia.printStockOfFactory());

            Order orderKia = new Order(multibrandShowroom,
                    factoryKia,
                    TypeOfCar.PASSENGER_CAR,
                    Model.KIA_CEED,
                    Color.BLUE,
                    Wheel.R14,
                    Engine.V1_6,
                    premium,
                    PassengerCarBodyType.UNIVERSAL);
            System.out.println("Car was shipped:\n" + factoryKia.completeOrder(orderKia));
            System.out.println(factoryKia.printStockOfFactory());
        } catch (NotValidArgumentException e) {
            System.out.println(e);
        }
    }
}
