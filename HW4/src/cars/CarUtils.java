package cars;

import cars.enums.*;
import exceptions.NotValidArgumentException;
import factoty.Stock;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;

public class CarUtils<T extends Car> {
    private final static Random RANDOM = new Random();

    public static boolean isParameterForThisTypeOfCar(TypeOfCar typeOfCar, Color color, Model model,
                                                      Wheel wheel, Engine engine) {
        if (typeOfCar.equals(color.getTypeOfCar()) &&
                typeOfCar.equals(model.getTypeOfCar()) &&
                typeOfCar.equals(wheel.getTypeOfCar()) &&
                typeOfCar.equals(engine.getTypeOfCar())
        ) {
            return true;
        }
        return false;
    }

    public static <S> boolean isParameterForThisTypeOfCar(TypeOfCar typeOfCar, Color color, Model model,
                                                          Wheel wheel, Engine engine, S carParameter) {
        if (typeOfCar.equals(color.getTypeOfCar()) &&
                typeOfCar.equals(model.getTypeOfCar()) &&
                typeOfCar.equals(wheel.getTypeOfCar()) &&
                typeOfCar.equals(engine.getTypeOfCar())
        ) {
            if (carParameter instanceof BusPassengerCapacity && typeOfCar.equals(TypeOfCar.BUS)) {
                return true;
            }
            if (carParameter instanceof PassengerCarBodyType && typeOfCar.equals(TypeOfCar.PASSENGER_CAR)) {
                return true;
            }
            if (carParameter instanceof TruckLoadCapacity && typeOfCar.equals(TypeOfCar.TRUCK)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Color> getListOfColors(TypeOfCar typeOfCar) {
        ArrayList<Color> colors = new ArrayList<>();
        for (Color color : Color.values()) {
            if (color.isColorForThisCar(typeOfCar)) {
                colors.add(color);
            }
        }
        return colors;
    }

    public static ArrayList<Model> getListOfModels(TypeOfCar typeOfCar) {
        ArrayList<Model> models = new ArrayList<>();
        for (Model model : Model.values()) {
            if (model.isModelForThisCar(typeOfCar)) {
                models.add(model);
            }
        }
        return models;
    }

    public static ArrayList<Wheel> getListOfWheels(TypeOfCar typeOfCar) {
        ArrayList<Wheel> wheels = new ArrayList<>();
        for (Wheel wheel : Wheel.values()) {
            if (wheel.isWheelForThisCar(typeOfCar)) {
                wheels.add(wheel);
            }
        }
        return wheels;
    }

    public static ArrayList<Engine> getListOfEngines(TypeOfCar typeOfCar) {
        ArrayList<Engine> engines = new ArrayList<>();
        for (Engine engine : Engine.values()) {
            if (engine.isEngineForThisCar(typeOfCar)) {
                engines.add(engine);
            }
        }
        return engines;
    }

    public static Color generateRandomColor(TypeOfCar typeOfCar) {
        ArrayList<Color> colors = getListOfColors(typeOfCar);
        return colors.get(RANDOM.nextInt(colors.size()));
    }

    public static Model generateRandomModel(TypeOfCar typeOfCar) {
        ArrayList<Model> models = getListOfModels(typeOfCar);
        return models.get(RANDOM.nextInt(models.size()));
    }

    public static Wheel generateRandomWheel(TypeOfCar typeOfCar) {
        ArrayList<Wheel> wheels = getListOfWheels(typeOfCar);
        return wheels.get(RANDOM.nextInt(wheels.size()));
    }

    public static Engine generateRandomEngine(TypeOfCar typeOfCar) {
        ArrayList<Engine> engines = getListOfEngines(typeOfCar);
        return engines.get(RANDOM.nextInt(engines.size()));
    }

    public static EnumSet<Option> generateRandomOptions() {
        ArrayList<Option> tempOptions = new ArrayList<>();
        for (Option option : Option.values()) {
            tempOptions.add(option);
        }
        EnumSet<Option> randomOptions = EnumSet.noneOf(Option.class);
        int optionQuantity = RANDOM.nextInt(tempOptions.size() + 1);
        for (int j = 0; j < optionQuantity; j++) {
            int tempIndex = RANDOM.nextInt(tempOptions.size());
            randomOptions.add(tempOptions.get(tempIndex));
            tempOptions.remove(tempIndex);
        }
        return randomOptions;
    }

    public static BusPassengerCapacity generateRandomBusPassengerCapacity() {
        BusPassengerCapacity[] busCapacities = BusPassengerCapacity.values();
        return busCapacities[RANDOM.nextInt(busCapacities.length)];
    }

    public static PassengerCarBodyType generateRandomPassengerCarBodyType() {
        PassengerCarBodyType[] carBodyTypes = PassengerCarBodyType.values();
        return carBodyTypes[RANDOM.nextInt(carBodyTypes.length)];
    }

    public static TruckLoadCapacity generateRandomTruckLoadCapacity() {
        TruckLoadCapacity[] loadCapacities = TruckLoadCapacity.values();
        return loadCapacities[RANDOM.nextInt(loadCapacities.length)];
    }

    public static void generateRandomCars(TypeOfCar typeOfCar, Stock stock, int quantityOfCars) {
        int[] years = {2022, 2023, 2023, 2023};
        for (int i = 1; i <= quantityOfCars; i++) {
            Color randomColor = generateRandomColor(typeOfCar);
            Model randomModel = generateRandomModel(typeOfCar);
            int randomYear = years[RANDOM.nextInt(years.length)];
            Wheel randomWheel = generateRandomWheel(typeOfCar);
            Engine randomEngine = generateRandomEngine(typeOfCar);
            EnumSet<Option> randomOptions = generateRandomOptions();
            if (typeOfCar.equals(TypeOfCar.BUS)) {
                BusPassengerCapacity randomBusCapacity = generateRandomBusPassengerCapacity();
                try {
                    stock.addCarToStock(new Bus(
                            randomColor,
                            typeOfCar,
                            randomModel,
                            randomYear,
                            randomWheel,
                            randomEngine,
                            randomOptions,
                            randomBusCapacity));
                } catch (NotValidArgumentException e) {
                    System.out.println(e);
                }
            }
            if (typeOfCar.equals(TypeOfCar.PASSENGER_CAR)) {
                PassengerCarBodyType randomCarBodyType = generateRandomPassengerCarBodyType();
                try {
                    stock.addCarToStock(new PassengerCar(
                            randomColor,
                            typeOfCar,
                            randomModel,
                            randomYear,
                            randomWheel,
                            randomEngine,
                            randomOptions,
                            randomCarBodyType));
                } catch (NotValidArgumentException e) {
                    System.out.println(e);
                }
            }
            if (typeOfCar.equals(TypeOfCar.TRUCK)) {
                TruckLoadCapacity randomLoadCapacity = generateRandomTruckLoadCapacity();
                try {
                    stock.addCarToStock(new Truck(
                            randomColor,
                            typeOfCar,
                            randomModel,
                            randomYear,
                            randomWheel,
                            randomEngine,
                            randomOptions,
                            randomLoadCapacity));
                } catch (NotValidArgumentException e) {
                    System.out.println(e);
                }
            }
        }
    }
}