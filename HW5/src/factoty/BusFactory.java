package factoty;

import carparameters.*;
import carparameters.busenums.*;
import cars.Bus;
import order.BusOrder;
import utils.Generator;

import java.util.ArrayList;
import java.util.EnumSet;

public class BusFactory extends Factory implements Generator {
    public BusFactory(
            String nameOfFactory,
            ArrayList<BusModel> modelsOfFactory,
            ArrayList<BusEngine> setOfEngines,
            ArrayList<BusColor> setOfColors,
            ArrayList<BusWheel> setOfWheels,
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
        BusColor[] colors = BusColor.values();
        BusModel[] models = BusModel.values();
        Integer[] years = {CURRENT_YEAR - 1, CURRENT_YEAR, CURRENT_YEAR, CURRENT_YEAR};
        BusWheel[] wheels = BusWheel.values();
        BusEngine[] engines = BusEngine.values();
        BusPassengerCapacity[] busPassengerCapacities = BusPassengerCapacity.values();
        for (int i = 0; i < quantity; i++) {
            super.stockOfFactory.addCarToStock(
                    new Bus(
                            (BusColor) Generator.generateRandomParameter(colors),
                            (BusModel) Generator.generateRandomParameter(models),
                            (Integer) Generator.generateRandomParameter(years),
                            (BusWheel) Generator.generateRandomParameter(wheels),
                            (BusEngine) Generator.generateRandomParameter(engines),
                            Generator.generateRandomOptions(),
                            (BusPassengerCapacity) Generator.generateRandomParameter(busPassengerCapacities)
                    )
            );
        }
    }

    private int estimateСarСompatibility(Bus car, BusOrder order) {
        if (car.getBusPassengerCapacity().equals(order.getBusPassengerCapacityOfOrderedCar())) {
            return super.estimateСarСompatibility(car, order);
        }
        return -1;
    }

    private Bus findCar(BusOrder order) {
        Bus convertibleCar = null;
        int bestEstimation = -1;
        for (Bus currentCar : (ArrayList<Bus>) stockOfFactory.getStock()) {
            int currentEstimation = estimateСarСompatibility(currentCar, order);
            if (currentEstimation > bestEstimation) {
                convertibleCar = currentCar;
                bestEstimation = currentEstimation;
            }
        }
        return convertibleCar;
    }

    public Bus completeOrder(BusOrder order) {
        Bus suitableCar = findCar(order);
        if (suitableCar == null) {
            suitableCar = new Bus(
                    (BusColor) order.getColorOfOrderedCar(),
                    (BusModel) order.getModelOfOrderedCar(),
                    CURRENT_YEAR,
                    (BusWheel) order.getWheelOfOrderedCar(),
                    (BusEngine) order.getEngineOfOrderedCar(),
                    order.getOptionsOfOrderedCar(),
                    order.getBusPassengerCapacityOfOrderedCar()
            );
        } else {
            stockOfFactory.deleteCar(suitableCar);
            super.convertCar(suitableCar, order);
        }
        return suitableCar;
    }
}