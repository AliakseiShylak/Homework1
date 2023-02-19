import java.util.ArrayList;
import java.util.EnumSet;

public class MainForCarTask {
    public static void main(String[] args) {
        EnumSet<ColorsOfCar> colorsOfKiaRus = EnumSet.of(ColorsOfCar.BLUE, ColorsOfCar.BLACK,
                ColorsOfCar.ORANGE, ColorsOfCar.WHITE, ColorsOfCar.GRAY, ColorsOfCar.GREEN);
        EnumSet<ColorsOfCar> colorsOfKiaSvk = EnumSet.of(ColorsOfCar.BLUE, ColorsOfCar.BLACK,
                ColorsOfCar.YELLOW, ColorsOfCar.WHITE, ColorsOfCar.GRAY, ColorsOfCar.VIOLET, ColorsOfCar.RED);
        EnumSet<ModelsOfCar> modelsOfKiaRus = EnumSet.of(ModelsOfCar.PICANTO, ModelsOfCar.RIO,
                ModelsOfCar.CEED);
        EnumSet<ModelsOfCar> modelsOfKiaSvk = EnumSet.of(ModelsOfCar.CEED, ModelsOfCar.SOUL,
                ModelsOfCar.SPORTAGE);
        int[] yearOfProdaction = {2022, 2023, 2023, 2023};
        EnumSet<Engines> enginesOfKiaRus = EnumSet.of(Engines.L1_0, Engines.L1_2, Engines.L1_4, Engines.L1_6);
        EnumSet<Engines> enginesOfKiaSvk = EnumSet.of(Engines.L1_4, Engines.L1_6, Engines.L2_0, Engines.L2_4);
        EnumSet<SizeOfWheels> wheelsOfKiaRus = EnumSet.of(SizeOfWheels.R13, SizeOfWheels.R14,
                SizeOfWheels.R15, SizeOfWheels.R16);
        EnumSet<SizeOfWheels> wheelsOfKiaSvk = EnumSet.of(SizeOfWheels.R14, SizeOfWheels.R15,
                SizeOfWheels.R16, SizeOfWheels.R17, SizeOfWheels.R18);
        EnumSet<Options> base = null;
        EnumSet<Options> standart = EnumSet.of(Options.CONDITIONER, Options.MAT_SET);
        EnumSet<Options> premium = EnumSet.of(Options.CONDITIONER, Options.MAT_SET, Options.ALLOY_WHEELS,
                Options.CRUISE_CONTROL, Options.HEATED_SEATS, Options.HEATED_STEERING);
        ArrayList<Car> initialKiaRusStock = GeneratorRandomCars.generateRandomCars(colorsOfKiaRus, modelsOfKiaRus,
                yearOfProdaction, wheelsOfKiaRus, enginesOfKiaRus, standart, 10);
        ArrayList<Car> initialKiaSvkStock = GeneratorRandomCars.generateRandomCars(colorsOfKiaSvk, modelsOfKiaSvk,
                yearOfProdaction, wheelsOfKiaSvk, enginesOfKiaSvk, premium, 15);
        CarFactory kiaRus = new CarFactory("Kia Russia", modelsOfKiaRus, enginesOfKiaRus,
                colorsOfKiaRus, wheelsOfKiaRus, initialKiaRusStock);
        CarFactory kiaSvk = new CarFactory("Kia Slovakia", modelsOfKiaSvk, enginesOfKiaSvk,
                colorsOfKiaSvk, wheelsOfKiaSvk, initialKiaSvkStock);

        System.out.println(kiaRus.getDataAboutFactory());
        System.out.println(kiaRus.getStock());
        System.out.println(kiaSvk.getDataAboutFactory());
        System.out.println(kiaSvk.getStock());

        System.out.println("Проверка методов сервиса");
        Car car = new Car(ColorsOfCar.BLACK, ModelsOfCar.CEED, 2015, SizeOfWheels.R15, Engines.L1_6, standart);
        System.out.print(car);
        CarService.repaintCar(car, ColorsOfCar.GREEN);
        CarService.setNewWheels(car, SizeOfWheels.R16);
        CarService.addOneOption(car, Options.CRUISE_CONTROL);
        CarService.deleteOneOption(car, Options.MAT_SET);
        System.out.print(car);
        CarService.changeAllOptions(car, base);
        System.out.print(car);


    }
}