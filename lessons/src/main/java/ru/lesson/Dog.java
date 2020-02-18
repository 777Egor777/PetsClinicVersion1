package ru.lesson;

/**
 * Собака - один из видов питомцев
 * @author Geraskin Yegor
 * @version 1.1, 18.01.2020
 */
public class Dog implements Pet {
    /**
     * Объект с базовой реализацией интерфейса Pet
     */
    private Pet pet;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return this.pet.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Dog) {
            Dog dog = (Dog)obj;
            if (this.getName().equals(dog.getName())) {
                result = true;
            }
        }

        return result;
    }

    /**
     * Конструктор
     * @param name имя собаки
     */
    public Dog(String name) {
        this.pet = new Animal(name, "собака");
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
