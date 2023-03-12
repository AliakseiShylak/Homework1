package cars;

import cars.enums.*;
import exceptions.NotValidArgumentException;
import factoty.Stock;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;

public class CarUtils<T extends Car> {
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

    public static void generateRandomCars(TypeOfCar typeOfCar, Stock stock, int quantityOfCars) {
        ArrayList<Color> colors = getListOfColors(typeOfCar);
        ArrayList<Model> models = getListOfModels(typeOfCar);
        ArrayList<Wheel> wheels = getListOfWheels(typeOfCar);
        ArrayList<Engine> engines = getListOfEngines(typeOfCar);
        BusPassengerCapacity[] busCapacities = BusPassengerCapacity.values();
        PassengerCarBodyType[] carBodyTypes = PassengerCarBodyType.values();
        TruckLoadCapacity[] loadCapacities = TruckLoadCapacity.values();
        int[] years = {2022, 2023, 2023, 2023};
        Random random = new Random();

        for (int i = 1; i <= quantityOfCars; i++) {
            Color randomColor = colors.get(random.nextInt(colors.size()));
            Model randomModel = models.get(random.nextInt(models.size()));
            int randomYear = years[random.nextInt(years.length)];
            Wheel randomWheel = wheels.get(random.nextInt(wheels.size()));
            Engine randomEngine = engines.get(random.nextInt(engines.size()));
            ArrayList<Option> tempOptions = new ArrayList<>();
            for (Option option : Option.values()) {
                tempOptions.add(option);
            }
            EnumSet<Option> randomOptions = EnumSet.noneOf(Option.class);
            int optionQuantity = random.nextInt(tempOptions.size() + 1);
            for (int j = 0; j < optionQuantity; j++) {
                int tempIndex = random.nextInt(tempOptions.size());
                randomOptions.add(tempOptions.get(tempIndex));
                tempOptions.remove(tempIndex);
            }
            if (typeOfCar.equals(TypeOfCar.BUS)) {
                BusPassengerCapacity randomBusCapacity = busCapacities[random.nextInt(busCapacities.length)];
                try {
                    stock.addCarToStock(new Bus(randomColor, typeOfCar, randomModel, randomYear,
                            randomWheel, randomEngine, randomOptions, randomBusCapacity));
                } catch (NotValidArgumentException e) {
                    System.out.println(e);
                }
            }
            if (typeOfCar.equals(TypeOfCar.PASSENGER_CAR)) {
                PassengerCarBodyType randomCarBodyType = carBodyTypes[random.nextInt(carBodyTypes.length)];
                try {
                    stock.addCarToStock(new PassengerCar(randomColor, typeOfCar, randomModel, randomYear,
                            randomWheel, randomEngine, randomOptions, randomCarBodyType));
                } catch (NotValidArgumentException e) {
                    System.out.println(e);
                }
            }
            if (typeOfCar.equals(TypeOfCar.TRUCK)) {
                TruckLoadCapacity randomLoadCapacity = loadCapacities[random.nextInt(loadCapacities.length)];
                try {
                    stock.addCarToStock(new Truck(randomColor, typeOfCar, randomModel, randomYear,
                            randomWheel, randomEngine, randomOptions, randomLoadCapacity));
                } catch (NotValidArgumentException e) {
                    System.out.println(e);
                }
            }
        }
    }
}