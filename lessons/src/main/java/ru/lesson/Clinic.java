package ru.lesson;

import java.util.ArrayList;

/**
 * Клиника для домашних питомцев
 * @author Geraskin Yegor
 * @version 1.1, 19.01.2020
 */
public class Clinic {
    /**
     * Список клиентов клиники
     */
    private ArrayList<Client> listOfClients;

    /**
     * Конструктор
     */
    public Clinic() {
        this.listOfClients = new ArrayList<>();
    }

    /**
     * Добавление нового клиента в клинику
     * @param newClient новый клиент
     */
    public void addClient(Client newClient) {
        this.listOfClients.add(newClient);
    }

    public void
}
