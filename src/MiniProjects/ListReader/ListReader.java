package MiniProjects.ListReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ListReader {

    public static void main(String[] args) {
        final int elementsNumber = 10;

        //Scanner scanner = new Scanner(System.in); // Через сканнер
        //ArrayList<String> list = new ArrayList<>(); // Для строк через сканер
        //ArrayList<Integer> lisOfInts = new ArrayList<>(); // Для целых чисел через сканер

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Через буфер ридер
        //ArrayList<String> list = new ArrayList<>(); // Для строк через буфер ридер
        ArrayList<Integer> lisOfInts = new ArrayList<>(); // Для целых чисел через буфер ридер


        for(int i = 0; i < elementsNumber ;) {
            //String tmpStr = scanner.nextLine(); // Считываем строку через сканнер
            //String tmpStr = reader.readLine(); // Считываем строку через ридер
            //list.add(tmpStr); i++; // Версия для строк на проверку
            //if (tmpStr.length()>1){ list.add(tmpStr); i++; }// Версия со строками для теста

            //Integer tmpInt = scanner.nextInt(); // Считываем целое число через сканнер
            //Integer tmpInt = Integer.parseInt(reader.readLine()); // Считываем целое число через ридер версия 1
            //Integer tmpInt = reader.read(); // Считываем целое число через ридер версия 2
            //lisOfInts.add(tmpInt); i++; // Версия для целых чисел на проверку
        }
    }

}
