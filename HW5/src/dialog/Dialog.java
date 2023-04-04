package dialog;

import factoty.BusFactory;
import factoty.PassengerCarFactoty;
import factoty.TruckFactory;
import showroom.Showroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dialog implements Messages {

    public static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static int readNumber(BufferedReader reader, String errorMessage) {
        while (true) {
            try {
                return Integer.parseInt(readString(reader, errorMessage));
            } catch (NumberFormatException e) {
                printMessage(errorMessage);
            }
        }
    }

    public static String readString(BufferedReader reader, String errorMessage) {
        while (true) {
            try {
                return reader.readLine();
            } catch (IOException e) {
                printMessage(errorMessage);
            }
        }
    }

    public static boolean checkNumber(int number, int min, int max) {
       if (number < min || number > max) {
           printMessage(NOT_VALID_INPUT_MESSAGE.formatted(min, max));
           return false;
       }
       return true;
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMainMenu() {
        printMessage(CHOICE_MESSAGE);
        printMessage(ABOUT_BUS_FACTORY_MESSAGE.formatted(1));
        printMessage(STOCK_BUS_MESSAGE.formatted(2));
        printMessage(ABOUT_PASSENGER_CAR_FACTORY_MESSAGE.formatted(3));
        printMessage(STOCK_PASSENGER_CAR_MESSAGE.formatted(4));
        printMessage(ABOUT_TRUCK_FACTORY_MESSAGE.formatted(5));
        printMessage(STOCK_TRUCK_MESSAGE.formatted(6));
        printMessage(STOCK_SHOWROOM_MESSAGE.formatted(7));
        printMessage(OPERATION_SHOWROOM_MESSAGE.formatted(8));
        printMessage(EXIT_MESSAGE.formatted(9));
    }

    public static void executeMainMenuCommand(
            BusFactory busFactory,
            PassengerCarFactoty passengerCarFactoty,
            TruckFactory truckFactory,
            Showroom showroom
    ) {
        int number = Dialog.readNumber(READER, NOT_NUMBER);
        switch (number) {
            case (1):
                busFactory.printDataAboutFactory();
                printMainMenu();
                break;
            case (2):
                busFactory.printStockOfFactory();
                printMainMenu();
                break;
            case (3):
                passengerCarFactoty.printDataAboutFactory();
                printMainMenu();
                break;
            case (4):
                passengerCarFactoty.printStockOfFactory();
                printMainMenu();
                break;
            case (5):
                truckFactory.printDataAboutFactory();
                printMainMenu();
                break;
            case (6):
                truckFactory.printStockOfFactory();
                printMainMenu();
                break;
            case (7):
                showroom.printStockOfShowroom();
                printMainMenu();
                break;
            case (8):
                printShowroomMenu();
                executeShowroomMenuCommand(busFactory, passengerCarFactoty, truckFactory, showroom);
                break;
            case (9):
                Process.mustContinue = false;
                break;
            default:
                printMessage(NOT_VALID_INPUT_MESSAGE.formatted(1, 9));
                break;
        }
    }

    public static void printShowroomMenu() {
        printMessage(CHOICE_MESSAGE);
        printMessage(MAKE_ORDER_MESSAGE.formatted(1));
        printMessage(CHANGE_COLOR_MESSAGE.formatted(2));
        printMessage(CHANGE_WHEEL_MESSAGE.formatted(3));
        printMessage(CHANGE_OPTION_MESSAGE.formatted(4));
        printMessage(MAIN_MENU_MESSAGE.formatted(5));
    }

    public static void executeShowroomMenuCommand(
            BusFactory busFactory,
            PassengerCarFactoty passengerCarFactoty,
            TruckFactory truckFactory,
            Showroom showroom
    ) {
        int number = Dialog.readNumber(READER, NOT_NUMBER);
        switch (number) {
            case (1):
                OrderCarDialog.executeShowroomMenuCommand(busFactory, passengerCarFactoty, truckFactory, showroom);
                break;
            case (2):
                System.out.println("Sorry. Service is not ready."); //TODO
                printMainMenu();
                break;
            case (3):
                System.out.println("Sorry. Service is not ready."); //TODO
                printMainMenu();
                break;
            case (4):
                System.out.println("Sorry. Service is not ready."); //TODO
                printMainMenu();
                break;
            case (5):
                printMainMenu();
                break;
            default:
                printMessage(NOT_VALID_INPUT_MESSAGE.formatted(1, 5));
                break;
        }
    }
}
