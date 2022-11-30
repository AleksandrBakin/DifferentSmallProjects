package masa.java.homework.task7;

public class App {
    public static void main(String[] args) {
        Phone myPhone = new Phone(123, "iPhone 11 Pro Max", 0.35);
        myPhone.GetModel();
        myPhone.GetNumber();
        myPhone.GetWeight();

    }

    public static class Phone {
        long number;
        String model;
        double weight;

        public Phone(long number, String model, double weight) {
            this.number = number;
            this.model = model;
            this.weight = weight;
        }

        public void GetNumber() {
            System.out.println(this.number);
        }

        public void GetModel() {
            System.out.println(this.model);
        }

        public void GetWeight() {
            System.out.println(this.weight);
        }
    }
}
