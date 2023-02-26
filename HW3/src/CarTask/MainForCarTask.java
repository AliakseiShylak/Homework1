package CarTask;

import CarTask.Enums.*;
import CarTask.Generator.GeneratorRandomCars;

import java.util.ArrayList;
import java.util.EnumSet;

public class MainForCarTask {
    public static void main(String[] args) {
        EnumSet<Brands> brand = EnumSet.of(Brands.KIA);
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
        ArrayList<Car> initialKiaRusStock = GeneratorRandomCars.generateRandomCars(colorsOfKiaRus, brand,
                modelsOfKiaRus, yearOfProdaction, wheelsOfKiaRus, enginesOfKiaRus, standart, 1);
        ArrayList<Car> initialKiaSvkStock = GeneratorRandomCars.generateRandomCars(colorsOfKiaSvk, brand,
                modelsOfKiaSvk, yearOfProdaction, wheelsOfKiaSvk, enginesOfKiaSvk, premium, 2);
        Stock stockOfKiaRus = new Stock(initialKiaRusStock);
        Stock stockOfKiaSvk = new Stock(initialKiaSvkStock);
        CarFactory kiaRus = new CarFactory("Kia Russia", brand, modelsOfKiaRus,
                enginesOfKiaRus, colorsOfKiaRus, wheelsOfKiaRus, stockOfKiaRus);
        CarFactory kiaSvk = new CarFactory("Kia Slovakia", brand, modelsOfKiaSvk,
                enginesOfKiaSvk, colorsOfKiaSvk, wheelsOfKiaSvk, stockOfKiaSvk);

//  Печатаем данные о возможностях заводов и их складских запасах
        System.out.println(kiaRus.getDataAboutFactory());
        System.out.println(kiaRus.printStockOfFactory());
        System.out.println(kiaSvk.getDataAboutFactory());
        System.out.println(kiaSvk.printStockOfFactory());

//  Попытка произвести автомобиль, не соответствующий возможностям (ограничниям) завода
        if (kiaSvk.addCarToStock(new Car(ColorsOfCar.BLACK, Brands.KIA, ModelsOfCar.CEED, 2023,
                SizeOfWheels.R13, Engines.L1_6, standart))) {
            System.out.println("Car added to stock of factory " + kiaSvk.getNAME_OF_FACTORY());
        } else {
            System.out.println("Factory " + kiaSvk.getNAME_OF_FACTORY() + " does not produce such cars");
        }
        System.out.println(kiaSvk.printStockOfFactory());

//  Производим и отправляем на склад новые автомобилі
        if (kiaSvk.addCarToStock(new Car(ColorsOfCar.BLACK, Brands.KIA, ModelsOfCar.SOUL, 2023,
                SizeOfWheels.R14, Engines.L1_6, standart))) {
            System.out.println("Car added to stock of factory " + kiaSvk.getNAME_OF_FACTORY());
        } else {
            System.out.println("Factory " + kiaSvk.getNAME_OF_FACTORY() + " does not produce such cars");
        }
        if (kiaSvk.addCarToStock(new Car(ColorsOfCar.RED, Brands.KIA, ModelsOfCar.SPORTAGE, 2023,
                SizeOfWheels.R18, Engines.L2_4, premium))) {
            System.out.println("Car added to stock of factory " + kiaSvk.getNAME_OF_FACTORY());
        } else {
            System.out.println("Factory " + kiaSvk.getNAME_OF_FACTORY() + " does not produce such cars");
        }
        System.out.println(kiaSvk.printStockOfFactory());

//  Создаем автосалон с сервисом
        CarService kiaMinskService = new CarService();
        ArrayList<Car> initialKiaMinskStock = GeneratorRandomCars.generateRandomCars(colorsOfKiaSvk, brand,
                modelsOfKiaSvk, yearOfProdaction, wheelsOfKiaSvk, enginesOfKiaSvk, base, 2);
        Stock kiaMinskStock = new Stock(initialKiaMinskStock);
        CarShop kiaMinskShop = new CarShop("Kia Minsk", kiaMinskService, kiaMinskStock);
        System.out.println(kiaMinskShop.printStockOfShop());

//  Oшибочное размещение автосалоном заказа на завод на автомобиль, который данный автозавод не производит
        if (kiaSvk.completeShopOrder(kiaMinskShop, new Car(ColorsOfCar.RED, Brands.KIA, ModelsOfCar.RIO,
                2023, SizeOfWheels.R18, Engines.L2_4, premium))) {
            System.out.println("Car is shipped to stock of " + kiaMinskShop.getNAME_OF_SHOP());
        } else {
            System.out.println("Factory " + kiaSvk.getNAME_OF_FACTORY() + " does not produce such cars");
        }

//  Заказ автосалоном автомобиля который есть на скаде автозавода
        if (kiaSvk.completeShopOrder(kiaMinskShop, new Car(ColorsOfCar.RED, Brands.KIA, ModelsOfCar.SPORTAGE, 2023,
                SizeOfWheels.R18, Engines.L2_4, premium))) {
            System.out.println("Car is shipped to stock of " + kiaMinskShop.getNAME_OF_SHOP());
        } else {
            System.out.println("Factory " + kiaSvk.getNAME_OF_FACTORY() + " does not produce such cars");
        }

//  Заказ автосалоном автомобиля которого возможно нет на складе автозавода, но автозавод может произвести
        if (kiaSvk.completeShopOrder(kiaMinskShop, new Car(ColorsOfCar.RED, Brands.KIA, ModelsOfCar.SOUL,
                2023, SizeOfWheels.R18, Engines.L2_4, standart))) {
            System.out.println("Car is shipped to stock of " + kiaMinskShop.getNAME_OF_SHOP());
        } else {
            System.out.println("Factory " + kiaSvk.getNAME_OF_FACTORY() + " does not produce such cars");
        }

        System.out.println(kiaSvk.printStockOfFactory());
        System.out.println(kiaMinskShop.printStockOfShop());

//  Демонстрация услуг автосалона по модернизации автомобиля
        Car carForModification =
                kiaMinskShop.getStockOfShop().getStock().get(kiaMinskShop.getStockOfShop().getStock().size() - 1);
        kiaMinskShop.getSERVICE_OF_SHOP().repaintCar(carForModification, ColorsOfCar.GRAY);
        kiaMinskShop.getSERVICE_OF_SHOP().setNewWheels(carForModification, SizeOfWheels.R17);
        kiaMinskShop.getSERVICE_OF_SHOP().addOneOption(carForModification, Options.ALLOY_WHEELS);
        kiaMinskShop.getSERVICE_OF_SHOP().deleteOneOption(carForModification, Options.MAT_SET);

        System.out.println(kiaMinskShop.printStockOfShop());
    }
}