package MiniProjects.TimeCheck;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class TimeCheck {
    public static int repeat = 10000;

    public static void main(String[] args) {
        // ArrayList
        ArrayList arrayList = new ArrayList();
        long delta=0L;

        Date startTime = new Date();
        insert10000(arrayList);
        Date currentTime = new Date();
        delta = (long) (currentTime.getTime() - startTime.getTime());
        System.out.println("To insert " + repeat + " with ArrayList you need " + delta);

        startTime = new Date();
        get10000(arrayList);
        currentTime = new Date();
        delta = (long) (currentTime.getTime() - startTime.getTime());
        System.out.println("To get " + repeat + " with ArrayList you need " + delta);

        startTime = new Date();
        set10000(arrayList);
        currentTime = new Date();
        delta = (long) (currentTime.getTime() - startTime.getTime());
        System.out.println("To set " + repeat + " with ArrayList you need " + delta);

        startTime = new Date();
        remove10000(arrayList);
        currentTime = new Date();
        delta = (long) (currentTime.getTime() - startTime.getTime());
        System.out.println("To remove " + repeat + " with ArrayList you need " + delta);

        // LinkedList
        LinkedList linkedList = new LinkedList();
        startTime = new Date();
        insert10000(linkedList);
        currentTime = new Date();
        delta = (long) (currentTime.getTime() - startTime.getTime());
        System.out.println("To insert " + repeat + " with LinkedList you need " + delta);

        startTime = new Date();
        get10000(linkedList);
        currentTime = new Date();
        delta = (long) (currentTime.getTime() - startTime.getTime());
        System.out.println("To get " + repeat + " with LinkedList you need " + delta);

        startTime = new Date();
        set10000(linkedList);
        currentTime = new Date();
        delta = (long) (currentTime.getTime() - startTime.getTime());
        System.out.println("To set " + repeat + " with LinkedList you need " + delta);

        startTime = new Date();
        remove10000(linkedList);
        currentTime = new Date();
        delta = (long) (currentTime.getTime() - startTime.getTime());
        System.out.println("To remove " + repeat + " with LinkedList you need " + delta);



    }

    public static void insert10000(List list) {
        //напишите тут ваш код
        for (int i = 0; i < repeat; i++) {
            char c = (char) i;
            list.add(i/2,c);
        }
    }

    public static void get10000(List list) {
        //напишите тут ваш код
        for (int i = 0; i < repeat; i++) {
            list.get(i);
        }
    }

    public static void set10000(List list) {
        //напишите тут ваш код
        for (int i = 0; i < repeat; i++) {
            char c = (char) (i+1);
            list.set( i, c );
        }
    }

    public static void remove10000(List list) {
        //напишите тут ваш код
        for (int i = 0; i < repeat; i++) {
            list.remove(0);
        }
    }
}
