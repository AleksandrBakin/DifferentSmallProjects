package masa.java.homework.employee;

import java.util.ArrayList;

/**
 * Напишите программу, создав класс «Employee», имеющий следующие методы, и распечатайте окончательную зарплату.
 * getInfo(), который принимает имя сотрудника в качестве параметра и печатает зарплату, количество часов работы в день сотрудника
 * AddSal(), которая добавляет 10 долларов к зарплате сотрудника, если она меньше 500 долларов.
 * AddWork(), которая добавляет $5 к зарплате сотрудника, если количество часов работы в день превышает 6 часов.
 */

public class Solution {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.AddSal();
        employee.AddSal();
        employee.AddSal();

        employee.AddWork();
        employee.AddWork();
        employee.AddWork();
        employee.getInfo("arthur conan doil");

    }

    public static class Employee {
        double salary;
        int workHours;

        public Employee () {
            int vacancyLevel = (int) (Math.random()*5) + 1; // lvl 1 - 100-200$ / lvl 2 - 200-300$ / lvl 5 - 500-600$
            this.salary = Math.random() * 100.0 + (100 * vacancyLevel);
            this.workHours = (int) (Math.random()*10) + 2; // work hours from 2 to 12
        }

        public void getInfo(String name) {
            if(name.contains(" ")){
                ArrayList<Integer> spaceIndexes = new ArrayList<>(1);
                for (int i = 0; i < name.length(); i++) {
                    if(name.charAt(i)==' '){ spaceIndexes.add(i); }
                }
                for (Integer nextSpaceIndex: spaceIndexes) {
                    name = name.substring(0,nextSpaceIndex+1) +
                            Character.toUpperCase(name.charAt(nextSpaceIndex+1))  + name.substring(nextSpaceIndex+2);
                }
            }
            name = Character.toUpperCase(name.charAt(0))  +name.substring(1);
            System.out.println(name+"'s salary is " + this.salary + "$.");
            System.out.println("He/She works " + this.workHours + " hours per day!");
        }
        public void AddSal() {
            if (this.salary<500) this.salary+=10;
        }
        public void AddWork() {
            if(this.workHours>6) this.salary+=5;
        }
    }
}
