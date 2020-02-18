package ru.lesson;

import javafx.scene.chart.AxisBuilder;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Клиника для домашних питомцев
 * @author Geraskin Yegor
 * @version 1.1, 19.01.2020
 */
public class Clinic {
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        String result = "";

        if (this.isEmpty()) {
            result = "Нет клиентов!";
        } else {
            result = "Список клиентов:\n";

            for(int counter = 0; counter < this.listOfClients.size() - 1; ++counter) {
                result += "#" + counter++ + ". " + this.listOfClients.get(counter) + "\n";
            }

            result += "#" + (this.listOfClients.size() - 1) + ". " +
                      this.listOfClients.get(this.listOfClients.size() -1);
        }

        return result;
    }

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
     * Геттер для списка клиентов
     * @return
     */
    public ArrayList<Client> getListOfClients() {
        return this.listOfClients;
    }

    /**
     * Проверка клиники на пустоту
     * @return Если есть хотя бы один клиент -
     * - возвращает true, иначе false
     */
    public boolean isEmpty() {
        return this.listOfClients.isEmpty();
    }

    /**
     * Возвращает клиента по индексу
     * @param index позиция клиента в списке
     * @return возвращает клиента,
     *         находящегося на этой позиции
     */
    public Client getClientOnPos(int index) {
        return this.listOfClients.get(index);
    }

    /**
     * @return число клиентов клиники
     */
    public int getNumberOfClients() {
        return this.listOfClients.size();
    }

    /**
     * Добавление нового клиента в клинику
     * @param newClient новый клиент
     */
    public void addClient(Client newClient) {
        this.listOfClients.add(newClient);
    }

    /**
     * Изменение питомца у клиента
     * @param clientIndex индекс клиента в списке записей
     * @param newPet новое животное клиента
     */
    public void changeClientPet(int clientIndex, Pet newPet) {
        this.listOfClients.get(clientIndex).setPet(newPet);
    }

    /**
     * Возвращает список клиентов с таким именем
     * @param name имя искомого клиента
     * @return список клиентов с именем <code>name</code>
     */
    public ArrayList<Client> findClientByName(String name) {
        ArrayList<Client> clients = new ArrayList<>();
        for(Client client : this.listOfClients) {
            if (client.getName().equals(name)) {
                clients.add(client);
            }
        }

        return clients;
    }

    /**
     * Возвращает список клиентов,
     * питомцев которых зовут <code>name</code>
     * @param petName имя питомца
     * @return список клиентов, имя питоца
     *         которых <code>petName</code>
     */
    public ArrayList<Client> findClientByPetName(String petName) {
        ArrayList<Client> clients = new ArrayList<>();
        for(Client client : this.listOfClients) {
            if (client.getPet().getName().equals(petName)) {
                clients.add(client);
            }
        }

        return clients;
    }

    /**
     * Изменяет имя клиента
     * в записи с индексом index
     * @param index индекс записи
     * @param newName новое имя клиента
     */
    public void changeClientName(int index, String newName) {
        this.listOfClients.get(index).setName(newName);
    }

    /**
     * Изменяет имя питомца клиента
     * в записи с индексом index
     * @param index номер записи
     * @param newPetName новое имя питомца
     */
    public void changePetName(int index, String newPetName) {
        this.listOfClients.get(index).getPet().setName(newPetName);
    }

    /**
     * Удаляет клиента в позиции index
     * @param index позиция удаляемого клиента
     *              в списке
     */
    public void deleteClient(int index) {
        this.listOfClients.remove(index);
    }

    /**
     * Удаляет питомца у клиента
     * в позиции index
     * @param index позиция в списке клиента,
     *              у которого удаляем питомца
     */
    public void deletePet(int index) {
        this.changeClientPet(index, new Animal("", ""));
    }

}
