package masa.java.homework.cars;

/**
 * Создайте новый класс под названием Car, который имеет следующие поля:
 *     year - поле года - это int, в котором хранится модель года автомобиля (, например. 2015 )
 *     mark - поле mark - это объект String, который удерживает марку автомобиля (, например. "Honda" )
 *     speed - поле скорости является double, который удерживает максимальную скорость автомобиля (, например. 85,0 )
 * Кроме того, класс автомобилей должен иметь следующие методы:
 *   Методы Setter - напишите три метода  чтобы инициализировать поля year, make, speed:
 *      setYear (int year), setMark (String mark), setSpeed (int speed)
 *   Методы Getter - напишите три метода accessor (getter)
 */
public class Car {
    private int year;
    private String mark;
    private double maxSpeed;

    public Car () {

    }

    public Car (int year, String mark, double maxSpeed) {
        this.year = year;
        this.mark = mark;
        this.maxSpeed = maxSpeed;
    }

    public void setYear (int year) {
        this.year = year;
    }

    public void setMark (String mark) {
        this.mark = mark;
    }

    public void setMaxSpeed (int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getYear () {
        return this.year;
    }

    public String getMark () {
        return this.mark;
    }

    public double getMaxSpeed () {
        return this.maxSpeed;
    }

    public static void main(String[] args) {
    }
}
