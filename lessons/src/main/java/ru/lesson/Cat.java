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
        if (obj instanceof Cat) {
            Cat cat = (Cat)obj;
            if (this.getName().equals(cat.getName())) {
                result = true;
            }
        }

        return result;
    }

    /**
     * Конструктор
     * @param name имя кота/кошки
     */
    public Cat(String name) {
        this.pet = new Animal(name, "кот/кошка");
    }

    /**
     * Сеттер для имени питомца
     *
     * @param name имя питомца
     * @since 1.1
     */
    @Override
    public void setName(String name) {
        this.pet.setName(name);
    }

    /**
     * Геттер для имени питомца
     *
     * @return имя питомца
     * @since 1.1
     */
    @Override
    public String getName() {
        return this.pet.getName();
    }

    /**
     * Геттер для породы питомца
     *
     * @return порода питомца
     * @since 1.1
     */
    @Override
    public String getTitle() {
        return this.pet.getTitle();
    }
}
