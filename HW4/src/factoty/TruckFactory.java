package factoty;

import carparameters.Option;
import carparameters.TypeOfCar;
import carparameters.truckenums.*;
import cars.Truck;
import order.TruckOrder;
import utils.Generator;

import java.util.ArrayList;
import java.util.EnumSet;

public class TruckFactory extends Factory implements Generator {
    public TruckFactory(
            String nameOfFactory,
            ArrayList<TruckModel> modelsOfFactory,
            ArrayList<TruckEngine> setOfEngines,
            ArrayList<TruckColor> setOfColors,
            ArrayList<TruckWheel> setOfWheels,
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
        TruckColor[] colors = TruckColor.values();
        TruckModel[] models = TruckModel.values();
        Integer[] years = {CURRENT_YEAR - 1, CURRENT_YEAR, CURRENT_YEAR, CURRENT_YEAR};
        TruckWheel[] wheels = TruckWheel.values();
        TruckEngine[] engines = TruckEngine.values();
        TruckLoadCapacity[] truckLoadCapacities = TruckLoadCapacity.values();
        for (int i = 0; i < quantity; i++) {
            super.stockOfFactory.addCarToStock(
                    new Truck(
                            (TruckColor) Generator.generateRandomParameter(colors),
                            (TruckModel) Generator.generateRandomParameter(models),
                            (Integer) Generator.generateRandomParameter(years),
                            (TruckWheel) Generator.generateRandomParameter(wheels),
                            (TruckEngine) Generator.generateRandomParameter(engines),
                            Generator.generateRandomOptions(),
                            (TruckLoadCapacity) Generator.generateRandomParameter(truckLoadCapacities)
                    )
            );
        }
    }

    private int estimateСarСompatibility(Truck car, TruckOrder order) {
        if (car.getTruckLoadCapacity().equals(order.getTruckLoadCapacityOfOrderedCar())) {
            return super.estimateСarСompatibility(car, order);
        }
        return -1;
    }

    private Truck findCar(TruckOrder order) {
        Truck convertibleCar = null;
        int bestEstimation = -1;
        for (Truck currentCar : (ArrayList<Truck>) stockOfFactory.getStock()) {
            int currentEstimation = estimateСarСompatibility(currentCar, order);
            if (currentEstimation > bestEstimation) {
                convertibleCar = currentCar;
                bestEstimation = currentEstimation;
            }
        }
        return convertibleCar;
    }

    public Truck completeOrder(TruckOrder order) {
        Truck suitableCar = findCar(order);
        if (suitableCar == null) {
            suitableCar = new Truck(
                    (TruckColor) order.getColorOfOrderedCar(),
                    (TruckModel) order.getModelOfOrderedCar(),
                    CURRENT_YEAR,
                    (TruckWheel) order.getWheelOfOrderedCar(),
                    (TruckEngine) order.getEngineOfOrderedCar(),
                    order.getOptionsOfOrderedCar(),
                    order.getTruckLoadCapacityOfOrderedCar()
            );
        } else {
            stockOfFactory.deleteCar(suitableCar);
            super.convertCar(suitableCar, order);
        }
        return suitableCar;
    }
}
