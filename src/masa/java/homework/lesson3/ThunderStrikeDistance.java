package masa.java.homework.lesson3;

public class ThunderStrikeDistance {
    public static final int soundSpeedFPS = 1100; // feet per second
    public static final double soundSpeedMPS = soundSpeedFPS / 3.281;
    static double timeDelay = 7.2; // secs
    public static final int lightSpeed = 299_792_458; // meters per second
    public static void main(String[] args) {
        double distance = (timeDelay * soundSpeedMPS *lightSpeed) / (lightSpeed - soundSpeedMPS);
        System.out.println(distance);

    }
}
