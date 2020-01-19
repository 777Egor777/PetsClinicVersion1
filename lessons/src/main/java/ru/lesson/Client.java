package ru.lesson;

/**
 * Клиент клиники
 * @author Geraskin Yegor
 * @version 1.1, 18.01.2020
 */
public class Client {
    /**
     * Имя клиента
     */
    private String name;

    /**
     * Геттер для имени клиента
     * @return name - имя клиента
     */
    public String getName() {
        return this.name;
    }

    /**
     * Сеттер для имени клиента
     * @param name - устанавливаемое имя клиента
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Питомец клиента
     */
    private Pet pet;

    /**
     * Геттер для питомца клиента
     * @return pet - возвращаемый питомец клиента
     */
    public Pet getPet() {
        return this.pet;
    }

    /**
     * Сеттер для питомца клиента
     * @param pet - устанавливаемый питомец клиента
     */
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    /**
     * Конструктор
     * @param name задавамое имя клиента
     * @param pet задаваемый питомец клиента
     */
    public Client(String name, Pet pet) {
        this.name = name;
        this.pet = pet;
    }
}
