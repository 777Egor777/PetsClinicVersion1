package ru.lesson;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PopinjayTest {

    @Test
    public void getName() {
        Popinjay popinjay = new Popinjay("Кеша");
        Assert.assertEquals("Кеша", popinjay.getName());
    }

    @Test
    public void getTitle() {
        Popinjay popinjay = new Popinjay("Кеша");
        Assert.assertEquals("попугай", popinjay.getTitle());
    }

    @Test
    public void setName() {
        Popinjay popinjay = new Popinjay("Alyosha");
        popinjay.setName("Vitya");
        Assert.assertEquals("Vitya", popinjay.getName());
    }
}