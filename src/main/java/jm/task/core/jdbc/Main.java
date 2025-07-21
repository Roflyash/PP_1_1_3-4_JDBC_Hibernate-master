package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Валерий", "Жмышенко", (byte) 54);
        System.out.println("User с именем – Валерий добавлен в базу данных");

        userService.saveUser("Владислав", "Поздняков", (byte) 34);
        System.out.println("User с именем – Владислав добавлен в базу данных");

        userService.saveUser("Илья", "Мэддисон", (byte) 37);
        System.out.println("User с именем – Вячеслав добавлен в базу данных");

        userService.saveUser("Лена", "Головач", (byte) 22);
        System.out.println("User с именем – Лена добавлен в базу данных");

        System.out.println("Все пользователи:");
        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
