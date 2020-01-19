package ru.lesson;

/**
 * Кот - один из видов питомцев
 * @author Geraskin Yegor
 * @version 1.1, 18.01.2020
 */
public class Cat implements Pet {
    /**
     * Объект с базовой реализацией интерфейса Pet
     */
    private Pet pet;

    public Cat(String name) {
        Pet pet = new Animal(name, "кот/кошка");
    }

    /**
     * Сеттер для имени питомца
     *
     * @param name имя питомца
     * @since 1.1
     */
    @Override
    public void setName(String name) {
        pet.setName(name);
    }

    /**
     * Геттер для имени питомца
     *
     * @return имя питомца
     * @since 1.1
     */
    @Override
    public String getName() {
        return pet.getName();
    }

    /**
     * Геттер для породы питомца
     *
     * @return порода питомца
     * @since 1.1
     */
    @Override
    public String getTitle() {
        return pet.getTitle();
    }
}
