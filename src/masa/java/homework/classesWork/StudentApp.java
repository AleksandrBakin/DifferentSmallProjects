package masa.java.homework.classesWork;

import java.io.File;
import java.util.Arrays;

/**
 * Создайте пример наследования, реализуйте класс Student и класс Aspirant,
 * аспирант отличается от студента наличием некой научной работы.
 * Класс Student содержит переменные: String firstName, lastName, group.
 * А также,double averageMark, содержащую среднюю оценку.
 * Создать переменную типа Student, которая ссылается на объект типа Aspirant.
 * Создать метод getScholarship() для класса Student,
 * который возвращает сумму стипендии.
 * Если средняя оценка студента равна 5, то сумма 100 $, иначе 80.
 * Переопределить этот метод в классе Aspirant.
 * Если средняя оценка аспиранта равна 5, то сумма 200 $, иначе 180.
 * Создать массив типа Student, содержащий объекты класса Student и Aspirant.
 * Вызвать метод getScholarship() для каждого элемента массива.
 */

public class StudentApp {
    public static void main(String[] args) {
        int numberOfStudents = 30;
        Student[] universityGroup = new Student[numberOfStudents];
        for (int i = 0; i < universityGroup.length; i++) {
            int rand = (int)(Math.random()*12);
            if(rand%4 == 0) {
                universityGroup[i] = new Student();
            } else if(rand%4 == 1) {
                universityGroup[i] = new Student("Jim","Brown","Group1", 5,5,5,5,5);
            } else if(rand%4 == 2) {
                universityGroup[i] = new Aspirant();
            } else {
                universityGroup[i] = new Aspirant("Jack","Black","Group1", 5,5,5,5,5);
            }
        }
        for (int i = 0; i < universityGroup.length; i++) {
            System.out.printf("This is %s %s from group \"%s\"%n", universityGroup[i].firstName, universityGroup[i].lastName, universityGroup[i].group);
            System.out.printf("He is %s with scholarship %d $ %n",universityGroup[i].getClass().getSimpleName(), universityGroup[i].getScholarship());
        }
    }
}

class Student {
    String firstName;
    String lastName;
    String group;
    double averageMark;
    private static final int BASIC_SCHOLARSHIP = 80;
    private static final int HIGH_SCHOLARSHIP = 100;

    Student() {
        this("John","Smith","Unknown group", 1,2,3,4,5);
    }

    Student (String firstName,String lastName,String group, int... marks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        int average = 0;
        for (int mark: marks) {
            average += mark;
        }
        this.averageMark = (double) average / marks.length;
    }

    public int getScholarship() {
        if(this.averageMark == 0) return 0;
        if (this.averageMark == 5) return HIGH_SCHOLARSHIP;
        else return BASIC_SCHOLARSHIP;
    }
}

class Aspirant extends Student {
    File scientificWork;
    private static final int BASIC_SCHOLARSHIP = 180;
    private static final int HIGH_SCHOLARSHIP = 200;

    Aspirant() {
        super();
        this.scientificWork = new File("EmptyFile");
    }

    Aspirant(String firstName, String lastName, String group, int... marks) {
        super(firstName, lastName, group, marks);
        this.scientificWork = new File("EmptyFile");
    }

    Aspirant(String firstName, String lastName, String group,File scientificWork) {
        super(firstName, lastName, group);
        this.scientificWork = scientificWork;
    }

    Aspirant(String firstName, String lastName, String group,String scientificWorkFileName) {
        super(firstName, lastName, group);
        this.scientificWork = new File(scientificWorkFileName);
    }

    @Override
    public int getScholarship() {
        if(this.averageMark == 0) return 0;
        if (this.averageMark == 5) return HIGH_SCHOLARSHIP;
        else return BASIC_SCHOLARSHIP;
    }
}