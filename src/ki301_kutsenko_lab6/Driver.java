package ki301_kutsenko_lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Главный класс программы для управления вагонами грузов и пассажиров.
 *
 ** Содержит меню взаимодействия через консоль, где пользователь может:
 * <ul>
 * <li>Создать до 3 вагонов для грузов и пассажиров</li>
 * <li>Добавлять грузы и пассажиров в вагоны</li>
 * <li>Просматривать содержимое вагонов</li>
 * <li>Искать максимальный элемент (груз по весу или пассажир по возрасту)</li>
 * <li>Завершить программу</li>
 * </ul>
 */
public class Driver 
{
	/**
     * Точка входа в программу.
     * 
     * @param args аргументы командной строки (не используются).
     */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        List<Wagon<Cargo>> cargoWagons = new ArrayList<>();
        List<Wagon<Passenger>> passengerWagons = new ArrayList<>();

        System.out.println("Добро пожаловать в систему управления вагонами!");
        System.out.println("Вы можете создать до 3 вагонов каждого типа.");

        // Создание вагонов для грузов
        System.out.println("Сколько вагонов для грузов вы хотите создать? (1-3)");
        int numCargoWagons = getValidNumber(scanner, 1, 3);
        for (int i = 0; i < numCargoWagons; i++) 
        {
            cargoWagons.add(new Wagon<>());
        }

        // Создание вагонов для пассажиров
        System.out.println("Сколько вагонов для пассажиров вы хотите создать? (1-3)");
        int numPassengerWagons = getValidNumber(scanner, 1, 3);
        for (int i = 0; i < numPassengerWagons; i++) 
        {
            passengerWagons.add(new Wagon<>());
        }

        boolean running = true;
        while (running) 
        {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить груз в вагон");
            System.out.println("2. Добавить пассажира в вагон");
            System.out.println("3. Показать содержимое вагонов");
            System.out.println("4. Найти максимальный элемент в вагоне");
            System.out.println("5. Выйти");

            int choice = getValidNumber(scanner, 1, 5);

            switch (choice) 
            {
                case 1 -> 
                {
                    System.out.println("Выберите вагон для грузов (1-" + cargoWagons.size() + "):");
                    int wagonIndex = getValidNumber(scanner, 1, cargoWagons.size()) - 1;
                    System.out.println("Введите название груза:");
                    String cargoName = scanner.nextLine();
                    System.out.println("Введите вес груза:");
                    int cargoWeight = getValidNumber(scanner, 1, Integer.MAX_VALUE);
                    cargoWagons.get(wagonIndex).addItem(new Cargo(cargoName, cargoWeight));
                    System.out.println("Груз добавлен.");
                }
                case 2 ->
                {
                    System.out.println("Выберите вагон для пассажиров (1-" + passengerWagons.size() + "):");
                    int wagonIndex = getValidNumber(scanner, 1, passengerWagons.size()) - 1;
                    System.out.println("Введите имя пассажира:");
                    String passengerName = scanner.nextLine();
                    System.out.println("Введите возраст пассажира:");
                    int passengerAge = getValidNumber(scanner, 1, 150);
                    passengerWagons.get(wagonIndex).addItem(new Passenger(passengerName, passengerAge));
                    System.out.println("Пассажир добавлен.");
                }
                case 3 -> 
                {
                    System.out.println("\nСодержимое вагонов для грузов:");
                    for (int i = 0; i < cargoWagons.size(); i++) 
                    {
                        System.out.println("Вагон " + (i + 1) + ":");
                        cargoWagons.get(i).displayItems();
                    }
                    System.out.println("\nСодержимое вагонов для пассажиров:");
                    for (int i = 0; i < passengerWagons.size(); i++) 
                    {
                        System.out.println("Вагон " + (i + 1) + ":");
                        passengerWagons.get(i).displayItems();
                    }
                }
                case 4 -> 
                {
                    System.out.println("1. Найти максимальный груз");
                    System.out.println("2. Найти самого старшего пассажира");
                    int typeChoice = getValidNumber(scanner, 1, 2);
                    if (typeChoice == 1) 
                    {
                        System.out.println("Выберите вагон для грузов (1-" + cargoWagons.size() + "):");
                        int wagonIndex = getValidNumber(scanner, 1, cargoWagons.size()) - 1;
                        Cargo maxCargo = cargoWagons.get(wagonIndex).findMaxItem();
                        System.out.println("Самый тяжелый груз: " + (maxCargo != null ? maxCargo : "Вагон пуст."));
                    } 
                    else 
                    {
                        System.out.println("Выберите вагон для пассажиров (1-" + passengerWagons.size() + "):");
                        int wagonIndex = getValidNumber(scanner, 1, passengerWagons.size()) - 1;
                        Passenger oldestPassenger = passengerWagons.get(wagonIndex).findMaxItem();
                        System.out.println("Самый старший пассажир: " + (oldestPassenger != null ? oldestPassenger : "Вагон пуст."));
                    }
                }
                case 5 ->
                {
                    System.out.println("Выход из программы...");
                    running = false;
                }
            }
        }
        scanner.close();
    }
    /**
     * Метод для получения корректного числа из диапазона.
     * 
     * @param scanner объект {@link Scanner} для ввода.
     * @param min     минимально допустимое значение.
     * @param max     максимально допустимое значение.
     * @return Введенное пользователем число в указанном диапазоне.
     */
    private static int getValidNumber(Scanner scanner, int min, int max) 
    {
        while (true) 
        {
            try 
            {
                int number = Integer.parseInt(scanner.nextLine());
                if (number >= min && number <= max) 
                {
                    return number;
                }
                System.out.println("Введите число от " + min + " до " + max + ":");
            } 
            catch (NumberFormatException e)
            {
                System.out.println("Введите корректное число:");
            }
        }
    }
}