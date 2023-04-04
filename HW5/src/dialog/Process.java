package dialog;

import carparameters.Option;
import carparameters.busenums.BusColor;
import carparameters.busenums.BusEngine;
import carparameters.busenums.BusModel;
import carparameters.busenums.BusWheel;
import carparameters.passengercarenums.PassengerCarColor;
import carparameters.passengercarenums.PassengerCarEngine;
import carparameters.passengercarenums.PassengerCarModel;
import carparameters.passengercarenums.PassengerCarWheel;
import carparameters.truckenums.TruckColor;
import carparameters.truckenums.TruckEngine;
import carparameters.truckenums.TruckModel;
import carparameters.truckenums.TruckWheel;
import factoty.BusFactory;
import factoty.PassengerCarFactoty;
import factoty.TruckFactory;
import showroom.Showroom;

import java.util.EnumSet;

public class Process {
    public static boolean mustContinue = true;
    private BusFactory factoryNeoplan = new BusFactory(
            "Neoplan",
            BusModel.getListOfModels(),
            BusEngine.getListOfEngines(),
            BusColor.getListOfColors(),
            BusWheel.getListOfWheels(),
            5
    );
    private PassengerCarFactoty factoryKia = new PassengerCarFactoty(
            "Kia",
            PassengerCarModel.getListOfModels(),
            PassengerCarEngine.getListOfEngines(),
            PassengerCarColor.getListOfColors(),
            PassengerCarWheel.getListOfWheels(),
            5
    );
    private TruckFactory factoryScania = new TruckFactory(
            "Scania",
            TruckModel.getListOfModels(),
            TruckEngine.getListOfEngines(),
            TruckColor.getListOfColors(),
            TruckWheel.getListOfWheels(),
            5
    );
    private Showroom multibrandShowroom = new Showroom(
            "KiNeSca",
            factoryNeoplan,
            factoryKia,
            factoryScania
    );
    public static EnumSet<Option> base = null;
    public static EnumSet<Option> standart = EnumSet.of(Option.ABS, Option.CONDITIONER);
    public static EnumSet<Option> premium = EnumSet.of(Option.ABS, Option.CONDITIONER, Option.CRUISE_CONTROL, Option.HEATED_SEATS);

    public void start() {
        Dialog.printMainMenu();
        while (mustContinue) {
            Dialog.executeMainMenuCommand(factoryNeoplan, factoryKia, factoryScania, multibrandShowroom);
        }
    }
}
