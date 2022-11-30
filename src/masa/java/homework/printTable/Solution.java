package masa.java.homework.printTable;

public class Solution {
    public static void main(String[] args) {
        String[] teachers = new String[8];
        String[] courses = new String[8];
        teachers[0] = "Albert Einstein";
        teachers[1] = "Nikola Tesla";
        teachers[2] = "Elon Musk";
        teachers[3] = "Steve Jobs";
        teachers[4] = "Stephen Wozniak";
        teachers[5] = "Sheldon Cooper";
        teachers[6] = "Elton John";
        teachers[7] = "Michael Jackson";
        courses[0] = "Physics 87";
        courses[1] = "Physics 3";
        courses[2] = "How to become a billionaire";
        courses[3] = "Design in technologies";
        courses[4] = "Computer science";
        courses[5] = "Big bang theory";
        courses[6] = "Singing";
        courses[7] = "Dancing";
        int maxWidthOfTeachersNames = 0;
        int maxWidthOfCoursesNames = 0;
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i].length() > maxWidthOfTeachersNames)
                maxWidthOfTeachersNames = teachers[i].length();
        }
        for (int i = 0; i < courses.length; i++) {
            if (courses[i].length() > maxWidthOfCoursesNames)
                maxWidthOfCoursesNames = courses[i].length();
        }
        int numberColumnWidth = String.valueOf(teachers.length + 1).length() + 2;
        int ourTableWidth = 4 + numberColumnWidth + maxWidthOfTeachersNames + 4 + maxWidthOfCoursesNames + 4;
        System.out.println("+" + "-".repeat(ourTableWidth - 2) + "+");
        for (int i = 0; i < teachers.length; i++) {
            System.out.println("|" + " ".repeat(numberColumnWidth - 1 - String.valueOf(i + 1).length()) + (i + 1) + " "
                    + "|" + "  " + " ".repeat(maxWidthOfCoursesNames - courses[i].length()) + courses[i] + "  "
                    + "|" + "  " + " ".repeat(maxWidthOfTeachersNames - teachers[i].length()) + teachers[i] + "  "
                    + "|");
        }
        System.out.println("+" + "-".repeat(ourTableWidth - 2) + "+");
    }

    // надо заменить нерабочуюю функцию repeat
}
