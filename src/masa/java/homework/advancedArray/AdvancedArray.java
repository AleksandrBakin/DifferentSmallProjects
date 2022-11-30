package masa.java.homework.advancedArray;

import java.util.Arrays;

/**
 * Создать класс AdvancedArray который будет позволять динамичную работу с массивами.
 * Класс должен поддерживать сл. методы
 *  - void createArray(int size) - инициализирует массив нулями с величиной size
 *  - void setArray(int [] array) - инициализирует массив числами заданными в инпуте метода
 *  - int size() - возвращает размер массива
 *  - void add(int el) - добавляет елемент в конец массива
 *  - void remove(int index) - Удаляет элемент в указанной позиции в этом списке.
 *          Смещает любые последующие элементы влево ( вычитает один из их индексов )
 *  - int get(int index) - Возвращает элемент в указанной позиции в этом списке.
 *  - void printArray() - печатает массив в терминал
 */

public class AdvancedArray {
    private int[] advancedArray;
    private int advancedArraySize = 0;

    public void createArray(int size) {
        this.advancedArray = new int[size];
        Arrays.fill(this.advancedArray,0);
        this.advancedArraySize = size;
    }

    public void setArray(int [] array) {
        if((this.advancedArray == null)||(this.advancedArray.length < array.length)) {
            this.advancedArray = new int[array.length];
        }
        for (int i = 0; i < array.length; i++) {
            this.advancedArray[i] = array[i];
        }
        this.advancedArraySize = array.length;
    }

    public int size() {
        return this.advancedArraySize;
    }

    public void add(int el) {
        if (this.advancedArray == null) this.advancedArray = new int[1];
        if(this.advancedArraySize==advancedArray.length) {
            this.advancedArray = Arrays.copyOf(this.advancedArray, (int)(advancedArray.length*1.5+1));
        }
        this.advancedArray[this.advancedArraySize++] = el;
    }

    public void remove(int index) {
        //if(index>=this.advancedArraySize) throw new IndexOutOfBoundsException();
        for (int i = index+1; i < this.advancedArraySize; i++) {
            this.advancedArray[i-1] = this.advancedArray[i];
        }
        this.advancedArraySize--;
    }

    public int get(int index) {
        if(index>=this.advancedArraySize) throw new IndexOutOfBoundsException();
        return this.advancedArray[index];
    }

    public void printArray() {
        System.out.println("What user can see, and use"); // just for me
        System.out.println(Arrays.toString(Arrays.copyOfRange(this.advancedArray,0,this.advancedArraySize)));
        System.out.println("What is really inside advanced array"); // just for me
        System.out.print(Arrays.toString(Arrays.copyOfRange(this.advancedArray,0,this.advancedArraySize)));  // just for me
        System.out.print(" "); // just for me
        System.out.println(Arrays.toString(Arrays.copyOfRange(this.advancedArray,this.advancedArraySize,advancedArray.length)));  // just for me
    }
}
