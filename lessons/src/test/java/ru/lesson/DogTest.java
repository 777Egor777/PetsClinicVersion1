package ru.lesson;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DogTest {

    @Test
    public void getName() {
        Dog dog = new Dog("Бобик");
        Assert.assertEquals("Бобик", dog.getName());
    }

    @Test
    public void getTitle() {
        Dog dog = new Dog("Шарик");
        Assert.assertEquals("собака", dog.getTitle());
    }

    @Test
    public void setName() {
        Dog dog = new Dog("Alyosha");
        dog.setName("Vitya");
        Assert.assertEquals("Vitya", dog.getName());
    }
}