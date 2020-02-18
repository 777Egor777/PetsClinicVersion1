package ru.lesson;

/**
 * Базовый класс для птиомцев.
 * @author Geraskin Yegor
 * @version 1.1, 18.01.2020
 */
public class Animal implements Pet {
    /**
     * имя животного
     */
    private String name;

    /**
     * Returns a string representation of the object.
     * It has format: title + " " + name
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Животное: " + this.title + " " + this.name;
    }

    /**
     * Порода животного
     */
    private String title;

    /**
     * Конструктор
     */
    public Animal() {}

    /**
     * Конструктор
     * @param name
     * @param title
     */
    public Animal(String name, String title) {
        this.name = name;
        this.title = title;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTitle() {
        return this.title;
    }
}
