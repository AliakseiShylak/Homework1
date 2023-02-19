import java.util.ArrayList;
import java.util.EnumSet;

public class CarFactory {
    private final String NAME_OF_FACTORY;
    private final EnumSet<ModelsOfCar> MODELS_OF_FACTORY;
    private final EnumSet<Engines> SET_OF_ENGINES;
    private final EnumSet<ColorsOfCar> SET_OF_COLORS;
    private final EnumSet<SizeOfWheels> SET_OF_WHEELS;
    private ArrayList<Car> stock;

    public CarFactory(String nameOfFactory,
                      EnumSet<ModelsOfCar> modelsOfFactory,
                      EnumSet<Engines> setOfEngines,
                      EnumSet<ColorsOfCar> setOfColors,
                      EnumSet<SizeOfWheels> setOfWheels,
                      ArrayList<Car> stock) {
        this.NAME_OF_FACTORY = nameOfFactory;
        this.MODELS_OF_FACTORY = modelsOfFactory;
        this.SET_OF_ENGINES = setOfEngines;
        this.SET_OF_COLORS = setOfColors;
        this.SET_OF_WHEELS = setOfWheels;
        this.stock = stock;
    }

    public String getDataAboutFactory() {
        String str = "Models produced by the factory " + NAME_OF_FACTORY +
                ": " + MODELS_OF_FACTORY.toString() +
                "\nSet of engines: " + SET_OF_ENGINES.toString() +
                "\nSet of colors: " + SET_OF_COLORS.toString() +
                "\nSet of wheels: " + SET_OF_WHEELS.toString();
        return str;
    }

    public String getStock() {
        String str;
        if (this.stock.size() == 0 || this.stock == null) {
            str = "There are not cars in stock.";
            return str;
        }
        str = "Cars in stock of factory: " + NAME_OF_FACTORY + "\n";
        for (Car car : stock) {
            str = str.concat(car.toString());
        }
        return str;
    }
}
