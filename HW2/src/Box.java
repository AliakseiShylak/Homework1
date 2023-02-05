/*
 * Задача 2:
 * Задача с классом Box(x,y,z)
 * Необходимо добавить в класс возможность определить какого типа коробка у нас создана.
 * 1) Куб (Все стороны равны).
 * 2) Обычная коробка.
 * 3) Конверт (Есть только длинна и ширина).
 */
public class Box {
    private int length;
    private int width;
    private int height;

    Box(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    Box(int length, int width) {
        this.length = length;
        this.width = width;
        this.height = 0;
    }

    public String getTypeOfBox() {
        if (length <= 0 || width <= 0 || height < 0) {
            return "box with wrong size";
        }
        if (length == width && length == height) {
            return "cube";
        }
        if (height == 0) {
            return "envelope";
        }
        return "ordinary box";
    }

    public static void main(String[] args) {
        Box box1 = new Box(5, 5, 5);
        Box box2 = new Box(5, 6, 3);
        Box box3 = new Box(5, 6);

        System.out.println("First box is " + box1.getTypeOfBox());
        System.out.println("Second box is " + box2.getTypeOfBox());
        System.out.println("Third box is " + box3.getTypeOfBox());
    }
}
