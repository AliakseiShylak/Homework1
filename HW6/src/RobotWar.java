import country.Country;
import production.Factory;
import production.Stock;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class RobotWar {
    private static final Integer LIMIT = 20;
    private static final Object OBJECT = new Object();
    private static volatile AtomicBoolean run = new AtomicBoolean(true);
    private static Stock stock = new Stock();


    private static void produce() {
        Factory factory = new Factory();
        try {
            while (run.get()) {
                synchronized (OBJECT) {
                    factory.produceRandomPartAndPutInStock(stock);
                    System.out.println(stock.printStock());
                }
                Thread.sleep(5000);
            }
        } catch (InterruptedException ignored) {
        }
    }

    private static void consume(String nameOfCountry) {
        Country country = new Country(nameOfCountry);
        while (run.get()) {
            while (country.getSizeOfArmy() < LIMIT) {
                synchronized (OBJECT) {
                    if (run.get() == false) {
                        break;
                    }
                    if (country.takePartsFromStock(stock)) {
                        System.out.println(country.printDataAboutAndPartsForRobot());
                    }
                    if (country.collectRobot()) {
                        System.out.println(country.printDataAboutAndPartsForRobot());
                    }
                    if (country.getSizeOfArmy() == LIMIT) {
                        run.set(false);
                        System.out.println("Winner is country " + nameOfCountry);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread producer = new Thread(RobotWar::produce);
        Thread countryABC = new Thread(() -> consume("ABC"));
        Thread countryXYZ = new Thread(() -> consume("XYZ"));
        producer.start();
        countryABC.start();
        countryXYZ.start();
        producer.join();
        countryABC.join();
        countryXYZ.join();
    }
}
