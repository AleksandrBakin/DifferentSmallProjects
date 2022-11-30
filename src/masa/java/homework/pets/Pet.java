package masa.java.homework.pets;

/**
 *  Класс домашних животных
 *    Создайте класс для представления типа Pet в Java, который должен иметь следующие поля:
 *      name -  Переменная экземпляра типа String, которая содержит имя питомца.
 *      animal -  Переменная экземпляра типа String, которая содержит тип животного,
 *          которым является домашнее животное.
 *      age - Переменная экземпляра типа int соответствует возрасту питомца.
 *
 *    Класс Pet также должен иметь следующие методы:
 *      setName - Метод setName хранит значение в поле имени.
 *      setAnimal - Метод setAnimal хранит значение в поле животных.
 *      setAge - Метод setAge сохраняет значение в поле возраста.
 *      getName- Метод getName возвращает значение поля имени.
 *      getAnimal -Метод getAnimal возвращает значение поля животных.
 *      getAge - Метод getAge возвращает значение возрастного поля.
 */

public class Pet {
    private String name;
    private String kind;
    private int age;

    public Pet (String name, String kind ,int age) {
        this.name = name;
        this.kind = kind;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setAge (int age) {
        this.age = age;
    }
    public String getName() {
        return this.name;
    }

    public String getKind() {
        return this.kind;
    }

    public int getAge () {
        return this.age;
    }

}