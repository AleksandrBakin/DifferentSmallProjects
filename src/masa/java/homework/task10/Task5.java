package masa.java.homework.task10;

public class Task5 {
    public static void main(String[] args) {
        String name, eyes, teeth, hair;
        int age, height, weight;
        double inches2CentimetersRate = 2.54;
        double lbs2KilogramsRate = 0.453592;

        name = "Zed A. Shaw";
        age = 35;     // not a lie
        height = 74;  // inches
        weight = 180; // lbs
        eyes = "Blue";
        teeth = "White";
        hair = "Brown";

        System.out.println( "Let's talk about " + name + "." );
        System.out.println( "He's " + height + " inches (or " + height*inches2CentimetersRate + " cm)tall." ); //187.96
        System.out.println( "He's " + weight + " pounds (or " + weight*lbs2KilogramsRate + " kg) heavy." ); //81.6466266
        System.out.println( "Actually, that's not too heavy." );
        System.out.println( "He's got " + eyes + " eyes and " + hair + " hair." );
        System.out.println( "His teeth are usually " + teeth + " depending on the coffee." );

        // This line is tricky; try to get it exactly right.
        System.out.println( "If I add " + age + ", " + height + ", and " + weight + " I get " + (age + height + weight) + "." );
    }
}
