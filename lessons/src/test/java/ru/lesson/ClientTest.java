package ru.lesson;

import org.junit.Assert;
import org.junit.Test;

public class ClientTest {

    @Test
    public void getName() {
        Client client = new Client("Albert", new Cat("Murzik"));
        Assert.assertEquals("Albert", client.getName());
    }

    @Test
    public void setName() {
        Client client = new Client("Albert", new Dog("Bobik"));
        client.setName("Vasily");
        Assert.assertEquals("Vasily", client.getName());
    }

    @Test
    public void getPet() {
        Dog bobik = new Dog("Bobik");
        Client client = new Client("Albert", bobik);
        Assert.assertEquals(bobik, client.getPet());
    }

    @Test
    public void setPet() {
        Client client = new Client("Albert", new Dog("Bobik"));
        Popinjay popka = new Popinjay("Popka");
        client.setPet(popka);
        Assert.assertEquals(popka, client.getPet());
    }
}