package ru.lesson;

import java.util.HashMap;

/**
 * Клиент клиники
 * @author Geraskin Yegor
 * @version 1.1, 18.01.2020
 */
public class Client {
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        String result = "Имя: " + this.name + ".";

        if (this.pet != null &&
                !(this.pet instanceof Animal)) {
            result += " " + this.pet;
        }

        return result;
    }

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
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Client) {
            Client client = (Client)obj;
            if (client.getName().equals(this.getName()) &&
                client.getPet().equals(this.getPet())) {
                result = true;
            }
        }

        return result;
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
