package ru.lesson;

/**
 * Базовый интерфейс для всех питомцев
 * @author Geraskin Yegor
 * @version 1.1, 18.01.2020
 */
public interface Pet {
    /**
     * Сеттер для имени питомца
     * @since 1.1
     * @param name имя питомца
     */
    void setName(String name);

    /**
     * Геттер для имени питомца
     * @since 1.1
     * @return имя питомца
     */
    String getName();

    /**
     * Геттер для породы питомца
     * @since 1.1
     * @return порода питомца
     */
    String getTitle();


}