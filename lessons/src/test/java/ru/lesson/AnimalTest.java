package ru.lesson;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void getName() {
        Animal animal = new Animal("petka", "orangytan");
        Assert.assertEquals("petka", animal.getName());
    }

    @Test
    public void getTitle() {
        Animal animal = new Animal("petka", "orangytan");
        Assert.assertEquals("orangytan", animal.getTitle());
    }

    @Test
    public void setName() {
        Animal animal = new Animal("kesha", "poppinjee");
        Assert.assertEquals("kesha", animal.getName());
    }

    @Test
    public void testSetName() {
        Animal animal = new Animal("kesha", "poppinjee");
        animal.setName("popka");
        Assert.assertEquals("popka", animal.getName());
    }
}