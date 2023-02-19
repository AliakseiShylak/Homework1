import java.util.EnumSet;

public class Car {
    private ColorsOfCar color;
    private final String BRAND = "KIA";
    private final ModelsOfCar MODEL;
    private final int YEAR;
    private SizeOfWheels wheel;
    private final Engines ENGINE;
    private EnumSet<Options> option;

    public Car(ColorsOfCar color, ModelsOfCar model, int year, SizeOfWheels wheel, Engines engine) {
        this.color = color;
        this.MODEL = model;
        this.YEAR = year;
        this.wheel = wheel;
        this.ENGINE = engine;
        this.option = null;
    }

    public Car(ColorsOfCar color, ModelsOfCar model, int year, SizeOfWheels wheel, Engines engine, EnumSet<Options> option) {
        this.color = color;
        this.MODEL = model;
        this.YEAR = year;
        this.wheel = wheel;
        this.ENGINE = engine;
        this.option = option;
    }

    public void changeColor(ColorsOfCar colorNew) {
        this.color = colorNew;
    }

    public void changeWheels(SizeOfWheels wheelNew) {
        this.wheel = wheelNew;
    }

    public void addOption(Options optionNew) {
        if (this.option == null) {
            this.option = EnumSet.of(optionNew);
        } else {
            this.option.add(optionNew);
        }
    }

    public void deleteOption(Options optionDeleted) {
        this.option.remove(optionDeleted);
    }

    public void deleteAllOptions() {
        this.option.removeAll(this.option);
    }

    @Override
    public String toString() {
        String str = "Brand: " + this.BRAND +
                ", model: " + this.MODEL +
                ", color: " + this.color +
                ", year of prodaction: " + this.YEAR +
                ", size of wheels: " + this.wheel +
                ", engine: " + this.ENGINE;
        if (this.option == null || this.option.size() == 0) {
            str = str.concat("\nNo options.\n");
        } else {
            str = str.concat("\nOptions: " + option.toString() + "\n");
        }
        return str;
    }
}
