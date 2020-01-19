package ru.lesson;

/**
 * Базовый класс для птиомцев.
 * @author Geraskin Yegor
 * @version 1.1, 18.01.2020
 */
public class Animal implements Pet {
    /**
     * Имя животного
     */
    private String name;

    /**
     * Порода животного
     */
    private String title;

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
