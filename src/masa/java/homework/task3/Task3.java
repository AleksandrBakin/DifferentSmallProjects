package masa.java.homework.task3;

public class Task3 {
    public static void main(String[] args) {
        int cars, drivers, passengers, cars_not_driven, cars_driven;
        double space_in_a_car, carpool_capacity, average_passengers_per_car;

        cars = 100;
        space_in_a_car = 4.0;
        drivers = 30;
        passengers = 90;
        cars_not_driven = cars - drivers;
        cars_driven = drivers;
        carpool_capacity = cars_driven * space_in_a_car;
        average_passengers_per_car = passengers / cars_driven;

        System.out.printf("There are %d cars available.%n",cars);
        System.out.printf("There are only %d drivers available.%n",drivers);
        System.out.printf("There will be %d empty cars today.%n",cars_not_driven);
        System.out.println("We can transport " + carpool_capacity + " people today.");
        System.out.printf("We have %d to carpool today.%n",passengers);
        System.out.println("We need to put about " + average_passengers_per_car + " in each car.");

    }
}
