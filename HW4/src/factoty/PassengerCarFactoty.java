package factoty;

import carparameters.Option;
import carparameters.TypeOfCar;
import carparameters.passengercarenums.*;
import cars.PassengerCar;
import order.PassengerCarOrder;
import utils.Generator;

import java.util.ArrayList;
import java.util.EnumSet;

public class PassengerCarFactoty extends Factory implements Generator {
    public PassengerCarFactoty(
            String nameOfFactory,
            ArrayList<PassengerCarModel> modelsOfFactory,
            ArrayList<PassengerCarEngine> setOfEngines,
            ArrayList<PassengerCarColor> setOfColors,
            ArrayList<PassengerCarWheel> setOfWheels,
            int initialQuantityCarsOnStock
    ) {
        super(nameOfFactory, TypeOfCar.BUS);
        super.modelsOfFactory.addAll(modelsOfFactory);
        super.setOfEngines.addAll(setOfEngines);
        super.setOfColors.addAll(setOfColors);
        super.setOfWheels.addAll(setOfWheels);
        generateRandomCars(initialQuantityCarsOnStock);
    }

    @Override
    public void generateRandomCars(int quantity) {
        PassengerCarColor[] colors = PassengerCarColor.values();
        PassengerCarModel[] models = PassengerCarModel.values();
        Integer[] years = {CURRENT_YEAR - 1, CURRENT_YEAR, CURRENT_YEAR, CURRENT_YEAR};
        PassengerCarWheel[] wheels = PassengerCarWheel.values();
        PassengerCarEngine[] engines = PassengerCarEngine.values();
        PassengerCarBodyType[] passengerCarBodyTypes = PassengerCarBodyType.values();
        for (int i = 0; i < quantity; i++) {
            super.stockOfFactory.addCarToStock(
                    new PassengerCar(
                            (PassengerCarColor) Generator.generateRandomParameter(colors),
                            (PassengerCarModel) Generator.generateRandomParameter(models),
                            (Integer) Generator.generateRandomParameter(years),
                            (PassengerCarWheel) Generator.generateRandomParameter(wheels),
                            (PassengerCarEngine) Generator.generateRandomParameter(engines),
                            Generator.generateRandomOptions(),
                            (PassengerCarBodyType) Generator.generateRandomParameter(passengerCarBodyTypes)
                    )
            );
        }
    }

    private int estimateСarСompatibility(PassengerCar car, PassengerCarOrder order) {
        if (car.getPassengerCarBodyType().equals(order.getPassengerCarBodyType())) {
            return super.estimateСarСompatibility(car, order);
        }
        return -1;
    }

    private PassengerCar findCar(PassengerCarOrder order) {
        PassengerCar convertibleCar = null;
        int bestEstimation = -1;
        for (PassengerCar currentCar : (ArrayList<PassengerCar>) stockOfFactory.getStock()) {
            int currentEstimation = estimateСarСompatibility(currentCar, order);
            if (currentEstimation > bestEstimation) {
                convertibleCar = currentCar;
                bestEstimation = currentEstimation;
            }
        }
        return convertibleCar;
    }

    public PassengerCar completeOrder(PassengerCarOrder order) {
        PassengerCar suitableCar = findCar(order);
        if (suitableCar == null) {
            suitableCar = new PassengerCar(
                    (PassengerCarColor) order.getColorOfOrderedCar(),
                    (PassengerCarModel) order.getModelOfOrderedCar(),
                    CURRENT_YEAR,
                    (PassengerCarWheel) order.getWheelOfOrderedCar(),
                    (PassengerCarEngine) order.getEngineOfOrderedCar(),
                    order.getOptionsOfOrderedCar(),
                    order.getPassengerCarBodyType()
            );
        } else {
            stockOfFactory.deleteCar(suitableCar);
            super.convertCar(suitableCar, order);
        }
        return suitableCar;
    }
}
