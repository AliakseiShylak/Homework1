public enum Color {
    BLUE(ModelOfCar.AUDI),
    RED(ModelOfCar.AUDI),
    GREEN(ModelOfCar.AUDI),
    ORANGE(ModelOfCar.BMW),
    BLACK(ModelOfCar.BMW),
    VIOLET(ModelOfCar.BMW),
    YELLOW(ModelOfCar.KIA),
    GRAY(ModelOfCar.KIA),
    WHITE(ModelOfCar.KIA);

    private ModelOfCar carModel;

    Color(ModelOfCar carModel) {
        this.carModel = carModel;
    }

    boolean checkColor(ModelOfCar Model) {
        return carModel == Model;
    }
}
