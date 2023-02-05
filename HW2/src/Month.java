/*
 * Задача 1:
 * Задача с месяцами года.
 * Необходимо реализовоть класс который имеет два метода:
 * 1) определить номер месяца по имени.
 * 2) определить имя месяца по номеру.
 * Рекоменндованно использовать Enum.
 */
public enum Month {
    JANUARY(1, "january"),
    FEBRUARY(2, "february"),
    MARCH(3, "march"),
    APRIL(4, "april"),
    MAY(5, "may"),
    JUNE(6, "june"),
    JULY(7, "july"),
    AUGUST(8, "august"),
    SEPTEMBER(9, "september"),
    OCTOBER(10, "october"),
    NOVEMBER(11, "november"),
    DECEMBER(12, "december");
    private int monthNumber;
    private String monthName;

    Month(int monthNumber, String monthName) {
        this.monthNumber = monthNumber;
        this.monthName = monthName;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public String getMonthName() {
        return monthName;
    }

    public static int getNumberByName(String name) {
        for (Month month : values()) {
            if (name.toLowerCase().equals(month.getMonthName())) {
                return month.getMonthNumber();
            }
        }
        return 0;
    }

    public static String getNameByNumber(int number) {
        for (Month month : values()) {
            if (number == month.getMonthNumber()) {
                return month.getMonthName();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int number = 6;
        String name = "July";

        if (getNumberByName(name) == 0) {
            System.out.println("There is no month with name " + name);
        } else {
            System.out.println("Number of " + name + " is " + getNumberByName(name));
        }
        if (getNameByNumber(number) == null) {
            System.out.println("There is no month with number " + number);
        } else {
            System.out.println("Month with number " + number + " is named " + getNameByNumber(number));
        }
    }
}