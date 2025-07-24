package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        try {
            userService.createUsersTable();
            System.out.println("Таблица users успешно создана");

            userService.saveUser("Валерий", "Жмышенко", (byte) 54);
            System.out.println("User с именем 'Валерий' добавлен в базу данных");

            userService.saveUser("Владислав", "Поздняков", (byte) 34);
            System.out.println("User с именем 'Владислав' добавлен в базу данных");

            userService.saveUser("Илья", "Мэддисон", (byte) 37);
            System.out.println("User с именем 'Илья' добавлен в базу данных");

            userService.saveUser("Лена", "Головач", (byte) 22);
            System.out.println("User с именем 'Лена' добавлен в базу данных");

            System.out.println("\nСписок всех пользователей:");
            userService.getAllUsers().forEach(System.out::println);

            userService.cleanUsersTable();
            System.out.println("\nТаблица users успешно очищена");

            userService.dropUsersTable();
            System.out.println("Таблица users успешно удалена");

        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        } finally {
            Util.shutdown();
        }
    }
}
