package dialog;

import carparameters.*;
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

import java.util.ArrayList;
import java.util.EnumSet;

public class OrderCarDialog<T> implements Messages {

    //   private static ArrayList<Model> models = new ArrayList<>();
//    private static ArrayList<Color> colors = new ArrayList<>();
//    private static ArrayList<Wheel> wheels = new ArrayList<>();
//    private static ArrayList<Engine> engines = new ArrayList<>();
//    private static ArrayList<IndividualParameter> parameters = new ArrayList<>();
//    private static TypeOfCar typeOfCar;
//    public static ArrayList<EnumSet<Option>> complectation = new ArrayList<>();

    public static void executeShowroomMenuCommand(
            BusFactory busFactory,
            PassengerCarFactoty passengerCarFactoty,
            TruckFactory truckFactory,
            Showroom showroom
    ) {
        ArrayList<Model> models = new ArrayList<>();
        ArrayList<Color> colors = new ArrayList<>();
        ArrayList<Wheel> wheels = new ArrayList<>();
        ArrayList<Engine> engines = new ArrayList<>();
        ArrayList<IndividualParameter> parameters = new ArrayList<>();
        TypeOfCar typeOfCar;
        ArrayList<EnumSet<Option>> complectation = new ArrayList<>();

        Dialog.printMessage(Messages.TYPE_OF_CAR_MESSAGE.formatted(
                        1, TypeOfCar.BUS,
                        2, TypeOfCar.PASSENGER_CAR,
                        3, TypeOfCar.TRUCK
                )
        );
        int typeCarNumber;
        while (true) {
            typeCarNumber = Dialog.readNumber(Dialog.READER, NOT_NUMBER);
            if (Dialog.checkNumber(typeCarNumber, 1, 3)) {
                break;
            }
        }
        switch (typeCarNumber) {
            case (1):
                typeOfCar = TypeOfCar.BUS;
                models.addAll(BusModel.getListOfModels());
                colors.addAll(BusColor.getListOfColors());
                wheels.addAll(BusWheel.getListOfWheels());
                engines.addAll(BusEngine.getListOfEngines());
                parameters.addAll(BusPassengerCapacity.getListOfBusPassengerCapacities());
                break;
            case (2):
                typeOfCar = TypeOfCar.PASSENGER_CAR;
                models.addAll(PassengerCarModel.getListOfModels());
                colors.addAll(PassengerCarColor.getListOfColors());
                wheels.addAll(PassengerCarWheel.getListOfWheels());
                engines.addAll(PassengerCarEngine.getListOfEngines());
                parameters.addAll(PassengerCarBodyType.getListOfPassengerCarBodyTypes());
                break;
            case (3):
                typeOfCar = TypeOfCar.TRUCK;
                models.addAll(TruckModel.getListOfModels());
                colors.addAll(TruckColor.getListOfColors());
                wheels.addAll(TruckWheel.getListOfWheels());
                engines.addAll(TruckEngine.getListOfEngines());
                parameters.addAll(TruckLoadCapacity.getListOfTruckLoadCapacities());
                break;
            default:
                break;
        }

        System.out.println("Choose model:");
        for (int i = 0; i < models.size(); i++) {
            System.out.println(i + 1 + " - " + models.get(i));
        }
        int modelNumber;
        while (true) {
            modelNumber = Dialog.readNumber(Dialog.READER, NOT_NUMBER);
            if (Dialog.checkNumber(modelNumber, 1, models.size())) {
                break;
            }
        }
        modelNumber--;

        System.out.println("Choose color:");
        for (int i = 0; i < colors.size(); i++) {
            System.out.println(i + 1 + " - " + colors.get(i));
        }
        int colorNumber;
        while (true) {
            colorNumber = Dialog.readNumber(Dialog.READER, NOT_NUMBER);
            if (Dialog.checkNumber(colorNumber, 1, colors.size())) {
                break;
            }
        }
        colorNumber--;

        System.out.println("Choose size of wheels:");
        for (int i = 0; i < wheels.size(); i++) {
            System.out.println(i + 1 + " - " + wheels.get(i));
        }
        int wheelNumber;
        while (true) {
            wheelNumber = Dialog.readNumber(Dialog.READER, NOT_NUMBER);
            if (Dialog.checkNumber(wheelNumber, 1, wheels.size())) {
                break;
            }
        }
        wheelNumber--;

        System.out.println("Choose engine:");
        for (int i = 0; i < engines.size(); i++) {
            System.out.println(i + 1 + " - " + engines.get(i));
        }
        int engineNumber;
        while (true) {
            engineNumber = Dialog.readNumber(Dialog.READER, NOT_NUMBER);
            if (Dialog.checkNumber(engineNumber, 1, engines.size())) {
                break;
            }
        }
        engineNumber--;

        //TODO Нужно исправить, чтобы можно было выбирать любую комбинацию опций
        complectation.add(Process.base);
        complectation.add(Process.standart);
        complectation.add(Process.premium);
        System.out.println("Choose complectation (sot of options):");
        for (int i = 0; i < complectation.size(); i++) {
            System.out.println(i + 1 + " - " + complectation.get(i));
        }
        int complectationNumber;
        while (true) {
            complectationNumber = Dialog.readNumber(Dialog.READER, NOT_NUMBER);
            if (Dialog.checkNumber(complectationNumber, 1, complectation.size())) {
                break;
            }
        }
        complectationNumber--;

        System.out.println("Choose parameter:");
        for (int i = 0; i < parameters.size(); i++) {
            System.out.println(i + 1 + " - " + parameters.get(i));
        }
        int parameterNumber;
        while (true) {
            parameterNumber = Dialog.readNumber(Dialog.READER, NOT_NUMBER);
            if (Dialog.checkNumber(parameterNumber, 1, parameters.size())) {
                break;
            }
        }
        parameterNumber--;

        switch (typeCarNumber) {
            case (1):
                BusOrder busOrder = new BusOrder(
                        (BusModel) models.get(modelNumber),
                        (BusColor) colors.get(colorNumber),
                        (BusWheel) wheels.get(wheelNumber),
                        (BusEngine) engines.get(engineNumber),
                        complectation.get(complectationNumber),
                        (BusPassengerCapacity) parameters.get(parameterNumber)
                );
                showroom.orderBus(busOrder);
                busFactory.completeOrder(busOrder);
                break;
            case (2):
                PassengerCarOrder passengerCarOrder = new PassengerCarOrder(
                        (PassengerCarModel) models.get(modelNumber),
                        (PassengerCarColor) colors.get(colorNumber),
                        (PassengerCarWheel) wheels.get(wheelNumber),
                        (PassengerCarEngine) engines.get(engineNumber),
                        complectation.get(complectationNumber),
                        (PassengerCarBodyType) parameters.get(parameterNumber)
                );
                showroom.orderPassengerCar(passengerCarOrder);
                passengerCarFactoty.completeOrder(passengerCarOrder);
                break;
            case (3):
                TruckOrder truckOrder = new TruckOrder(
                        (TruckModel) models.get(modelNumber),
                        (TruckColor) colors.get(colorNumber),
                        (TruckWheel) wheels.get(wheelNumber),
                        (TruckEngine) engines.get(engineNumber),
                        complectation.get(complectationNumber),
                        (TruckLoadCapacity) parameters.get(parameterNumber)
                );
                showroom.orderTruck(truckOrder);
                truckFactory.completeOrder(truckOrder);
                break;
            default:
                break;
        }

        System.out.println("Order completed. Car delivered from factory to stock of showroom");
        Dialog.printMainMenu();
        Dialog.executeMainMenuCommand(busFactory, passengerCarFactoty, truckFactory, showroom);
    }
}
