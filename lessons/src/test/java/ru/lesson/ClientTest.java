package ru.lesson;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void getName() {
        Client client = new Client("Albert", new Cat("Murzik"));
        Assert.assertEquals("Murzik", client.getName());
    }

    @Test
    public void setName() {
        Client client = new Client("Albert", new Dog("Bobik"));
        client.setName("Vasily");
        Assert.assertEquals("Vasily", client.getName());
    }

    @Test
    public void getPet() {
        Client client = new Client("Albert", new Dog("Bobik"));
        Assert.assertEquals(true, client.getPet() instanceof Dog);
    }

    @Test
    public void setPet() {
        Client client = new Client("Albert", new Dog("Bobik"));
        client.setPet(new Popinjay("Popka"));
        Assert.assertEquals("Popka", client.getPet().getName());
    }

    @Test
    public void testGetPet() {
        Client client = new Client("Albert", new Dog("Bobik"));
        Assert.assertEquals("Bobik", client.getPet().getName());
    }

    @Test
    public void testSetPet() {
        Client client = new Client("Albert", new Dog("Bobik"));
        client.setPet(new Popinjay("Popka"));
        Assert.assertEquals(true, client.getPet() instanceof Popinjay);
    }
}