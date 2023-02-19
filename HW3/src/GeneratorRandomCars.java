import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;

public class GeneratorRandomCars {
    public static ArrayList<Car> generateRandomCars(EnumSet<ColorsOfCar> colors, EnumSet<ModelsOfCar> models,
                                                    int[] years, EnumSet<SizeOfWheels> wheels,
                                                    EnumSet<Engines> engines, EnumSet<Options> options,
                                                    int quantityOfCarsToGenerate) {
        ColorsOfCar[] arrayOfColors = colors.toArray(new ColorsOfCar[colors.size()]);
        ColorsOfCar randomColor;
        ModelsOfCar[] arrayOfModels = models.toArray(new ModelsOfCar[models.size()]);
        ModelsOfCar randomModel;
        int randomYear;
        SizeOfWheels[] arrayOfWheels = wheels.toArray(new SizeOfWheels[wheels.size()]);
        SizeOfWheels randomWheels;
        Engines[] arrayOfEngines = engines.toArray(new Engines[engines.size()]);
        Engines randomEngine;
        Random random = new Random();
        ArrayList<Car> listOfRandomCars = new ArrayList<>();

        for (int i = 1; i <= quantityOfCarsToGenerate; i++) {
            randomColor = arrayOfColors[random.nextInt(arrayOfColors.length)];
            randomModel = arrayOfModels[random.nextInt(arrayOfModels.length)];
            randomYear = years[random.nextInt(years.length)];
            randomWheels = arrayOfWheels[random.nextInt(arrayOfWheels.length)];
            randomEngine = arrayOfEngines[random.nextInt(arrayOfEngines.length)];
            listOfRandomCars.add(new Car(randomColor, randomModel, randomYear,
                                        randomWheels, randomEngine, options));
        }
        return listOfRandomCars;
    }
}
