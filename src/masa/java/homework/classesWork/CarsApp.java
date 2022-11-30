package masa.java.homework.classesWork;

/**
 *  Создать класс Person, который содержит:
 *  переменные fullName, age;
 *  методы move() и talk(), в которых просто вывести на консоль сообщение -"Такой-то  Person говорит".
 *  Добавьте два конструктора  - Person() и Person(fullName, age).
 *  Создайте два объекта этого класса.
 *  Один объект инициализируется конструктором Person(), другой - Person(fullName, age).
 *  Создать класс Driver содержащий поля - ФИО, стаж вождения.
 *  Создать класс Engine содержащий поля - мощность, производитель.
 *  Создать класс Car содержащий поля - марка автомобиля, класс автомобиля, вес,
 *      водитель типа Driver, мотор типа Engine.
 *  Методы start(), stop(), turnRight(), turnLeft(), которые выводят на печать:
 *      "Поехали", "Останавливаемся", "Поворот направо" или "Поворот налево".
 *  А также метод toString(), который выводит полную информацию об автомобиле, ее водителе и моторе.
 * Создать производный от Car класс  - Lorry (грузовик), характеризуемый также грузоподъемностью кузова.
 * Создать производный от Car класс - SportCar, характеризуемый также предельной скоростью.
 *  Пусть класс Driver расширяет класс Person.
 */

public class CarsApp {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person("John Snow" , 32);
        Car car = new Car();
        System.out.println(car);
    }
}

class Person {
    String fullName;
    int age;

    Person() {
        this.fullName = "Baby";
        this.age = 0;
    }

    Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    void move() {
        System.out.println(fullName + " двигается!");
    }

    void talk() {
        System.out.println(fullName + " говорит!");
    }
}

class Driver extends Person {
    int drivingExperience;
    Driver() {
        super("Johny Cage",32);
        this.drivingExperience = 11;
    }

    Driver(String fullName, int age, int drivingExperience){
        super(fullName,age);
        this.drivingExperience = drivingExperience;
    }
}

class Engine {
    double power;
    String producer;

    Engine() {
        this.producer = "VAZ";
        this.power = 1.2;
    }

    Engine(double power, String producer) {
        this.power = power;
        this.producer = producer;
    }

}

class Car {
    String mark;
    String automobileClass;
    int weight;
    Driver driver;
    Engine engine;

    Car () {
        this("Lada", "Econom-class", 900, new Driver(),  new Engine());
    }
    Car (String mark, String automobileClass, int weight, Driver driver, Engine engine) {
        this.mark = mark;
        this.automobileClass = automobileClass;
        this.weight = weight;
        this.driver = driver;
        this.engine = engine;
    }

    void start() {
        System.out.println("Поехали");
    }

    void stop() {
        System.out.println("Останавливаемся");
    }

    void turnRight() {
        System.out.println("Поворот направо");
    }

    void turnLeft() {
        System.out.println("Поворот налево");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Car information:\n");
        result.append(" - mark - ").append(this.mark).append("\n");
        result.append(" - class - ").append(this.automobileClass).append("\n");
        result.append(" - weight - ").append(this.weight).append("\n");
        result.append("Driver's information:\n");
        result.append(" - full name - ").append(this.driver.fullName).append("\n");
        result.append(" - age - ").append(this.driver.age).append("\n");
        result.append(" - driving experience - ").append(this.driver.drivingExperience).append("\n");
        result.append("Engine information:\n");
        result.append(" - producer - ").append(this.engine.producer).append("\n");
        result.append(" - power - ").append(this.engine.power).append("\n");
        return result.toString();
    }
}

class Lorry extends Car {
    int capacity;
    Lorry() {
       super();
       this.capacity = 0;
    }
    Lorry(String mark, String automobileClass, int weight, Driver driver, Engine engine, int capacity) {
        super(mark, automobileClass, weight , driver, engine);
        this.capacity = capacity;
    }
}

class SportCar extends Car {
    int maxSpeed;
    SportCar() {
        super();
        this.maxSpeed = 300;
    }
    SportCar(String mark, String automobileClass, int weight, Driver driver, Engine engine, int maxSpeed) {
        super(mark, automobileClass, weight , driver, engine);
        this.maxSpeed = maxSpeed;
    }
}

