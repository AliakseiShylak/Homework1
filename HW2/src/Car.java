/*
 * Задача 4:
 * Необходимо реализовать класс Car,  который имеет поля марка и цвет.
 * Марки имеют следующие цвета:
 * Audi - Синий. Красный. Зеленый
 * BMW - Оранжевый. Черный. Фиолетовый
 * KIA -  Желтый. Cерый. Белый
 * Ожидается метод который изметяет цвет.
 * Как параметр принимает строку, если цвет не верный, то ничего не изменяет.
 */
public class Car {
    private ModelOfCar model;
    private Color color;

    public Car(ModelOfCar model, Color color) {
        this.model = model;
        this.color = color;
    }

    public void repaintCar(Color newColor) {
        if (newColor.checkColor(this.model)) {
            color = newColor;
        }
    }

    public void printCar() {
        System.out.println(color + " " + model);
    }

    public static void main(String[] args) {
        Car car1 = new Car(ModelOfCar.AUDI, Color.BLUE);
        Car car2 = new Car(ModelOfCar.AUDI, Color.RED);
        Car car3 = new Car(ModelOfCar.AUDI, Color.GREEN);
        Car car4 = new Car(ModelOfCar.BMW, Color.ORANGE);
        Car car5 = new Car(ModelOfCar.BMW, Color.BLACK);
        Car car6 = new Car(ModelOfCar.BMW, Color.VIOLET);
        Car car7 = new Car(ModelOfCar.KIA, Color.YELLOW);
        Car car8 = new Car(ModelOfCar.KIA, Color.GRAY);
        Car car9 = new Car(ModelOfCar.KIA, Color.WHITE);
        Car[] car = {car1, car2, car3, car4, car5, car6, car7, car8, car9};

        System.out.println("List of cars in my garage:");
        for (Car auto : car) {
            auto.printCar();
        }

        car1.repaintCar(Color.RED);
        car4.repaintCar(Color.RED);
        car7.repaintCar(Color.WHITE);
        System.out.println("List of cars in my garage after repainting:");
        for (Car auto : car) {
            auto.printCar();
        }
    }
}

