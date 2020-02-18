package ru.lesson;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClinicRunner {
    /**
     * Строка вывода главного
     * меню программы
     */
    private static final String MENU_MAIN =
            "Главное меню.\n" +
            "[1]Вывести список клиентов\n" +
            "[2]Добавить клиента\n" +
            "[3]Найти клиента по имени\n" +
            "[4]Найти питомца по имени\n" +
            "[5]Редактировать имя клиента\n" +
            "[6]Редактировать имя питомца\n" +
            "[7]Добавление/изменение питомца у клиента\n" +
            "[8]Удалить клиента\n" +
            "[9]Удалить питомца\n" +
            "[10]Выйти из программы\\";

    /**
     * Строка вывода меню Да/Нет
     */
    private static final String MENU_YES_NO =
            "[1]Да\n" +
            "[2]Нет";

    private static final String MENU_TYPE_OF_PET_CHOICE =
            "[1]Кот\\кошка\n" +
            "[2]Собака\n" +
            "[3]Попугай";

    /**
     * Точка входа программы
     * Зацикливаем вывод меню
     * @param args
     */
    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        System.setProperty("console.encoding","Cp866");
        PrintStream out = System.out;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            in = new BufferedReader(new InputStreamReader(System.in, "Cp866"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        while (runMainMenu(out, in, clinic)){}
    }

    public static boolean canParseNumber(String isItNumber) {
        boolean result = true;

        try {
            Integer.parseInt(isItNumber);
        } catch (NumberFormatException exception) {
            result = false;
        }

        return result;
    }

    public static int runInteractScanNumberFromRangeProcess(PrintStream out, BufferedReader in, int leftBound, int rightBound) {
        int result = 0;
        if (leftBound == rightBound) {
            result = leftBound;
        } else {
            while (true) {
                out.print("Введите число от " + leftBound + " до " + rightBound + ": ");
                String line = null;
                try {
                    line = in.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (canParseNumber(line)) {
                    int number = Integer.parseInt(line);
                    if (number >= leftBound && number <= rightBound) {
                        result = number;
                        break;
                    }
                }
            }
        }

        return result;
    }

    /**
     * Выводит главное меню,
     * считывает число от 1 до 10
     * Запускает выполнение меню для этого пункта
     * Возвращает true, если надо продолжить выполнение программы
     * Возаращает false, если надо завершить выполнение программы
     * @param out Объект для вывода типа PrintStream
     * @param in Объект для ввода типа BufferedReader
     * @param clinic Объект клиники типа Cinic
     * @return см. описание метода выше
     */
    public static boolean runMainMenu(PrintStream out, BufferedReader in, Clinic clinic) {
        boolean result;
        out.println(MENU_MAIN);
        int menuItemNumber = runInteractScanNumberFromRangeProcess(out, in, 1, 10);
        switch(menuItemNumber) {
            case 1: result = runPrintAllProcess(out, in, clinic); break;
            case 2: result = runAddClientProcess(out, in, clinic); break;
            case 3: result = runSearchClientsByNameProcess(out, in, clinic); break;
            case 4: result = runSearchClientsByPetNameProcess(out, in, clinic); break;
            case 5: result = runRenameClientProcess(out, in, clinic); break;
            case 6: result = runRenamePetProcess(out, in, clinic); break;
            case 7: result =  runAddOrChangePetProcess(out, in, clinic); break;
            case 8: result = runDeleteClientProcess(out, in, clinic); break;
            case 9: result = runDeletePetProcess(out, in, clinic); break;
            case 10: result = false; break;
            default: result = false; break;
        }
        return result;
    }

    public static boolean runYesOrNotProcess(PrintStream out, BufferedReader in) {
        boolean result = true;
        out.println(MENU_YES_NO);
        int menuItemNumber = runInteractScanNumberFromRangeProcess(out, in, 1, 2);
        switch (menuItemNumber) {
            case 1: break;
            case 2: result = false; break;
            default: break;
        }
        return result;
    }

    public static boolean runEndProgramOrNotProcess(PrintStream out, BufferedReader in) {
        out.println("\nЗавершить выполнение программы?");
        return !runYesOrNotProcess(out, in);
    }

    /**
     * Выводит список всех клиентов
     * Возвращает true, если надо продолжить выполнение программы
     * Возаращает false, если надо завершить выполнение программы
     * @param out Объект PrintStream потока для вывода
     * @param clinic Клиника, клиентов которой выводим
     * @return cм. описание выше
     */
    public static boolean runPrintAllProcess(PrintStream out, BufferedReader in, Clinic clinic) {
        out.println(clinic);
        return runEndProgramOrNotProcess(out, in);
    }

    /**
     * Считывает и добавляет клиента
     * в список клиники
     * Может добавить клиента как
     * с животным, так и без
     * Возвращает true, если надо продолжить выполнение программы
     * Возаращает false, если надо завершить выполнение программы
     * @param out объект PrintStream потока для вывода
     * @param in объект BufferedReader потока для ввода
     * @param clinic объект Clinic клиники домашних питомцев
     * @return см. описание выше
     */
    public static boolean runAddClientProcess(PrintStream out, BufferedReader in, Clinic clinic) {
        out.print("Введите имя клиента: ");
        String clientName = null;
        try {
            clientName = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Pet pet = new Animal("", "");

        out.println("Указать какое у клиента животное?");
        if (runYesOrNotProcess(out, in)) {
            pet = runInteractPetScanProcess(out, in);
        }

        clinic.addClient(new Client(clientName, pet));

        return runEndProgramOrNotProcess(out, in);
    }

    public static Pet runInteractPetScanProcess(PrintStream out, BufferedReader in) {
        Pet result = null;
        out.println(MENU_TYPE_OF_PET_CHOICE);
        int answer = runInteractScanNumberFromRangeProcess(out, in, 1, 3);
        out.print("Введите имя животного: ");
        String petName = null;
        try {
            petName = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (answer) {
            case 1: result = new Cat(petName); break;
            case 2: result = new Dog(petName); break;
            case 3: result = new Popinjay(petName); break;
            default: break;
        }

        return result;
    }

    /**
     * Запускает процесс поиска клиента
     * по имени, и выполнения затем
     * действий над ним
     * Возвращает true, если надо продолжить выполнение программы
     * Возаращает false, если надо завершить выполнение программы
     * @param out объект PrintStream потока для вывода
     * @param in объект BufferedReader потока для ввода
     * @param clinic объект Clinic клиники домашних питомцев
     * @return см. описание выше
     */
    public static boolean runSearchClientsByNameProcess(PrintStream out, BufferedReader in, Clinic clinic) {
        out.print("Введите имя искомого клиента: ");
        String clientName = null;
        try {
            clientName = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Client> clients = clinic.findClientByName(clientName);
        if (clients.isEmpty()) {
            out.println("Клиентов клиники с таким именем не найдено!");
        } else {
            out.println("Найденные совпадения:");
            int counter = 0;
            for(Client client : clients) {
                out.print("#" + counter++ + ". " + client + "\n\n");
            }
        }

        return runEndProgramOrNotProcess(out, in);
    }

    /**
     * Запускает процесс поиска клиента
     * по имени питомца, и выполнения
     * затем действий над ним
     * Возвращает true, если надо продолжить выполнение программы
     * Возаращает false, если надо завершить выполнение программы
     * @param out объект PrintStream потока для вывода
     * @param in объект BufferedReader потока для ввода
     * @param clinic объект Clinic клиники домашних питомцев
     * @return см. описание выше
     */
    public static boolean runSearchClientsByPetNameProcess(PrintStream out, BufferedReader in, Clinic clinic) {
        out.print("Введите имя искомого питомца: ");
        String petName = null;
        try {
            petName = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Client> clients = clinic.findClientByPetName(petName);
        if (clients.isEmpty()) {
            out.println("Питомцев с таким именем не найдено!");
        } else {
            out.println("Найденные совпадения:");
            int counter = 0;
            for(Client client : clients) {
                out.print("#" + counter++ + ". " + client + "\n\n");
            }
        }

        return runEndProgramOrNotProcess(out, in);

    }

    /**
     * Запускает процесс переименования клиента
     * Возвращает true, если надо продолжить выполнение программы
     * Возаращает false, если надо завершить выполнение программы
     * @param out объект PrintStream потока для вывода
     * @param in объект BufferedReader потока для ввода
     * @param clinic объект Clinic клиники домашних питомцев
     * @return см. описание выше
     */
    public static boolean runRenameClientProcess(PrintStream out, BufferedReader in, Clinic clinic) {
        out.println(clinic);
        int numberOfClients = clinic.getNumberOfClients();
        int indexOfClientToRename = runInteractScanNumberFromRangeProcess(out, in, 0, numberOfClients - 1);
        out.print("Введите новое имя клиента: ");
        String newClientName = null;
        try {
            newClientName = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        clinic.changeClientName(indexOfClientToRename, newClientName);

        return runEndProgramOrNotProcess(out, in);
    }

    /**
     * Запускает процесс переименвоания
     * питомца
     * Возвращает true, если надо продолжить выполнение программы
     * Возаращает false, если надо завершить выполнение программы
     * @param out объект PrintStream потока для вывода
     * @param in объект BufferedReader потока для ввода
     * @param clinic объект Clinic клиники домашних питомцев
     * @return см. описание выше
     */
    public static boolean runRenamePetProcess(PrintStream out, BufferedReader in, Clinic clinic) {
        out.println(clinic);
        int numberOfClients = clinic.getNumberOfClients();
        int indexOfClientToRename = runInteractScanNumberFromRangeProcess(out, in, 0, numberOfClients - 1);
        out.print("Введите новое имя питомца: ");
        String newPetName = null;
        try {
            newPetName = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        clinic.changePetName(indexOfClientToRename, newPetName);

        return runEndProgramOrNotProcess(out, in);
    }

    /**
     * Запускает процесс добавления
     * или переименования питомца
     * у уже существующего клиента
     * Возвращает true, если надо продолжить выполнение программы
     * Возаращает false, если надо завершить выполнение программы
     * @param out объект PrintStream потока для вывода
     * @param in объект BufferedReader потока для ввода
     * @param clinic объект Clinic клиники домашних питомцев
     * @return см. описание выше
     */
    public static boolean runAddOrChangePetProcess(PrintStream out, BufferedReader in, Clinic clinic) {
        out.println(clinic);
        int numberOfClients = clinic.getNumberOfClients();
        int indexOfClientToChangePet = runInteractScanNumberFromRangeProcess(out, in, 0, numberOfClients - 1);
        Pet newPet = runInteractPetScanProcess(out, in);
        clinic.changeClientPet(indexOfClientToChangePet, newPet);

        return runEndProgramOrNotProcess(out, in);
    }

    /**
     * Запускает процесс удаления
     * клиента
     * Возвращает true, если надо продолжить выполнение программы
     * Возаращает false, если надо завершить выполнение программы
     * @param out объект PrintStream потока для вывода
     * @param in объект BufferedReader потока для ввода
     * @param clinic объект Clinic клиники домашних питомцев
     * @return см. описание выше
     */
    public static boolean runDeleteClientProcess(PrintStream out, BufferedReader in, Clinic clinic) {
        out.println(clinic);
        int numberOfClients = clinic.getNumberOfClients();
        int indexOfClientToDelete = runInteractScanNumberFromRangeProcess(out, in, 0, numberOfClients - 1);
        Client client = clinic.getClientOnPos(indexOfClientToDelete);
        clinic.deleteClient(indexOfClientToDelete);
        out.println(String.format("Клиент \"%s\" удален", client.getName()));

        return runEndProgramOrNotProcess(out, in);
    }

    /**
     * Запускает процесс удаления
     * питомца
     * Возвращает true, если надо продолжить выполнение программы
     * Возаращает false, если надо завершить выполнение программы
     * @param out объект PrintStream потока для вывода
     * @param in объект BufferedReader потока для ввода
     * @param clinic объект Clinic клиники домашних питомцев
     * @return см. описание выше
     */
    public static boolean runDeletePetProcess(PrintStream out, BufferedReader in, Clinic clinic) {
        out.println(clinic);
        int numberOfClients = clinic.getNumberOfClients();
        int indexOfClientToDeletePet = runInteractScanNumberFromRangeProcess(out, in, 0, numberOfClients - 1);
        Client client = clinic.getClientOnPos(indexOfClientToDeletePet);
        out.println(String.format("Питомец %s клиента %s удалён",
                client.getPet().getName(), client.getName()));
        clinic.deletePet(indexOfClientToDeletePet);

        return runEndProgramOrNotProcess(out, in);
    }
}
