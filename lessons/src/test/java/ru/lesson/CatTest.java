package ru.lesson;

import org.junit.Assert;
import org.junit.Test;

public class CatTest {

    @Test
    public void getName() {
        Cat cat = new Cat("Васька");
        Assert.assertEquals("Васька", cat.getName());
    }

    @Test
    public void getTitle() {
        Cat cat = new Cat("Петька");
        Assert.assertEquals("кот/кошка", cat.getTitle());
    }

    @Test
    public void setName() {
        Cat cat = new Cat("Alyosha");
        Assert.assertEquals("Alyosha", cat.getName());
    }

    @Test
    public void testSetName() {
        Cat cat = new Cat("Alyosha");
        cat.setName("Vitya");
        Assert.assertEquals("Vitya", cat.getName());
    }
}